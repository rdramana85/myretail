package com.target.myretail.dao;

public interface QueryBuilder<T> {

	public String buildSelectQuery(T entity);
	
	public String buildUpdateQuery(T entity);
	
}
