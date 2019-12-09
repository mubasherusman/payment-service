package com.mubasher.assignment.commons.exceptions;

import com.mubasher.assignment.commons.exceptions.errortypes.GenericApiErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mubasher Usman
 */
@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * handles {@link ValidationException} exceptions
	 * @param ex an instance of {@link ValidationException}
	 * @return an instance of {@link ExceptionResponse}
	 */
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ExceptionResponse handleInvalidValueException(final ValidationException ex) {
		log.error("Exception : ", ex);
		return new ExceptionResponse(ex.getAppMessage(), ex.getMessage(),
				HttpStatus.BAD_REQUEST.value(), ex.getAppCode());
	}


	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ExceptionResponse handleInvalidValueException(final MethodArgumentNotValidException ex) {
		log.error("Exception : ", ex);
		if(ex.getBindingResult().hasFieldErrors()) {
			List<FieldError> errors = ex.getBindingResult().getFieldErrors();
			List<String> er = errors.stream().map(e->e.getDefaultMessage()).collect(Collectors.toList());
			return new ExceptionResponse(GenericApiErrorType.MISSING_REQUIRED_FIELD.getErrorMessage(),er.toString(),
			HttpStatus.BAD_REQUEST.value(), GenericApiErrorType.MISSING_REQUIRED_FIELD.getErrorCode());
		} else {
			return new ExceptionResponse(GenericApiErrorType.MISSING_REQUIRED_FIELD.getErrorMessage(),ex.getMessage(),
			HttpStatus.BAD_REQUEST.value(), GenericApiErrorType.MISSING_REQUIRED_FIELD.getErrorCode());
		}
	}

	/**
	 * handles {@link ResourceNotFoundException} exceptions
	 * @param ex an instance of {@link ResourceNotFoundException}
	 * @return an instance of {@link ExceptionResponse}
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ExceptionResponse handleEntityNotFoundException(
			final ResourceNotFoundException ex) {
		log.error("Exception : ", ex);
		return new ExceptionResponse(ex.getAppMessage(), ex.getMessage(),
				HttpStatus.NOT_FOUND.value(), ex.getAppCode());

	}

	/**
	 * handles {@link Exception} exceptions
	 * @param ex an instance of {@link Exception}
	 * @return an instance of {@link ExceptionResponse}
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ExceptionResponse handleEntityNotFoundException(final Exception ex) {
		log.error("Exception : ", ex);
		return new ExceptionResponse(
				GenericApiErrorType.GENERAL_EXCEPTION.getErrorMessage(), ex.getMessage(),
				HttpStatus.BAD_REQUEST.value(),
				GenericApiErrorType.GENERAL_EXCEPTION.getErrorCode());

	}

}
