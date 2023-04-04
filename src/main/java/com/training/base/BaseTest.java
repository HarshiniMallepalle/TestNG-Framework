package com.training.base;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.training.utilities.CommonUtilities;
import com.training.utilities.Screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	Screenshot TakeScreenshot = new Screenshot();
	
	public WebDriver getDriverH(String Browser) {
		if(Browser.equalsIgnoreCase("Chrome")){
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 }else if(Browser.equalsIgnoreCase("Firefox")){
		 WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
	}
		return driver;
}
	
	public String geturlH(String key) throws IOException {
		String url = common.getPropertyH(key);
		return url;
	}
	
	public void takeScreenshot(WebDriver driver, String sTestcase) {
		TakeScreenshot.takeScreenshot(driver,sTestcase);
	}
}