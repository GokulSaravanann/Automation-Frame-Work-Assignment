package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environmnet;

public class JsonUtility {

	public static Environmnet readJson(Env env) {
		
		Gson gson = new Gson();
		File  fl = new File(System.getProperty("user.dir") + "\\config\\config.Json");
		FileReader fr = null;
		try {
			fr = new FileReader(fl);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Config cf = gson.fromJson(fr, Config.class);
		Environmnet environment = cf.getEnvironments().get("QA");
		return environment;

	}

}
