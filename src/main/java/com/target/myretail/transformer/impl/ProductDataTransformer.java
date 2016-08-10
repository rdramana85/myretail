package com.target.myretail.transformer.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.target.myretail.model.ProductData;
import com.target.myretail.transformer.Transformer;

@Component
public class ProductDataTransformer implements Transformer<ProductData> {

	@Override
	public ResponseEntity<String> transform(ProductData productData) {
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode productNode = mapper.createObjectNode();
		productNode.put("productId", productData.getProductId());
		ObjectNode nameNode = mapper.createObjectNode();
		nameNode.put("name",productData.getProductAttributeData().getProductName());
		productNode.setAll(nameNode);
		ObjectNode priceNode = mapper.createObjectNode();		
		ObjectNode priceDataNode = mapper.createObjectNode();		
		priceDataNode.put("value", productData.getProductPriceData().getPrice());
		priceDataNode.put("currency_code", productData.getProductPriceData().getCurrencyCode());
		priceNode.set("current_price", priceDataNode);
		ObjectNode rootNode = mapper.createObjectNode();
		rootNode.setAll(productNode);
		rootNode.setAll(priceNode);
		return new ResponseEntity<String>(rootNode.toString(),HttpStatus.OK);
	}

}
