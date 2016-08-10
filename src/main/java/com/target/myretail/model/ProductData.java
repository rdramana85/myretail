package com.target.myretail.model;

public class ProductData {
	
	private Long productId;
	
	private ProductPriceData productPriceData;
	
	private ProductAttributeData productAttributeData;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public ProductPriceData getProductPriceData() {
		return productPriceData;
	}

	public void setProductPriceData(ProductPriceData productPriceData) {
		this.productPriceData = productPriceData;
	}

	public ProductAttributeData getProductAttributeData() {
		return productAttributeData;
	}

	public void setProductAttributeData(ProductAttributeData productAttributeData) {
		this.productAttributeData = productAttributeData;
	}

	@Override
	public String toString() {
		String str = "ProductId-->"+productId+"\n";
		str += "ProductPriceData-->"+productPriceData+"\n";
		str += "ProductAttributeData-->"+productAttributeData+"\n";
		return str;
	}
	
}
