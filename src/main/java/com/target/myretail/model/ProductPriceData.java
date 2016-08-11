package com.target.myretail.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class ProductPriceData {
	
	private Long productId;
	
	@NotNull(message="price cannot be empty")	
	private Float price;
	
	@NotNull(message="currency code cannot be empty")
	@Size(min=3,message="currency code should have atleast 3 characters")
	private String currencyCode;
	
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		String str = "{\nProductId-->"+productId+"\n";
		str += "Price-->"+price+" "+currencyCode+"\n";
		
		return str;
	}
	
}
