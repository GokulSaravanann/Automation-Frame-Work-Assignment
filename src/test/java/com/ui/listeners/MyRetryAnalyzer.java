package com.ui.listeners;

import java.beans.PropertyChangeEvent;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JsonUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	//Through properties
	private static final int MAX_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_ATTEMPTS"));
	//Trough json
	//private static final int MAX_ATTEMPTS = JsonUtility.readJson(Env.QA).getMAX_ATTEMPTS();
	
	private static int CURRENT_Attempt = 1;

	@Override
	public boolean retry(ITestResult result) {
		if(CURRENT_Attempt<=MAX_ATTEMPTS) {
			CURRENT_Attempt++;
			return true;
		}
		return false;
	}

}
