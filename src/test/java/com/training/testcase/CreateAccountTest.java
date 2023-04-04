package com.training.testcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.base.BaseTest;
import com.training.pages.CreateAccountPage;
import com.training.pages.LoginPage;
import com.training.pages.RandomScenarioPage;

public class CreateAccountTest extends BaseTest{
	WebDriver driver;
	CreateAccountPage account;
	LoginPage loginPage;
	String url,UserName,Password,Name=account.viewName;
	//String viewName=RandomStringUtils.randomAlphanumeric(9);
	String viewUniqueName=RandomStringUtils.randomNumeric(3);

	
@BeforeMethod
public void BeforMethod() throws IOException {
driver = getDriverH("Chrome");
url = geturlH("salesforceURL");
driver.get(url);
UserName = geturlH("username");
Password = geturlH("password");
account = new CreateAccountPage(driver);
loginPage = new LoginPage(driver);
}
//TC10
@Test
public void CreateNewAccount() {
	loginPage.enterUserName(UserName);
	loginPage.enterPassword(Password);
	loginPage.clickLoginButton();
	account.ClickOnAccountsTab();
	account.ClosePopup();
	account.CreateNewAccount();
	account.EnterAccountName();
	account.SelectType();
	account.CustomerPriority();
	account.SaveNewAccount();
	account.validateAccountName();
}

//TC11
@Test
public void CreateNewView() throws InterruptedException {
	loginPage.enterUserName(UserName);
	loginPage.enterPassword(Password);
	loginPage.clickLoginButton();
	account.ClickOnAccountsTab();
	account.ClosePopup();
	account.CreateNewView();
	account.enterViewName(Name);
	account.enterViewUniqueName(viewUniqueName);
	account.ClickOnSave();
	account.validateAccountNameList(Name);
}
//TC12
@Test
public void editViewName() throws InterruptedException {
	loginPage.enterUserName(UserName);
	loginPage.enterPassword(Password);
	loginPage.clickLoginButton();
	account.ClickOnAccountsTab();
	account.ClosePopup();
	account.SelectViewName();
	account.clickOnEdit();
	account.EditNewViewName("Harsh Prana");
	account.SelectField();
	account.SelectOperator();
	account.enterValue("a");
	account.ClickOnSave();
	account.ValidateTitle("Accounts ~ Salesforce - Developer Edition");

}
//TC13
//@Test
public void mergeAccounts() {
	loginPage.enterUserName(UserName);
	loginPage.enterPassword(Password);
	loginPage.clickLoginButton();
	account.ClickOnAccountsTab();
	account.ClosePopup();
	account.mergeAccounts();
	account.mergeFindAccounts("*a*");
	account.findAccounts();
	account.FirstCheckBox();
	account.SecondCheckBox();
	account.ClickOnNext();
	account.mergeAccountssave();
	account.validateAccountsHome();

}
//TC14
@Test
public void createAccountReport() throws InterruptedException {
	loginPage.enterUserName(UserName);
	loginPage.enterPassword(Password);
	loginPage.clickLoginButton();
	account.ClickOnAccountsTab();
	account.ClosePopup();
	account.accountsLastActivity();
    account.dateFieldDropDown();
    account.createDate();
    account.clickFromCalendarIcon();
    account.clickFromTodayCalendar();//not working
    //Still there Date picker
}

//@AfterMethod
	public void AfterMethod(Method method) {
		String sTestcase = method.getName();
		takeScreenshot(driver,sTestcase);
		driver.close();
	}

}
