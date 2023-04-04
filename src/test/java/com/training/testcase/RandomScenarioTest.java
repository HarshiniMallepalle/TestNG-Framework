package com.training.testcase;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.CreateAccountPage;
import com.training.pages.LoginPage;
import com.training.pages.RandomScenarioPage;
import com.training.pages.UserMenuDropDownPage;

public class RandomScenarioTest extends BaseTest {

	WebDriver driver;
	LoginPage loginPage;
	CreateAccountPage account;
	RandomScenarioPage RandomScenario;
	UserMenuDropDownPage userMenuDD;
	String url, username, password;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriverH("Chrome");
		url = geturlH("salesforceURL");
		driver.get(url);
		username = geturlH("username");
		password = geturlH("password");
		loginPage = new LoginPage(driver);
		account = new CreateAccountPage(driver);
		RandomScenario = new RandomScenarioPage(driver);
		userMenuDD = new UserMenuDropDownPage(driver);
	}

	// TC33
	@Test(priority = 1)
	public void verifyUserFirstnameLastname() throws InterruptedException {
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		RandomScenario.clickHomeTab();
		account.ClosePopup();
		RandomScenario.clickUserFirstLastName();
		RandomScenario.ValidateTitle("User: Sobha Harshini ~ Salesforce - Developer Edition");

	}

	// TC34
	@Test(priority = 2)
	public void verifyLastname() throws InterruptedException {
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		RandomScenario.clickHomeTab();
		account.ClosePopup();
		RandomScenario.clickUserFirstLastName();
		userMenuDD.clickEditProfile();
		userMenuDD.clickAbout();
		userMenuDD.enterLastName("Suri");
		userMenuDD.clickSaveEditProfile();
		RandomScenario.validateUserFirstnameLastname("Sobha Suri ");
	}

	// TC35
	@Test(priority = 2)
	public void verifyTabCustomization() throws InterruptedException {
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		RandomScenario.clickAllTabs();
		RandomScenario.clickCustomizeMyTabs();
		RandomScenario.MoveLibrariesToSelected();
		userMenuDD.clickAdd();
		RandomScenario.selectLibraries();
		userMenuDD.clickRemove();
		userMenuDD.clickSaveButton();
		userMenuDD.clickUserMenuDropDown();
		userMenuDD.LogoutFromSFDCFromUsermenu();
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		RandomScenario.clickAllTabs();
		RandomScenario.clickCustomizeMyTabs();
		RandomScenario.ValidateSelectedTabsListDropDown();
	}

	// TC36
	@Test(priority = 2)
	public void blockingEventInTheCalender() throws InterruptedException {
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		RandomScenario.clickHomeTab();
		account.ClosePopup();
		RandomScenario.clickDateLink();
		RandomScenario.clickEightPM();
		RandomScenario.clickSearchIcon();
		RandomScenario.switchToNewWindow();
		RandomScenario.clickOther();
		RandomScenario.switchToParentWindow();
		RandomScenario.clickEndTimeField();
		RandomScenario.click9PM();
		RandomScenario.clickSaveCalendarEvent();
		RandomScenario.ValidateTitle("Calendar for Sobha Suri ~ Salesforce - Developer Edition");
	}

	// TC37
	@Test(priority = 2)
	public void blockingEventInTheCalenderWithWeeklyOccurance() throws InterruptedException {
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		RandomScenario.clickHomeTab();
		account.ClosePopup();
		RandomScenario.clickDateLink();
		RandomScenario.click4PM();
		RandomScenario.clickSearchIcon();
		RandomScenario.switchToNewWindow();
		RandomScenario.clickOther();
		RandomScenario.switchToParentWindow();
		RandomScenario.clickEndTimeField();
		RandomScenario.click7PM();
		RandomScenario.checkRecurrence();
		RandomScenario.checkWeeklyRadioButton();
		RandomScenario.clickEndDateBox();
		RandomScenario.clickDate16th();
		RandomScenario.clickSaveCalendarEvent();
		RandomScenario.clickMonthIcon();
		RandomScenario.ValidateTitle("Calendar for Sobha Suri - Month View ~ Salesforce - Developer Edition");
	}

	// @AfterMethod
	public void AfterMethod(Method method) {
		String sTestcase = method.getName();
		takeScreenshot(driver, sTestcase);
		driver.close();
	}
}
