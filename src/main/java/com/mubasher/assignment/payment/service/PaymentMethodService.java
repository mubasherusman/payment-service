package com.mubasher.assignment.payment.service;

import com.mubasher.assignment.commons.exceptions.ResourceNotFoundException;
import com.mubasher.assignment.commons.exceptions.errortypes.GenericApiErrorType;
import com.mubasher.assignment.commons.util.CommonUtils;
import com.mubasher.assignment.domain.dto.ListResponse;
import com.mubasher.assignment.domain.dto.PaymentMethodDto;
import com.mubasher.assignment.domain.dto.PaymentMethodSearchRequest;
import com.mubasher.assignment.domain.dto.PaymentPlanDto;
import com.mubasher.assignment.domain.entity.PaymentMethod;
import com.mubasher.assignment.domain.entity.PaymentPlan;
import com.mubasher.assignment.domain.mapper.PaymentMethodMapper;
import com.mubasher.assignment.domain.mapper.PaymentPlanMapper;
import com.mubasher.assignment.payment.repository.IPaymentMethodRepository;
import com.mubasher.assignment.payment.repository.IPaymentPlanRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaymentMethodService implements IPaymentMethodService {

	@Autowired
	private IPaymentMethodRepository pmRepository;

	@Autowired
	private IPaymentPlanRepository ppRepository;

	@Autowired
	private PaymentMethodMapper mapper;

	@Autowired
	private PaymentPlanMapper paymentPlanMapper;

	@Override
	public ListResponse searchPaymentMethod(PaymentMethodSearchRequest request) {
		if (!StringUtils.isEmpty(request.getName())) {
			List<PaymentMethod> paymentMethods = pmRepository.findAll(
					Example.of(PaymentMethod.builder().name(request.getName()).build()));
			List<PaymentMethodDto> result = mapper.mapListTo(paymentMethods);
			return ListResponse.<PaymentMethodDto>builder().content(result).build();
		}
		else if (!CommonUtils.isEmpty(request.getId())) {
			PaymentPlan paymentPlan = ppRepository.findById(request.getId())
					.orElseThrow(() -> new ResourceNotFoundException(
							GenericApiErrorType.RECORD_NOT_FOUND_EXCEPTION));
			PaymentPlanDto paymentPlanDto = paymentPlanMapper.mapTo(paymentPlan);
			PaymentMethodDto paymentMethodDto = mapper
					.mapToWithoutPaymentPlan(paymentPlan.getPaymentMethod());
			paymentMethodDto.setPaymentPlans(Arrays.asList(paymentPlanDto));
			return ListResponse.builder().content(Arrays.asList(paymentMethodDto))
					.build();
		}
		else {
			List<PaymentMethod> paymentMethods = pmRepository.findAll();
			List<PaymentMethodDto> result = mapper.mapListTo(paymentMethods);
			return ListResponse.<PaymentMethodDto>builder().content(result).build();
		}
	}

	@Override
	public PaymentMethodDto createPaymentMethod(PaymentMethodDto requestDto) {
		CommonUtils.checkRequired(requestDto, GenericApiErrorType.MISSING_REQUIRED_FIELD);
		final PaymentMethod paymentMethod = mapper.mapFrom(requestDto);
		paymentMethod.setId(null);
		if (paymentMethod.getPaymentPlans() != null
				&& !paymentMethod.getPaymentPlans().isEmpty()) {
			paymentMethod.getPaymentPlans().forEach(e -> {
				e.setId(null);
				e.setPaymentMethod(paymentMethod);
			});
		}
		pmRepository.saveAndFlush(paymentMethod);
		return mapper.mapTo(paymentMethod);
	}

	@Override
	public PaymentMethodDto updatePaymentMethod(PaymentMethodDto requestDto) {
		CommonUtils.checkRequired(requestDto, GenericApiErrorType.MISSING_REQUIRED_FIELD);
		validate(requestDto);
		PaymentMethod paymentMethod = pmRepository.findById(requestDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						GenericApiErrorType.RECORD_NOT_FOUND_EXCEPTION));
		copyProps(requestDto, paymentMethod);
		pmRepository.saveAndFlush(paymentMethod);
		return mapper.mapTo(paymentMethod);
	}

	private void copyProps(PaymentMethodDto requestDto, PaymentMethod paymentMethod) {
		paymentMethod.setDisplayName(requestDto.getDisplayName());
		paymentMethod.setName(requestDto.getName());
		paymentMethod.setPaymentType(paymentMethod.getPaymentType());
		if (requestDto.getPaymentPlans() == null
				|| requestDto.getPaymentPlans().isEmpty()) {
			paymentMethod.getPaymentPlans().clear();
		}
		else {
			paymentMethod.getPaymentPlans().clear();
			requestDto.getPaymentPlans().forEach(e -> {
				PaymentPlan paymentPlan = paymentPlanMapper.mapFrom(e);
				paymentPlan.setPaymentMethod(paymentMethod);
				paymentMethod.getPaymentPlans().add(paymentPlan);
			});
		}
	}

	private void validate(PaymentMethodDto paymentMethod) {
		CommonUtils.checkRequired(paymentMethod.getId(),
				GenericApiErrorType.MISSING_REQUIRED_FIELD);
		if (paymentMethod.getPaymentPlans() != null
				&& !paymentMethod.getPaymentPlans().isEmpty()) {
			paymentMethod.getPaymentPlans().forEach(e -> {
				CommonUtils.checkRequired(e.getId(),
						GenericApiErrorType.MISSING_REQUIRED_FIELD);
			});
		}
	}

}
