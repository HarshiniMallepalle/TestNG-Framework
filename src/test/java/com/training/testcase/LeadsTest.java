package com.training.testcase;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.base.BaseTest;
import com.training.pages.CreateAccountPage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuDropDownPage;

public class LeadsTest extends BaseTest {
	WebDriver driver;
	String url, UserName, Password;
	LoginPage loginPage;
	LeadsPage leadsPage;
	CreateAccountPage account;
	UserMenuDropDownPage UserMenu;

	@BeforeMethod
	public void beforMethod() throws IOException {
		driver = getDriverH("chrome");
		url = geturlH("salesforceURL");
		driver.get(url);
		UserName = geturlH("username");
		Password = geturlH("password");
		loginPage = new LoginPage(driver);
		leadsPage = new LeadsPage(driver);
		account = new CreateAccountPage(driver);
		UserMenu = new UserMenuDropDownPage(driver);

	}

	// TC20
	@Test
	public void clickLeadsTab() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		leadsPage.clickOnLeadsTab();
		account.ClosePopup();
		leadsPage.ValidateTitle("Leads: Home ~ Salesforce - Developer Edition");
	}

	// TC21
	@Test
	public void clickLeadsDropDown() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		leadsPage.clickOnLeadsTab();
		account.ClosePopup();
		leadsPage.validateLeadsDropDown();

	}

	// TC22
	@Test
	public void LeadsDropDown() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		leadsPage.clickOnLeadsTab();
		account.ClosePopup();
		leadsPage.selectTodayLeads();
		UserMenu.clickUserMenuDropDown();
		UserMenu.LogoutFromSFDCFromUsermenu();
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		leadsPage.clickOnLeadsTab();
		leadsPage.clickGo();
		leadsPage.validateLeadsList("Today's Leads");
		//leadsPage.ValidateTitle("Leads ~ Salesforce - Developer Edition");
	}

	// TC23
	@Test
	public void LeadsHomePage() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		leadsPage.clickOnLeadsTab();
		account.ClosePopup();
		leadsPage.selectAllOpenLeads();
		leadsPage.clickOnLeadsTab();
		leadsPage.selectTodayLeads();
		leadsPage.validateLeadsList("Today's Leads");
	  //leadsPage.ValidateTitle("Leads ~ Salesforce - Developer Edition");
	}
	
	// TC24
		@Test
		public void newLead() throws InterruptedException {
			loginPage.enterUserName(UserName);
			loginPage.enterPassword(Password);
			loginPage.clickLoginButton();
			leadsPage.clickOnLeadsTab();
			account.ClosePopup();
			leadsPage.clickNew();
			leadsPage.enterLastName("SR");
			leadsPage.enterCompanyName("SR");
			leadsPage.clickSaveLead();
			leadsPage.validateLeadView("SR");
	}

	 //@AfterMethod
	public void AfterMethod(Method method) {
		String sTestcase = method.getName();
		takeScreenshot(driver, sTestcase);
		driver.close();
	}
}
