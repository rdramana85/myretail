package com.target.myretail.service;

import java.util.concurrent.ExecutionException;

import com.target.myretail.model.ProductData;

public interface ProductDataAggregationService {
	
	public ProductData getProductPriceData(Long productId) throws InterruptedException, ExecutionException;
	
}
