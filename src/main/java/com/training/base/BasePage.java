package com.training.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
 protected  WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		
		//Page factory initialization
		PageFactory.initElements(driver,this);
	}
	
	public  void ExcplictWait(int time,WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void ValidateTitle(String ExceptedValue) throws InterruptedException {
	     Thread.sleep(5000);
		String ActualValue = driver.getTitle();
		Assert.assertEquals(ActualValue,ExceptedValue );
	}


}
