package com.mubasher.assignment.commons.exceptions.errortypes;

/**
 * @author Mubasher Usman
 */
public enum GenericApiErrorType implements ApiErrorType<GenericApiErrorType> {

    APP_VERSION_MISMATCHED(1001, "Application version mismatched. Please contact your administrator." ),
    GENERAL_EXCEPTION(9001, "Something went wrong. Please contact your administrator."),
    RECORD_NOT_FOUND_EXCEPTION(9002, "Record not found."),
    MISSING_REQUIRED_FIELD(9004,"Required fields are missing.");

    private int code;

    private String message;

    GenericApiErrorType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMessage() {
        return message;
    }

}
