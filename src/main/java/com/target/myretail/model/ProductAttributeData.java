package com.target.myretail.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.target.myretail.service.impl.ProductAttributeDeserializer;


@JsonDeserialize(using=ProductAttributeDeserializer.class)
public class ProductAttributeData {
	
	private Long productId;
	
	private String productName;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}	
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		String str = "{\nProductAttributeData-->\n";
		str += "productId-->"+productId+"\n";
		str += "productName-->"+productName;
		return str;
	}	
}
