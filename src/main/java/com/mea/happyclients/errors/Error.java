package com.mea.happyclients.errors;

/**
 * Provides a mechanism for passing errors around the application
 */
public class Error {

    private int errorCode;
    private String errorMessage;

    public Error(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    String getErrorMessage() {
        return errorMessage;
    }

    public boolean isOk() {
        return errorCode == Errors.ERR_OK;
    }

}
