package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



import com.constants.Env;

public class PropertiesUtil {

	//To read properties file
	
	public static String readProperty(Env env,String propertyName) {
		
		File fl = new File(System.getProperty("user.dir") + "\\config\\" +env+ ".properties");
		FileReader fr = null;
		Properties pr = new Properties();
		try {
			fr = new FileReader(fl);
			pr.load(fr);
		} 
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = pr.getProperty(propertyName);
		return value;
		

	}

}
