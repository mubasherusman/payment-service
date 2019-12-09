package com.mubasher.assignment.payment.service;

import com.mubasher.assignment.domain.dto.ListResponse;
import com.mubasher.assignment.domain.dto.PaymentMethodDto;
import com.mubasher.assignment.domain.dto.PaymentMethodSearchRequest;

public interface IPaymentMethodService {

	ListResponse searchPaymentMethod(PaymentMethodSearchRequest request);

	PaymentMethodDto addPaymentMethod(PaymentMethodDto requestDto);

	PaymentMethodDto updatePaymentMethod(PaymentMethodDto requestDto);

}
