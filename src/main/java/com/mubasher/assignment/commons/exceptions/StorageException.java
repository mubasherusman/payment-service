package com.mubasher.assignment.commons.exceptions;

import com.mubasher.assignment.commons.exceptions.errortypes.ApiErrorType;
import org.springframework.http.HttpStatus;

/**
 * @author Mubasher Usman.
 */
public class StorageException extends BaseException {

	private static final long serialVersionUID = 1L;

	public StorageException(ApiErrorType apiErrorType, Exception e) {
		super(apiErrorType, e, HttpStatus.BAD_REQUEST);
	}

	public StorageException(ApiErrorType apiErrorType) {
		super(apiErrorType, HttpStatus.BAD_REQUEST);
	}

}
