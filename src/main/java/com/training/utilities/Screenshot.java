package com.training.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public void takeScreenshot(WebDriver driver, String sTestcase) {
		
		//TakeScreenshot interface is used to take screenshot
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		//File is stored as an object from screnshot
		File srcFile =screenshot.getScreenshotAs(OutputType.FILE);
		
		//Date format
		Date currentDate = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
		
		String filepath="C:\\Users\\harsh\\eclipse-workspace\\TestNGFramework\\Screenshots\\"+sTestcase+"-"+timeStamp+".jpeg";
		
		//create and destination file to store the screenshot object
		File destFile = new File(filepath);
		
		try {
			// using the file Utils copy file ..convert the file object to a physical file. 
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
