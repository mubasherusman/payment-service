package com.mubasher.assignment.domain.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mubasher Usman.
 */
public enum CurrencyCode {

	USD((short) 1), SAR((short) 2);

	private static Map<Short, CurrencyCode> valueMap = new HashMap<>();
	static {
		for (CurrencyCode type : CurrencyCode.values()) {
			valueMap.put(type.getValue(), type);
		}
	}

	private Short value;

	CurrencyCode(Short value) {
		this.value = value;
	}

	public Short getValue() {
		return this.value;
	}

	public static CurrencyCode getByValue(Short value) {
		return valueMap.get(value);
	}

}
