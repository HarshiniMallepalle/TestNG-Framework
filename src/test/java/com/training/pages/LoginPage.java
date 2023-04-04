package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.log.Log;

// I will store my elements and actions here.
public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(id="username")
WebElement username;

@FindBy(id="error")
WebElement errormsg;

@FindBy(id="password")
WebElement password;

@FindBy(id="Login")
WebElement LoginButton;

@FindBy(id="rememberUn")
WebElement rememberMe;

@FindBy(id="userNav-arrow")
WebElement UserMenuDropDown;

@FindBy(xpath="//a[text()='Logout']")
WebElement LogoutTab;
	
@FindBy(xpath="//span[@id='idcard-identity']")
WebElement usernameIdentification;

@FindBy(id="forgot_password_link")
WebElement forgotpswd;

@FindBy(id="un")
WebElement enterusername;

@FindBy(id="continue")
WebElement countinuepswd;

@FindBy(id="header")
WebElement pswdtext;

@FindBy(xpath="//div[contains(text(),'Please check your ')]")
WebElement valerror;
		

  public void checkForgotPassword(){
	  forgotpswd.click();
  }
  
  public void enterUsernameInForgotPswd() {
		 enterusername.sendKeys("mhr@software.com");
	}
  
  public void clickContinueForgotPswd() {
	  countinuepswd.click();
  }
  
  public void validateText(String Expectedvalue) {
	  String text=pswdtext.getText();
	  Assert.assertEquals(text,Expectedvalue);
	}
  
  public void validateError(String Expectedvalue) {
	  String vtext=valerror.getText();
	  Assert.assertEquals(vtext,Expectedvalue);
  }
  
	public void enterUserName(String userName) {
		ExcplictWait(10,username);
		username.sendKeys(userName);
	}

		
	public void enterPassword(String pswd) {
		password.sendKeys(pswd);
	}
	
	public void clearPassword() {
		password.clear();
	}
	
	public void eroorMessageValidation(String ExceptedValue) {
	String errorMsg = errormsg.getText();
	Assert.assertEquals(errorMsg,ExceptedValue );
	}
	
	public void clickLoginButton() {
		LoginButton.click();
	}
	
	
	public void clickRememberMe() {
		try {
		rememberMe.click();
		}catch (Exception e) {
			Log.error(e.toString());
		}
		}
	
	public void ChooseUserMenuDropDown() {
		UserMenuDropDown.click();
	}
	
	public  void ClickOnLogOut() {
		LogoutTab.click();
	}
	
	public void UserNameIdentification(String ExceptedValue) throws InterruptedException {
		Thread.sleep(5000);
		String Actualvalue = usernameIdentification.getText();
		Assert.assertEquals(Actualvalue, ExceptedValue);
		
	}
}
