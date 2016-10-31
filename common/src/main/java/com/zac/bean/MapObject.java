package com.zac.bean;

/**
 * Map Object
 * @author ZacTang
 *
 */
public class MapObject implements java.io.Serializable{

	/**
	 * Auto SVUID
	 */
	private static final long serialVersionUID = 6913297418511826203L;
	private String key;//Title
	private String value;//Value
	
	public MapObject(String key,String value){
		this.key=key;
		this.value=value;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	
	
}
