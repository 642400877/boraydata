package com.boraydata.hygiene.common.excention;

public class BusinessException extends RuntimeException {

    private String message;

    public BusinessException(String message) {
        super(message);
    }

}
