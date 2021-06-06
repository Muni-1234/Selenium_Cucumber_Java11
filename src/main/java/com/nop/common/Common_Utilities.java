package com.nop.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;

public class Common_Utilities {
	
	WebDriver driver;
	
	public String getpropertyvalue(String keyvalue, String FileName) throws IOException {
		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(FileName));
			
		} catch (FileNotFoundException e ) {
			e.printStackTrace();
		}
		return prop.getProperty(keyvalue);
	}
	
}
