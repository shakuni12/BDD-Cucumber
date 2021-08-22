package com.framework.ecommerce.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyHelper {
	
	public static String value = null;
	Properties prop = null;

	
	public static  String getValue(String key) {
		Properties prop = new Properties();
		try {
		prop.load(new FileInputStream(Constant.configFilePath));
		value = prop.getProperty(key);
		
		}
		catch (Exception e) {
			 System.err.println("Can't get property key " + key + " from file " + Constant.configFilePath + e);
		}
		
		return value;
	}

}
