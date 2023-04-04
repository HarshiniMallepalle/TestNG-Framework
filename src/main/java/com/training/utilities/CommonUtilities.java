package com.training.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonUtilities {
	
	public String getPropertyH(String key) throws IOException {

	String path="C:\\Users\\harsh\\eclipse-workspace\\TestNGFramework\\PropertiesH\\application.properties";
	
	FileInputStream finput = new FileInputStream(path);
	Properties prop = new Properties();
	prop.load(finput);
	String value = prop.getProperty(key);
	return value;
	
	}
	
	
	
	
	
}