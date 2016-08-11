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
		for(String selCol : entity.getColumns()){
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
		StringBuilder updateQuery = new StringBuilder("update ");
		updateQuery.append(entity.getKeySpaceName()+"."+entity.getTableName()).append(" set ");
		String[] primaryKeys = entity.getPrimaryKeys();
		Object[] primaryKeyValues = entity.getPrimaryKeyValues();
		int count = 0;
		for(String updCol : entity.getColumns()){
			updateQuery.append(updCol).append("=");
			Object colVal = entity.getColumnValues()[count];
			if(colVal instanceof String){
				updateQuery.append("'"+colVal+"'").append(",");
			}else{
				updateQuery.append(colVal).append(",");
			}
			count++;
		}
		updateQuery.deleteCharAt(updateQuery.length() - 1).append(" ");
		
		updateQuery.append(" where ");
		count = 0;
		for(Object pVal : primaryKeyValues){
			if(pVal instanceof String){
				updateQuery.append(" "+primaryKeys[count]+"='"+pVal+"'");
			}else{
				updateQuery.append(" "+primaryKeys[count]+"="+pVal);
			}
			if(count < primaryKeyValues.length-1){
				updateQuery.append(" and ");
			}
		}		
		updateQuery.append("IF EXISTS");
		return updateQuery.toString();
	}

	

}
