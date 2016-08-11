package com.target.myretail.service.impl;

import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;











import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Row;
import com.target.myretail.dao.DAO;
import com.target.myretail.dao.Entity;
import com.target.myretail.exceptions.ProductDataNotFoundException;
import com.target.myretail.exceptions.ServiceException;
import com.target.myretail.model.ProductPriceData;
import com.target.myretail.service.ProductPriceService;
import com.target.myretail.util.MyRetailConstants;

@Service("productPriceService")
public class ProductPriceServiceImpl implements ProductPriceService {	
	
	@Autowired
	DAO<Entity> dao;
	
	@Override
	public ProductPriceData getCurentPrice(Long productId) {
		Entity priceEntity = new Entity();
		priceEntity.setTableName(MyRetailConstants.PRICE_TABLE);
		String[] pKey = {MyRetailConstants.PRROD_ID_COLUMN};
		Long[] pKeyVal = {productId};
		String[] selCol = {MyRetailConstants.PRICE_COLUMN, MyRetailConstants.CURR_CODE_COL};
		priceEntity.setColumns(selCol);
		priceEntity.setPrimaryKeys(pKey);
		priceEntity.setPrimaryKeyValues(pKeyVal);
		priceEntity.setKeySpaceName(MyRetailConstants.PRICE_KEYSPACE);
		ResultSetFuture rF = dao.get(priceEntity);
		ResultSet rs;
		try {
			rs = rF.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new ServiceException(e);
		}
		Iterator<Row> iter = rs.iterator();
		Float price = null;
		String currencyCode = null;
		while(iter.hasNext()){
			Row r = iter.next();
			price = r.getFloat(0);
			currencyCode = r.getString(1);
		}
		ProductPriceData priceData = new ProductPriceData();
		if(price!=null && currencyCode!=null){
			priceData.setProductId(productId);
			priceData.setPrice(price);
			priceData.setCurrencyCode(currencyCode);
		}else{
			throw new ProductDataNotFoundException("Product price not found");
		}
		return priceData;
	}

}
