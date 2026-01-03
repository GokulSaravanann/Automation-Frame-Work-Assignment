package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	
	public static Iterator<User> readExcelFile() throws InvalidFormatException, IOException {
		
		File XXFFile = new File(System.getProperty("user.dir")+"\\testData\\loginData.xlsx");
		XSSFWorkbook xssfWb = new XSSFWorkbook(XXFFile);
		XSSFSheet xssfSheet = xssfWb.getSheet("LoginTestData");
		
		Iterator<Row> rowIterator = xssfSheet.iterator();
		User user;
		rowIterator.hasNext();  //ToSkipHeader part in excel
		List<User> userList = new ArrayList<User>();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
		
		
		Cell firstcell = row.getCell(0);
		Cell secondcell = row.getCell(1);
		user = new User(firstcell.toString(),secondcell.toString());
		userList.add(user);
		
	}
		return userList.iterator();
	}

}
