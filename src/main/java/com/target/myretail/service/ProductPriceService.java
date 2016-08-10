package com.target.myretail.service;

import com.target.myretail.model.ProductPriceData;

public interface ProductPriceService {
	
	public ProductPriceData getCurentPrice(Long productId) throws Exception;
	
}
