package com.target.myretail.service.impl;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.target.myretail.model.ProductAttributeData;

public class ProductAttributeDeserializer extends StdDeserializer<ProductAttributeData> {

	public ProductAttributeDeserializer(){
		this(null);
	}
	
	public ProductAttributeDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public ProductAttributeData deserialize(JsonParser jp,
			DeserializationContext ctxt) throws IOException,
			JsonProcessingException {
		ProductAttributeData productAttributeData = new ProductAttributeData();
		JsonNode rootNode = jp.getCodec().readTree(jp);
		JsonNode productCompositeResponseNode = rootNode.get("product_composite_response");		
		ArrayNode itemArray = (ArrayNode) productCompositeResponseNode.get("items");
		JsonNode itemNode = itemArray.get(0);
		productAttributeData.setProductName(itemNode.get("general_description").asText());
		return productAttributeData;
	}

}
