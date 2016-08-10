package com.target.myretail.dao;



import org.springframework.stereotype.Component;

import com.target.myretail.dao.Entity;

@Component
public class QueryBuilderImpl implements QueryBuilder<Entity> {

	@Override
	public String buildSelectQuery(Entity entity) {
		
		StringBuilder selectQuery = new StringBuilder("select ");
		String[] primaryKeys = entity.getPrimaryKeys();
		Object[] primaryKeyValues = entity.getPrimaryKeyValues();
		for(String selCol : entity.getSelectColumns()){
			selectQuery.append(selCol).append(",");
		}
		selectQuery.deleteCharAt(selectQuery.length() - 1).append(" ");
		selectQuery.append(" from ");
		selectQuery.append(entity.getKeySpaceName()+"."+entity.getTableName()).append(" ");
		selectQuery.append(" where ");
		int count = 0;
		for(Object pVal : primaryKeyValues){
			if(pVal instanceof String){
				selectQuery.append(" "+primaryKeys[count]+"='"+pVal+"'");
			}else{
				selectQuery.append(" "+primaryKeys[count]+"="+pVal);
			}
			if(count < primaryKeyValues.length-1){
				selectQuery.append(" and ");
			}
		}
		
		return selectQuery.toString();
	}

	@Override
	public String buildUpdateQuery(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
