package com.mubasher.assignment.commons.exceptions.errortypes;

/**
 * @author Mubasher Usman
 */
public interface ApiErrorType<E extends Enum<E>> {

	int getErrorCode();

	String getErrorMessage();

}
