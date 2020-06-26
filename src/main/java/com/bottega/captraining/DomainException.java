package com.bottega.captraining;

public class DomainException extends RuntimeException {

    Integer statusCode;

    public DomainException(Integer statusCode) {
        super();
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
