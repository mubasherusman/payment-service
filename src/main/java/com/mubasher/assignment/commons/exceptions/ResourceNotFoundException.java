package com.mubasher.assignment.commons.exceptions;

import com.mubasher.assignment.commons.exceptions.errortypes.ApiErrorType;
import org.springframework.http.HttpStatus;

/**
 * @author Mubasher Usman
 */
public class ResourceNotFoundException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(ApiErrorType apiErrorType, Exception e) {
		super(apiErrorType, e, HttpStatus.NOT_FOUND);
	}

	public ResourceNotFoundException(ApiErrorType apiErrorType) {
		super(apiErrorType, HttpStatus.NOT_FOUND);
	}

}
