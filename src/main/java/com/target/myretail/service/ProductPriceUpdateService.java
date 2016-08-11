package com.target.myretail.service;

import org.springframework.http.ResponseEntity;

import com.target.myretail.model.ProductPriceData;

public interface ProductPriceUpdateService {
	
	public ResponseEntity<String> updatePrice(Long productId,ProductPriceData priceData) throws Exception;
	
}
