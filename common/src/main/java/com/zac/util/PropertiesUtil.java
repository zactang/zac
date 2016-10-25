package com.zac.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertiesUtil
 * 
 * @author ZacTang
 * 
 */
public class PropertiesUtil {
	private static String default_properties = "config.properties";
	private static Properties prop;
	static {
		prop = new Properties();
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(getPath() + default_properties));
			prop.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		String value = prop.getProperty(key);
		if (value == null)
			return defaultValue;

		return value;
	}

	public static boolean getBooleanProperty(String name, boolean defaultValue) {
		String value = prop.getProperty(name);
		if (value == null){
			return defaultValue;
		}
			
		return (new Boolean(value)).booleanValue();
	}

	public static int getIntProperty(String name) {
		return getIntProperty(name, 0);
	}

	public static int getIntProperty(String name, int defaultValue) {
		String value = prop.getProperty(name);

		if (value == null){
			return defaultValue;
		}
			
		return (new Integer(value)).intValue();
	}

	public static String getPath() {
		return Thread.currentThread().getContextClassLoader().getResource("").getPath();
	}

	/**
	 * read value of properties 
	 * @param properties  File name
	 * @param name  property of read 
	 * @return
	 */
	public  String readProper(String properties, String name) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(properties);
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return p.getProperty(name);
	}

}
