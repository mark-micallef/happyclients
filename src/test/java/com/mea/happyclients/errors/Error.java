package com.mea.happyclients.errors;

/**
 * Provides an interface for passing errors around the application
 */
public interface Error {

    int getErrorCode();
    String getErrorMessage();

}
