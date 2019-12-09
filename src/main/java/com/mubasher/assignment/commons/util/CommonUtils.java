package com.mubasher.assignment.commons.util;

import com.mubasher.assignment.commons.exceptions.ValidationException;
import com.mubasher.assignment.commons.exceptions.errortypes.ApiErrorType;
import com.mubasher.assignment.commons.exceptions.errortypes.GenericApiErrorType;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CommonUtils {

	/**
	 * Checks a UUID value and returns true if it is equal to empty or null
	 * @param value Long value
	 */
	public static boolean isEmpty(UUID value) {
		return value == null || value.toString().isEmpty();
	}

	/**
	 * Checks a long value and returns true if it is equal to 0 or is negative or null
	 * @param value Long value
	 */
	public static boolean isEmpty(Long value) {
		return value == null || value <= 0;
	}

	/**
	 * Checks a string value and returns true if it is null or empty
	 * @param value string value
	 * @return boolean
	 */
	public static boolean isEmpty(String value) {
		return value == null || "".equals(value);
	}

	/**
	 * Checks a Date value and returns true if it is null
	 * @param value Date value
	 * @return boolean
	 */
	public static boolean isEmpty(LocalDateTime value) {
		return value == null;
	}

	/**
	 * Checks a Date value and returns ture if it is null
	 * @param value Date value
	 * @return boolean
	 */
	public static boolean isEmpty(Date value) {
		return value == null;
	}

	/**
	 * Checks a Integer value and returns true if it is null
	 * @param value Integer value
	 * @return boolean
	 */
	public static boolean isEmpty(Integer value) {
		return value == null || value <= 0;
	}

	public static boolean isEmpty(Byte value) {
		return value == null || value < 0;
	}

	/**
	 * Checks a List object and returns tru if it is null or empty
	 * @param value as a {@link List)
	 * @return boolean
	 */
	public static boolean isEmpty(List value) {
		return value == null || value.isEmpty();
	}

	public static void checkRequired(Object obj, ApiErrorType errorType) {
		if (Objects.isNull(obj)) {
			throw new ValidationException(errorType);
		}
	}

	public static void checkRequired(Date date, ApiErrorType errorType) {
		if (isEmpty(date)) {
			throw new ValidationException(errorType);
		}
	}

	public static void checkRequired(List list, ApiErrorType errorType) {
		if (isEmpty(list)) {
			throw new ValidationException(errorType);
		}
	}

	public static void checkRequired(String value, ApiErrorType errorType) {
		if (isEmpty(value)) {
			throw new ValidationException(errorType);
		}
	}

	public static void checkRequired(Long value, ApiErrorType errorType) {
		if (isEmpty(value)) {
			throw new ValidationException(errorType);
		}
	}

	public static void checkRequired(Byte value) {
		if (isEmpty(value)) {
			throw new ValidationException(GenericApiErrorType.MISSING_REQUIRED_FIELD);
		}
	}

	public static void checkRequired(Integer value) {
		if (isEmpty(value)) {
			throw new ValidationException(GenericApiErrorType.MISSING_REQUIRED_FIELD);
		}
	}

	private CommonUtils() {
	}

	public static void checkObject(Object object, ApiErrorType errorType) {
		if (Objects.isNull(object)) {
			throw new ValidationException(errorType);
		}
	}

	public static boolean checkObject(Object object) {
		return Objects.isNull(object);
	}

	public static void checkRequired(short value, ApiErrorType errorType) {
		if (isEmpty(value)) {
			throw new ValidationException(errorType);
		}
	}

	public static boolean isEmpty(short value) {
		return value <= 0;
	}

}
