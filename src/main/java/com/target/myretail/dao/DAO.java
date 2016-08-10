package com.target.myretail.dao;

import java.util.List;

import com.datastax.driver.core.ResultSetFuture;

public interface DAO<T> {
	
	ResultSetFuture updateAsync(T entity);
	
	ResultSetFuture get(T entity);
	
	ResultSetFuture updateAsync(List<T> entities);
	
	ResultSetFuture get(List<T> entities);
	
}
