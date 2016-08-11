package com.target.myretail.service.impl;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.target.myretail.exceptions.ServiceException;
import com.target.myretail.model.ProductAttributeData;
import com.target.myretail.model.ProductData;
import com.target.myretail.model.ProductPriceData;
import com.target.myretail.service.ProductAttributeService;
import com.target.myretail.service.ProductDataAggregationService;
import com.target.myretail.service.ProductPriceService;

@Component
public class ProductDataAggregationServiceImpl implements
		ProductDataAggregationService {

	@Autowired
	@Qualifier("productAttributeService")
	private ProductAttributeService productAttributeService;

	@Autowired
	@Qualifier("productPriceService")
	private ProductPriceService productPriceService;

	@Override
	public ProductData getProductPriceData(Long productId) throws InterruptedException, ExecutionException {
		ProductData productData = new ProductData();
		ListenableFuture<ResponseEntity<ProductAttributeData>> future = productAttributeService
				.getProductAttributeData(productId);
		ResponseEntity<ProductAttributeData> productAttributeData = null;
		ProductPriceData priceData = productPriceService
				.getCurentPrice(productId);
		productData.setProductPriceData(priceData);
		productAttributeData = future.get();
		productData.setProductId(productId);
		productData.setProductAttributeData(productAttributeData.getBody());
		return productData;
	}

}
