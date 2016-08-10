package com.target.myretail.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApplicationExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleDefaultException(Exception ex, WebRequest webRequest) {        
        LOGGER.error("Exception processing request", ex);
        return new ResponseEntity<String>("{ \"message\": \"Internal server error has occurred\"}", HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
