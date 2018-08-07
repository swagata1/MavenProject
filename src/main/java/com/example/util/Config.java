package com.example.util;

import java.io.*;
import java.util.Properties;

public class Config {
	public static String DRIVER;
	public static String URL;
	public static String USER ;
	public static String PWD ;
	
	public static void loadData(){
		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("D:\\database.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			
			DRIVER = prop.getProperty("db_driver");
			URL = prop.getProperty("db_url");
			USER = prop.getProperty("db_user");
			PWD = prop.getProperty("db_password");

		} catch (IOException ex) {
			ex.printStackTrace();
		} 
	}
}
