package com.target.myretail.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;


	
	public class ValidationErrorBuilder {

	    public static ValidationErrors fromBindingErrors(Errors errors) {
	        ValidationErrors error = new ValidationErrors("Validation failed. " + errors.getErrorCount() + " error(s)");
	        for (ObjectError objectError : errors.getAllErrors()) {
	            error.addValidationError(objectError.getDefaultMessage());
	        }
	        return error;
	    }
	}
	

