package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class csvReaderUtility {

	public static Iterator<User> readCSVFile(String fileName){
		
		File csvFile = new File(System.getProperty("user.dir")+"\\testData\\"+fileName);
		FileReader filreader = null;
		CSVReader csvReader; 
		String[] line;
		List<User>  userList = null;
		User userData;
		
		try {
			filreader = new FileReader(csvFile);
			csvReader = new CSVReader(filreader);
//			csvReader.readNext();  //Reads the first row(header)
//			csvReader.readNext();  //Reads the second row
//			csvReader.readNext();	//Reads the third row
//			//only three rows are there so for next time it will return null
			
			userList = new ArrayList<User>();
			csvReader.readNext();
			while((line = csvReader.readNext())!=null) {
				 userData = new User(line[0], line[1]);
				userList.add(userData);
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (CsvValidationException | IOException e) {
			
			e.printStackTrace();
		}
		
		return userList.iterator();
	}

}
