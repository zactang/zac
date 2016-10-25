package com.zac.common.ben;

/**
 * DB SQL Object
 * @author ZacTang
 *
 */
public class Tb_Obj {

	private String colName;
	private String colValue;
	
	public Tb_Obj(String colName,String colValue){
		this.colName=colName;
		this.colValue=colValue;
	}

	
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getColValue() {
		return colValue;
	}
	public void setColValue(String colValue) {
		this.colValue = colValue;
	}
	
}
