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
import com.target.myretail.model.ProductPriceData;
import com.target.myretail.service.ProductPriceService;

@Service("productPriceService")
public class ProductPriceServiceImpl implements ProductPriceService {	
	
	@Autowired
	DAO<Entity> dao;
	
	@Override
	public ProductPriceData getCurentPrice(Long productId) throws InterruptedException, ExecutionException {
		Entity priceEntity = new Entity();
		priceEntity.setTableName("productPrice");
		String[] pKey = {"productid"};
		Long[] pKeyVal = {productId};
		String[] selCol = {"price", "currency_code"};
		priceEntity.setSelectColumns(selCol);
		priceEntity.setPrimaryKeys(pKey);
		priceEntity.setPrimaryKeyValues(pKeyVal);
		priceEntity.setKeySpaceName("target");
		ResultSetFuture rF = dao.get(priceEntity);
		ResultSet rs = rF.get();
		Iterator<Row> iter = rs.iterator();
		Float price = null;
		String currencyCode = null;
		while(iter.hasNext()){
			Row r = iter.next();
			price = r.getFloat(0);
			currencyCode = r.getString(1);
		}
		ProductPriceData priceData = new ProductPriceData();
		priceData.setProductId(productId);
		priceData.setPrice(price);
		priceData.setCurrencyCode(currencyCode);
		return priceData;
	}

}
