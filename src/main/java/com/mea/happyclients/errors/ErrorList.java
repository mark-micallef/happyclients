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

    public void addError(Error error) {
        errors.add(error);
    }

    public void addError(int errorCode, String errorMessage) {
        addError(new Error(errorCode, errorMessage));
    }

    public void mergeErrorLists(ErrorList errorListToMerge) {
        List<Error> list = errorListToMerge.getErrors();
        for (Error error : list) {
            addError(error);
        }
    }

    public String toHtmlString() {
        String html = "";

        for (Error error : errors) {
            html += error.getErrorCode() + ": " + error.getErrorMessage() + "<BR/>";
        }

        html += "<BR/>";

        return html;
    }

    public boolean isOk() {
        boolean result = true;

        for (Error error : errors) {
            result = result & error.isOk();
        }

        return result;
    }

}
