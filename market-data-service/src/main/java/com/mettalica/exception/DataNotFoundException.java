package com.mettalica.exception;

public class DataNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    private String errCode;
    private String errMsg;

    public DataNotFoundException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

    public DataNotFoundException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}