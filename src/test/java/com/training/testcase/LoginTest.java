package com.training.testcase;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuDropDownPage;

public class LoginTest extends BaseTest{
	WebDriver driver;
	LoginPage loginpage; 
	String url,UserName,Password;
	
	@BeforeMethod
	//@Parameters ({"browser"})
	//public void beforMethod(String browser) throws IOException {
	//driver = getDriverH(browser);
	public void beforeMethod() throws IOException {
		driver=getDriverH("chrome");
	url = geturlH("salesforceURL");
	driver.get(url);
	UserName = geturlH("username");
	Password = geturlH("password");
	loginpage = new LoginPage(driver);
	DOMConfigurator.configure("log4j.xml");
	Log.startTestCase("login");
	}
	
	//TC1
	@Test(priority=1)
	public void loginerrorMessage() throws InterruptedException {
		//Test case should contain , steps and Data. 
				/*Data can be taken from 
				   - property file 
				   - parameters from TestNG.xml
				   - get it from excel sheets  
				*/ 
		
		Log.info("My 1st log written by me Harshini");
		loginpage.enterUserName(UserName);
		loginpage.clearPassword();
		loginpage.clickLoginButton();
		loginpage.eroorMessageValidation("Please enter your password.");
	}
	//TC2
	@Test(priority=2)
	public void login() throws InterruptedException{
		Log.info("TestNG Framework");
		loginpage.enterUserName(UserName);
		loginpage.enterPassword(Password);
		loginpage.clickLoginButton();
		loginpage.ValidateTitle("Home Page ~ Salesforce - Developer Edition");
	}

	//TC3
	@Test(priority=3)
	public void checkRememberMe() throws InterruptedException{
		loginpage.enterUserName(UserName);
		loginpage.enterPassword(Password);
		loginpage.clickRememberMe();		
		loginpage.clickLoginButton();
		loginpage.ChooseUserMenuDropDown();
		loginpage.ClickOnLogOut();
		loginpage.UserNameIdentification("harshini@software.com");//validation
	}
	
	//TC4A
	@Test
	public void enterForgotPassword() {
		loginpage.checkForgotPassword();
		loginpage.enterUsernameInForgotPswd();
		loginpage.clickContinueForgotPswd();
		loginpage.validateText("Check Your Email");
	}
	
	//TC4B
	@Test
	public void wrongUsernameAndPassword() {
		loginpage.enterUserName("123");
		loginpage.enterPassword("22131");
		loginpage.clickLoginButton();
loginpage.validateError("Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	}
	
	//@AfterMethod
	public void AfterMethod(Method method) {
		String sTestcase = method.getName();
		takeScreenshot(driver,sTestcase);
		driver.close();
	}
}
