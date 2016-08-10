package com.target.myretail.transformer;

import org.springframework.http.ResponseEntity;

public interface Transformer<T> {
	
	public ResponseEntity<String> transform (T t);

}
