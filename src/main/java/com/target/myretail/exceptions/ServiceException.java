package com.target.myretail.exceptions;

public class ServiceException extends RuntimeException {

	public ServiceException(Throwable e) {
		super(e);
	}
	
	public ServiceException(String e) {
		super(e);
	}

}
