package com.mubasher.assignment.domain.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mubasher Usman
 */
public enum PaymentType {

	CREDIT_CARD((short) 1), MOBILE_CARRIER((short) 2),  PAYPALL((short) 3), VOUCHER((short) 4);

	private static Map<Short, PaymentType> valueMap = new HashMap<>();
	static {
		for (PaymentType phase : PaymentType.values()) {
			valueMap.put(phase.getValue(), phase);
		}
	}

	private Short value;

	PaymentType(Short value) {
		this.value = value;
	}

	public Short getValue() {
		return this.value;
	}

	public static PaymentType getByValue(Short value) {
		return valueMap.get(value);
	}

}
