package com.mubasher.assignment.domain.entity;

import com.mubasher.assignment.domain.enums.PaymentType;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Mubasher Usman
 */
@Entity
@Table(name = "payment_method")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod extends BaseEntity {

	private String name;

	private String displayName;

	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentMethod", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PaymentPlan> paymentPlans;

}
