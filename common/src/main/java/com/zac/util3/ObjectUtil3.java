package com.zac.util3;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectUtil3 {

	/**
	 * JSON转map
	 * @param jsonStr
	 * @return
	 */
	public static Map<String, Object> jsonToMap(String jsonStr) {
		return jsonToBean(jsonStr, Map.class);
	}
	
	/**
	 * JavaBean转JSON
	 * @param <T>
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("finally")
	public static <T> String beanToJson(T obj) {
		String json = null;
		if (obj == null) { return json; }
		ObjectMapper mapper = null;
		try {
			mapper = new ObjectMapper();
			json = mapper.writeValueAsString(obj); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mapper = null;
			return json;
		}
	}
	
	/**
	 * JSON TO JavaBean
	 * @param <T>
	 * @param jsonStr
	 * @param valueType
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	public static <T> T jsonToBean(String jsonStr, Class<?> valueType) {
		T obj = null;
		if (jsonStr == null || "".equals(jsonStr)) {
			return null;
		}
		ObjectMapper mapper = null;
		try {
			mapper = new ObjectMapper();
			obj = (T) mapper.readValue(jsonStr, valueType); 

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mapper = null;
			return obj;
		}
	}
}
