package com.mettalica.exception;

public class ServiceException extends Exception {


	private static final long serialVersionUID = 1L;
	private String errCode;
    private String errMsg;

    public ServiceException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

    public ServiceException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
