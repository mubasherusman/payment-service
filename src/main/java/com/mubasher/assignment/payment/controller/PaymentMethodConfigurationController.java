package com.mubasher.assignment.payment.controller;

import com.mubasher.assignment.domain.dto.ListResponse;
import com.mubasher.assignment.domain.dto.PaymentMethodSearchRequest;
import com.mubasher.assignment.domain.dto.PaymentMethodDto;
import com.mubasher.assignment.payment.service.IPaymentMethodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Mubasher Usman.
 */
@Api(tags = { "Payment Methods Controller" })
@RestController
@RequestMapping("api/v{apiVersion}/configuration/payment-method")
@CrossOrigin("*")
public class PaymentMethodConfigurationController {

	@Autowired
	private IPaymentMethodService paymentMethodService;

	/**
	 * Get All Payment Methods Or Search by id of Payment plans or Payment Method Name
	 * @return a response list of {@link PaymentMethodDto}
	 */
	@GetMapping
	@ApiOperation(value = "Get payment methods by search criteria or get all.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Success", response = PaymentMethodDto.class) })
	public ListResponse searchPaymentMethods(PaymentMethodSearchRequest request) {
		return paymentMethodService.searchPaymentMethod(request);
	}

	/**
	 * Add New Payment Methods
	 * @return a response list of {@link PaymentMethodDto}
	 */
	@PostMapping
	@ApiOperation(value = "Add new payment method.")
	@ApiResponses({
			@ApiResponse(code = 201, message = "Success", response = PaymentMethodDto.class) })
	public PaymentMethodDto addPaymentMethod(
			@RequestBody @Valid PaymentMethodDto request) {
		return paymentMethodService.createPaymentMethod(request);
	}

	/**
	 * Update Payment Method
	 * @return a response list of {@link PaymentMethodDto}
	 */
	@PutMapping
	@ApiOperation(value = "Update payment method.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Success", response = PaymentMethodDto.class) })
	public PaymentMethodDto updatePaymentMethod(
			@RequestBody @Valid PaymentMethodDto request) {
		return paymentMethodService.updatePaymentMethod(request);
	}

}
