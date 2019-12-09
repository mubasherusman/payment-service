package com.mubasher.assignment.domain.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author Mubasher Usman
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BooleanResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean success;

	private String message;

	public static BooleanResponse success() {
		return success("Operation Successful");
	}

	public static BooleanResponse success(String message) {
		return new BooleanResponse(Boolean.TRUE, message);
	}

	public static BooleanResponse failure(String message) {
		return new BooleanResponse(Boolean.FALSE, message);
	}

	public static BooleanResponse failure() {
		return failure("Operation Failed");
	}

}
