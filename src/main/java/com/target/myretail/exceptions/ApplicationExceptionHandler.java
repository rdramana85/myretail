package com.target.myretail.exceptions;


import java.util.concurrent.ExecutionException;

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
        String errMsg = "{ \"message\": \"Internal server error has occurred\"}";
        return new ResponseEntity<String>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(ProductDataNotFoundException.class)
    public ResponseEntity<String> handleProductDataNotFoundException(Exception ex, WebRequest webRequest) {        
        LOGGER.error("Exception processing request", ex);
        String errMsg = ex.getMessage();
        return new ResponseEntity<String>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(ExecutionException.class)
    public ResponseEntity<String> handleExecutionException(Exception ex, WebRequest webRequest) {        
        LOGGER.error("Exception processing request", ex);
        String errMsg = "{ \"message\": \"Internal server error has occurred\"}";
        if(ex.getCause() instanceof ProductDataNotFoundException){
        	errMsg = ex.getCause().getMessage();
        }
        return new ResponseEntity<String>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
