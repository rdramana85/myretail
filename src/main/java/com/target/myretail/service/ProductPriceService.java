package com.target.myretail.service;

import java.util.concurrent.ExecutionException;

import com.target.myretail.model.ProductPriceData;

public interface ProductPriceService {
	
	public ProductPriceData getCurentPrice(Long productId) ;
	
}
