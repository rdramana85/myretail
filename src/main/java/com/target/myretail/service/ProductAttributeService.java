package com.target.myretail.service;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;

import com.target.myretail.model.ProductAttributeData;

public interface ProductAttributeService {
	
	public ListenableFuture<ResponseEntity<ProductAttributeData>> getProductAttributeData(Long productId);

}
