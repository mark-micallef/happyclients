package com.mea.happyclients.errors;

import java.util.ArrayList;
import java.util.List;

/**
 * Aggregates multiple errors
 */
public class ErrorList {

    private List<Error> errors;

    public ErrorList() {
        errors = new ArrayList<>();
    }

    public List<Error> getErrors() {
        return errors;
    }

}
