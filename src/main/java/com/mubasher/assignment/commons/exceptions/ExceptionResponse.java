package com.mubasher.assignment.commons.exceptions;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Mubasher Usman
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExceptionResponse implements Serializable {

	private String message;

	private String developerMessage;

	private int status;

	private int errorCode;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime timeStamp;

	public ExceptionResponse(String message, String developerMessage, int statusCode,
			int errorCode) {
		this.message = message;
		this.status = statusCode;
		this.errorCode = errorCode;
		// Set timestamp in class constructor itself rather than passing as parameter.
		this.timeStamp = LocalDateTime.now();
		this.developerMessage = developerMessage;
	}

}
