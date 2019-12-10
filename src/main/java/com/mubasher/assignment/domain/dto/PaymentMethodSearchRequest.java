package com.mubasher.assignment.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodSearchRequest {

	private Long id;

	private String name;

}
