package com.target.myretail.service.impl;

import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Row;
import com.target.myretail.dao.DAO;
import com.target.myretail.dao.Entity;
import com.target.myretail.exceptions.ServiceException;
import com.target.myretail.model.ProductPriceData;
import com.target.myretail.service.ProductPriceUpdateService;
import com.target.myretail.util.MyRetailConstants;

@Service("productPriceUpdateService")
public class ProductPriceUpdateServiceImpl implements ProductPriceUpdateService {

	@Autowired
	DAO<Entity> dao;	
	
	@Override
	public ResponseEntity<String> updatePrice(Long productId, ProductPriceData priceData) throws InterruptedException, ExecutionException {
		Entity priceEntity = new Entity();
		priceEntity.setTableName(MyRetailConstants.PRICE_TABLE);
		String[] pKey = {MyRetailConstants.PRROD_ID_COLUMN};
		Long[] pKeyVal = {productId};
		String[] updCol = {MyRetailConstants.PRICE_COLUMN, MyRetailConstants.CURR_CODE_COL};
		Object[] updColVal ={priceData.getPrice(),priceData.getCurrencyCode()};
		priceEntity.setColumns(updCol);
		priceEntity.setColumnValues(updColVal);
		priceEntity.setPrimaryKeys(pKey);
		priceEntity.setPrimaryKeyValues(pKeyVal);
		priceEntity.setKeySpaceName(MyRetailConstants.PRICE_KEYSPACE);
		ResultSetFuture rF = dao.updateAsync(priceEntity);
		ResultSet rs;		
		rs = rF.get();		
		Iterator<Row> iter = rs.iterator();
		boolean isUpdated = false;
		while(iter.hasNext()){
			Row r = iter.next();
			isUpdated = r.getBool(0);		
		}
		
		HttpStatus status = isUpdated?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR;
		
		String statusMsg = isUpdated?"Price successfully updated":"Price update failed. Item "+productId+" does not exist";
		
		return new ResponseEntity<String>(statusMsg,status);
	}

}
