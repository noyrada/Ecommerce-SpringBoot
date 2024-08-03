package com.project.samplecrud_sb.model.response.errors;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

    private String message;

    private Short status;

    public ErrorResponse(String message, Short status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Short getStatus() {
        return status;
    }
}
