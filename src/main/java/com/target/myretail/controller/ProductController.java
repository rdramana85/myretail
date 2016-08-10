package com.target.myretail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.target.myretail.service.ProductDataAggregationService;
import com.target.myretail.transformer.Transformer;

@RestController
@RequestMapping("/myretail")
public class ProductController {

	@Autowired
	private ProductDataAggregationService productDataAggregationService;
	
	@Autowired
	private Transformer transformer;
	
	@RequestMapping(value="v1/products/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getProductNameAndPriceData(@PathVariable("id") Long productId) throws Exception{
		return transformer.transform(productDataAggregationService.getProductPriceData(productId));
	}
	
}
