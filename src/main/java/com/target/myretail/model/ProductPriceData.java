package com.target.myretail.model;

public class ProductPriceData {
	
	private Long productId;
	
	private Float price;
	
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
