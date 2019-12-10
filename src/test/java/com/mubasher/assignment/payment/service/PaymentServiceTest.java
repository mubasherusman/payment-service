package com.mubasher.assignment.payment.service;

import com.mubasher.assignment.domain.dto.ListResponse;
import com.mubasher.assignment.domain.dto.PaymentMethodDto;
import com.mubasher.assignment.domain.dto.PaymentMethodSearchRequest;
import com.mubasher.assignment.domain.dto.PaymentPlanDto;
import com.mubasher.assignment.domain.entity.PaymentMethod;
import com.mubasher.assignment.domain.entity.PaymentPlan;
import com.mubasher.assignment.domain.enums.CurrencyCode;
import com.mubasher.assignment.domain.enums.PaymentType;
import com.mubasher.assignment.domain.mapper.PaymentMethodMapper;
import com.mubasher.assignment.domain.mapper.PaymentPlanMapper;
import com.mubasher.assignment.payment.repository.IPaymentMethodRepository;
import com.mubasher.assignment.payment.repository.IPaymentPlanRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

/**
 * @author Mubasher Usman
 */
@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

	@InjectMocks
	private PaymentMethodService paymentMethodService;

	@Mock
	private IPaymentMethodRepository pmRepository;

	@Mock
	private IPaymentPlanRepository ppRepository;

	@Mock
	private PaymentMethodMapper mapper;

	@Mock
	private PaymentPlanMapper paymentPlanMapper;

	@Test
	public void createPaymentMethodTest() {
		PaymentMethod paymentMethod = getPaymentMethod();

		Mockito.when(pmRepository.saveAndFlush(any())).thenReturn(paymentMethod);
		Mockito.when(mapper.mapFrom(any(PaymentMethodDto.class)))
				.thenReturn(paymentMethod);
		Mockito.when(mapper.mapTo(any(PaymentMethod.class)))
				.thenReturn(getPaymentMethodDto());

		PaymentMethodDto result = paymentMethodService
				.createPaymentMethod(getPaymentMethodDto());

		Mockito.verify(pmRepository, Mockito.times(1)).saveAndFlush(any());

		Assert.assertNotNull(result);
	}

	@Test
	public void updatePaymentMethodTest() {
		PaymentMethod paymentMethod = getPaymentMethod();

		Mockito.when(pmRepository.findById(any())).thenReturn(Optional.of(paymentMethod));
		Mockito.when(pmRepository.saveAndFlush(any())).thenReturn(paymentMethod);
		Mockito.when(paymentPlanMapper.mapFrom(any(PaymentPlanDto.class)))
				.thenReturn(getPaymentPlan());
		Mockito.when(mapper.mapTo(any(PaymentMethod.class)))
				.thenReturn(getPaymentMethodDto());

		PaymentMethodDto result = paymentMethodService
				.updatePaymentMethod(getPaymentMethodDto());

		Mockito.verify(pmRepository, Mockito.times(1)).saveAndFlush(any());

		Assert.assertNotNull(result);
	}

	@Test
	public void searchByNamePaymentMethodTest() {
		List paymentMethod = Arrays.asList(getPaymentMethod());
		List paymentMethodDto = Arrays.asList(getPaymentMethodDto());

		Mockito.when(pmRepository.findAll(any(Example.class))).thenReturn(paymentMethod);
		Mockito.when(mapper.mapListTo(any())).thenReturn(paymentMethodDto);

		ListResponse result = paymentMethodService.searchPaymentMethod(
				PaymentMethodSearchRequest.builder().name("credi card").build());

		Mockito.verify(pmRepository, Mockito.times(1)).findAll(any(Example.class));

		Assert.assertNotNull(result);
	}

	@Test
	public void searchByIdPaymentMethodTest() {
		Mockito.when(ppRepository.findById(anyLong()))
				.thenReturn(Optional.of(getPaymentPlan()));
		Mockito.when(mapper.mapToWithoutPaymentPlan(any()))
				.thenReturn(getPaymentMethodDto());
		Mockito.when(paymentPlanMapper.mapTo(any())).thenReturn(getPaymentPlansDto());

		ListResponse result = paymentMethodService
				.searchPaymentMethod(PaymentMethodSearchRequest.builder().id(1L).build());

		Mockito.verify(ppRepository, Mockito.times(1)).findById(anyLong());

		Assert.assertNotNull(result);
	}

	@Test
	public void searchAllPaymentMethodTest() {
		List paymentMethod = Arrays.asList(getPaymentMethod());
		List paymentMethodDto = Arrays.asList(getPaymentMethodDto());
		Mockito.when(pmRepository.findAll()).thenReturn(paymentMethod);
		Mockito.when(mapper.mapListTo(any())).thenReturn(paymentMethodDto);

		ListResponse result = paymentMethodService
				.searchPaymentMethod(PaymentMethodSearchRequest.builder().build());

		Mockito.verify(pmRepository, Mockito.times(1)).findAll();

		Assert.assertNotNull(result);
	}

	private PaymentMethodDto getPaymentMethodDto() {
		PaymentMethodDto dto = new PaymentMethodDto();
		dto.setDisplayName("Credit Card");
		dto.setName("Credit Card");
		dto.setPaymentType(PaymentType.CREDIT_CARD);
		List<PaymentPlanDto> list = new ArrayList<>(Arrays.asList(getPaymentPlansDto()));
		dto.setPaymentPlans(list);
		dto.setId(1L);
		return dto;
	}

	private PaymentPlanDto getPaymentPlansDto() {
		PaymentPlanDto dto = new PaymentPlanDto();
		dto.setCurrency(CurrencyCode.USD);
		dto.setDuration("Monthly");
		dto.setGrossAmount(new BigDecimal(20.00));
		dto.setTaxAmount(new BigDecimal(2.00));
		dto.setNetAmount(new BigDecimal(18.00));
		dto.setId(72L);
		return dto;
	}

	private PaymentMethod getPaymentMethod() {
		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setDisplayName("Credit Card");
		paymentMethod.setName("Credit Card");
		paymentMethod.setPaymentType(PaymentType.CREDIT_CARD);
		List<PaymentPlan> list = new ArrayList<>(Arrays.asList(getPaymentPlan()));
		paymentMethod.setPaymentPlans(list);
		paymentMethod.setId(1L);
		return paymentMethod;
	}

	private PaymentPlan getPaymentPlan() {
		PaymentPlan paymentPlan = new PaymentPlan();
		paymentPlan.setCurrency(CurrencyCode.USD);
		paymentPlan.setDuration("Monthly");
		paymentPlan.setGrossAmount(new BigDecimal(20.00));
		paymentPlan.setTaxAmount(new BigDecimal(2.00));
		paymentPlan.setNetAmount(new BigDecimal(18.00));
		paymentPlan.setId(72L);
		return paymentPlan;
	}

}
