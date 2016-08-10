package com.target.myretail.model;

public enum CurrencyCode {
	
	USD("USD");
	
	private String displayName;
	
	private CurrencyCode(String displayName) {
		this.displayName = displayName;
	}	
	
	public String getDisplayName(){
		return displayName;
	}
	
}
