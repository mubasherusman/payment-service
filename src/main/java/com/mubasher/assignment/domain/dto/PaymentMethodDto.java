package com.mubasher.assignment.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mubasher.assignment.domain.enums.PaymentType;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Mubasher Usman
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodDto {

	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private Long id;

	// We can also use here i18n for multilingual support.
	@NotNull(message = "Name can not be null")
	@Size(max = 255, message = "Name must be less than 256 characters")
	private String name;

	@NotNull(message = "Display Name can not be null")
	@Size(max = 255, message = "Display Name must be less than 256 characters")
	private String displayName;

	@NotNull(message = "Payment Type can not be null")
	private PaymentType paymentType;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<@Valid PaymentPlanDto> paymentPlans;

}
