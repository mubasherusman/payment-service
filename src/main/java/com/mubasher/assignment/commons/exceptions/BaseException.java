package com.mubasher.assignment.commons.exceptions;

import com.mubasher.assignment.commons.exceptions.errortypes.ApiErrorType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author Mubasher Usman
 */
@Getter
@Setter
@NoArgsConstructor
public class BaseException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	protected HttpStatus httpStatus;

	protected int appCode;

	protected String appMessage;

	protected BaseException(ApiErrorType apiErrorType, Exception e) {
		super(e);
		appMessage = apiErrorType.getErrorMessage();
		appCode = apiErrorType.getErrorCode();
	}

	protected BaseException(ApiErrorType apiErrorType) {
		super(apiErrorType.getErrorMessage());
		appMessage = apiErrorType.getErrorMessage();
		appCode = apiErrorType.getErrorCode();
	}

	protected BaseException(ApiErrorType apiErrorType, String developerMessage) {
		super(developerMessage);
		appMessage = apiErrorType.getErrorMessage();
		appCode = apiErrorType.getErrorCode();
	}

	protected BaseException(ApiErrorType apiErrorType, HttpStatus httpStatus) {
		super(apiErrorType.getErrorMessage());
		appMessage = apiErrorType.getErrorMessage();
		appCode = apiErrorType.getErrorCode();
		this.httpStatus = httpStatus;
	}

	protected BaseException(ApiErrorType apiErrorType, Exception e,
			HttpStatus httpStatus) {
		super(e);
		appMessage = apiErrorType.getErrorMessage();
		appCode = apiErrorType.getErrorCode();
		this.httpStatus = httpStatus;
	}

	protected BaseException(ApiErrorType apiErrorType, String developerMessage,
			HttpStatus httpStatus) {
		super(developerMessage);
		appMessage = apiErrorType.getErrorMessage();
		appCode = apiErrorType.getErrorCode();
		this.httpStatus = httpStatus;
	}

}
