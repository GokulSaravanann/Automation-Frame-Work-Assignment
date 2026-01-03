package com.ui.Dataprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.ExcelReaderUtility;
import com.utility.csvReaderUtility;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;



public class LoginDataProvider {
		
	
	//Data provider should always return either object[] or object[][] or iterator
	@DataProvider
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		
		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir")+"\\testData\\LoginData.Json");
		FileReader fileReader = new FileReader(file);
		
		TestData data =	gson.fromJson(fileReader, TestData.class);
	
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for(User user : data.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		
		return dataToReturn.iterator();
		
		
	}
	@DataProvider
	public Iterator<User> loginCSVDataProvider() {
		return csvReaderUtility.readCSVFile("loginData.csv");
	}
	
	@DataProvider
	public Iterator<User> loginExcelDataProvider() throws InvalidFormatException, IOException {
		return ExcelReaderUtility.readExcelFile();
	}


}
