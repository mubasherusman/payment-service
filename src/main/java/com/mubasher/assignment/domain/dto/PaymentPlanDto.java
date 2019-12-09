package com.mubasher.assignment.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mubasher.assignment.domain.entity.BaseEntity;
import com.mubasher.assignment.domain.enums.CurrencyCode;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author Mubasher Usman
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPlanDto {

	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private Long id;

	@NotNull(message = "Net Amount can not be null")
	private BigDecimal netAmount;

	@NotNull(message = "Tax Amount can not be null")
	private BigDecimal taxAmount;

	@NotNull(message = "Gross Amount can not be null")
	private BigDecimal grossAmount;

	@NotNull(message = "Currency can not be null")
	private CurrencyCode currency;

	@NotNull(message = "Duration can not be null")
	private String duration;

}
