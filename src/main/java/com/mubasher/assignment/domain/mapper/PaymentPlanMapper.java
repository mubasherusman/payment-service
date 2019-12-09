package com.mubasher.assignment.domain.mapper;

import com.mubasher.assignment.domain.dto.PaymentPlanDto;
import com.mubasher.assignment.domain.entity.PaymentPlan;
import org.mapstruct.Mapper;

/**
 * @author Mubasher Usman
 *
 * Mapper class to map {@link PaymentPlan} to {@link PaymentPlanDto}
 */
@Mapper(componentModel = "spring")
public interface PaymentPlanMapper {

	/**
	 * Maps a {@link PaymentPlan} to a{@link PaymentPlanDto}
	 * @param paymentPlan an instance of {@link PaymentPlan}
	 * @return an instance of {@link PaymentPlanDto}
	 */
	PaymentPlanDto mapTo(PaymentPlan paymentPlan);

	/**
	 * Maps a {@link PaymentPlanDto} to a{@link PaymentPlan}
	 * @param paymentPlanDto an instance of {@link PaymentPlanDto}
	 * @return an instance of {@link PaymentPlan}
	 */
	PaymentPlan mapFrom(PaymentPlanDto paymentPlanDto);

}
