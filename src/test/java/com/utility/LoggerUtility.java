package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
	//static also ensures memory created only once
	private static Logger logger;

	
	private  LoggerUtility() {
		
	}
	
	public static  Logger getLogger(Class<?> clazz) {
		logger = LogManager.getLogger(clazz);
		return logger;
	}
	
	

}
