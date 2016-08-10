package com.target.myretail.dao;

public class Entity {

	private String[] primaryKeys;
	
	private Object[] primaryKeyValues;
	
	private String[] columns;
	
	private String[] selectColumns;
	
	private Object[] columnValues;
	
	private String tableName;
	
	private String keySpaceName;

	public String[] getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(String[] primaryKeys) {
		this.primaryKeys = primaryKeys;
	}

	public Object[] getPrimaryKeyValues() {
		return primaryKeyValues;
	}

	public void setPrimaryKeyValues(Object[] primaryKeyValues) {
		this.primaryKeyValues = primaryKeyValues;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public Object[] getColumnValues() {
		return columnValues;
	}

	public void setColumnValues(Object[] columnValues) {
		this.columnValues = columnValues;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String[] getSelectColumns() {
		return selectColumns;
	}

	public void setSelectColumns(String[] selectColumns) {
		this.selectColumns = selectColumns;
	}

	public String getKeySpaceName() {
		return keySpaceName;
	}

	public void setKeySpaceName(String keySpaceName) {
		this.keySpaceName = keySpaceName;
	}
	
}
