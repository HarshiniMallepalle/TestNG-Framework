package com.training.testcase;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.security.auth.login.AccountException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.base.BaseTest;
import com.training.pages.CreateAccountPage;
import com.training.pages.CreateOppurtunitiesPage;
import com.training.pages.LoginPage;

public class CreateOpportunitiesTest extends BaseTest {
	WebDriver driver;
	LoginPage loginPage;
	String url, UserName, Password;
	CreateOppurtunitiesPage oppty;
	CreateAccountPage account;

	@BeforeMethod
	public void BeforMethod() throws IOException {
		driver = getDriverH("Chrome");
		url = geturlH("salesforceURL");
		driver.get(url);
		UserName = geturlH("username");
		Password = geturlH("password");
		oppty = new CreateOppurtunitiesPage(driver);
		loginPage = new LoginPage(driver);
		account = new CreateAccountPage(driver);

	}

//TC15
	@Test
	public void VerifyOpportunities() {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		oppty.ClickOnOpportunityTab();
		account.ClosePopup();
		oppty.clickVerifyOppurtunitiesDropDown();
		oppty.VerifyOppurtunitiesDropDown();
	}

//TC16
	@Test
	public void CreateNewOpportunity() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		oppty.ClickOnOpportunityTab();
		account.ClosePopup();
		oppty.ClickOnNew();
		oppty.enterOppurtunityName("Saanvi");
		oppty.clearAccountName();
		oppty.clickSearchIcon();
		oppty.newWindow();
		oppty.clickCloseDate();
		oppty.SelectStage();
		oppty.enterProbability();
		oppty.SelectLeadSource();
		oppty.clickCampaignSearchIcon();
        oppty.newWindowCamping();
        oppty.clickSaveOppty();
		oppty.ValidateTitle("Opportunity: Saanvi ~ Salesforce - Developer Edition");

	}

//TC17
	@Test
	public void opportunitePipelineReport() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		oppty.ClickOnOpportunityTab();
		account.ClosePopup();
		oppty.clickPipeLine();
		oppty.ValidateTitle("Opportunity Pipeline ~ Salesforce - Developer Edition");
	}

//TC18
	@Test
	public void opportuniteStuckReport() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		oppty.ClickOnOpportunityTab();
		account.ClosePopup();
		oppty.clickStuckOpportunites();
		oppty.ValidateTitle("Stuck Opportunities ~ Salesforce - Developer Edition");
	}

//TC19
	@Test
	public void opportunityQuaterlySummaryReport() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		oppty.ClickOnOpportunityTab();
		account.ClosePopup();
		oppty.selectQuaterlyInterval();
		oppty.selectQuaterlyInclude();
		oppty.clickRunReport();
		oppty.ValidateTitle("Opportunities ~ Salesforce - Developer Edition");
	}

//@AfterMethod
	public void AfterMethod(Method method) {
		String sTestcase = method.getName();
		takeScreenshot(driver, sTestcase);
		driver.close();
	}
}
