package com.mubasher.assignment.domain.entity;

import com.mubasher.assignment.domain.enums.CurrencyCode;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

/**
 * @author Mubasher Usman
 */
@Entity
@Table(name = "payment_plan")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPlan extends BaseEntity {

	private BigDecimal netAmount;

	private BigDecimal taxAmount;

	private BigDecimal grossAmount;

	@Enumerated(value = EnumType.STRING)
	private CurrencyCode currency;

	private String duration;

	@Column(updatable = false, insertable = false)
	private Long paymentMethodId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paymentMethodId", referencedColumnName = "id")
	private PaymentMethod paymentMethod;

}
