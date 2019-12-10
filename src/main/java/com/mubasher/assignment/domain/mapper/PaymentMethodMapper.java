package com.mubasher.assignment.domain.mapper;

import com.mubasher.assignment.domain.dto.PaymentMethodDto;
import com.mubasher.assignment.domain.entity.PaymentMethod;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

/**
 * @author Mubasher Usman
 *
 * Mapper class to map {@link PaymentMethod} to {@link PaymentMethodDto}
 */
@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {

	/**
	 * Maps a {@link PaymentMethod} to a{@link PaymentMethodDto}
	 * @param paymentMethod an instance of {@link PaymentMethod}
	 * @return an instance of {@link PaymentMethodDto}
	 */
	@Named("fullMap")
	PaymentMethodDto mapTo(PaymentMethod paymentMethod);

	@Mapping(ignore = true, source = "paymentPlans", target = "paymentPlans")
	PaymentMethodDto mapToWithoutPaymentPlan(PaymentMethod paymentMethod);

	/**
	 * Maps a {@link PaymentMethodDto} to a{@link PaymentMethod}
	 * @param paymentMethodDto an instance of {@link PaymentMethodDto}
	 * @return an instance of {@link PaymentMethod}
	 */
	PaymentMethod mapFrom(PaymentMethodDto paymentMethodDto);

	/**
	 * Maps a {@link PaymentMethod} to a{@link PaymentMethodDto}
	 * @param paymentMethod an instance of {@link PaymentMethod}
	 * @return an instance of {@link PaymentMethodDto}
	 */
	@IterableMapping(qualifiedByName = "fullMap")
	List<PaymentMethodDto> mapListTo(List<PaymentMethod> paymentMethod);

	/**
	 * Maps a {@link PaymentMethodDto} to a{@link PaymentMethod}
	 * @param paymentMethodDto an instance of {@link PaymentMethodDto}
	 * @return an instance of {@link PaymentMethod}
	 */
	List<PaymentMethod> mapListFrom(List<PaymentMethodDto> paymentMethodDto);

}
