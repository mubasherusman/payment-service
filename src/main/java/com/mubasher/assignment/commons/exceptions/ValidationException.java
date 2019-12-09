package com.mubasher.assignment.commons.exceptions;

import com.mubasher.assignment.commons.exceptions.errortypes.ApiErrorType;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author Mubasher Usman
 */

@NoArgsConstructor
public class ValidationException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ValidationException(ApiErrorType apiErrorType, Exception e) {
		super(apiErrorType, e, HttpStatus.BAD_REQUEST);
	}

	public ValidationException(ApiErrorType apiErrorType, String developerMessage) {
		super(apiErrorType, developerMessage, HttpStatus.BAD_REQUEST);
	}

	public ValidationException(ApiErrorType apiErrorType) {
		super(apiErrorType, HttpStatus.BAD_REQUEST);
	}

}
