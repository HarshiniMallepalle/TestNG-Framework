package com.training.testcase;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.server.Authentication.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.base.BaseTest;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuDropDownPage;

public class UserMenuDropDownTest extends BaseTest {

	WebDriver driver;
	String url, UserName, Password;
	UserMenuDropDownPage UserMenu;
	LoginPage login;

	@BeforeMethod
	@Parameters ({"browser"})
	public void beforMethod(String browser) throws IOException {
	driver = getDriverH(browser);
	//public void BeforeMethod() throws IOException {
	//	driver = getDriverH("Chrome");
		url = geturlH("salesforceURL");
		UserName = geturlH("username");
		Password = geturlH("password");
		driver.get(url);
		UserMenu = new UserMenuDropDownPage(driver);
		login = new LoginPage(driver);
	}

//TC5
	@Test
	public void userMenuDropDown() {
		login.enterUserName(UserName);
		login.enterPassword(Password);
		login.clickLoginButton();
		UserMenu.clickUserMenuDropDown();
		UserMenu.validateUserMenuDropDown();
	}

//TC6
//@Test
	public void myProfile() throws InterruptedException {
		login.enterUserName(UserName);
		login.enterPassword(Password);
		login.clickLoginButton();
		UserMenu.clickUserMenuDropDown();
		UserMenu.clickMyProfile();
		UserMenu.clickEditProfile();
		UserMenu.clickAbout();
		UserMenu.enterLastName("Harshini ");
		UserMenu.clickSaveEditProfile();
		UserMenu.clickPost();
		UserMenu.enterText("This is 6th TestCase");
		UserMenu.clickShareButton();
		UserMenu.clickFile();
		UserMenu.clickUploadFile();
		Thread.sleep(5000);
		UserMenu.chooseFile();
		UserMenu.shareButtonForFile();
		UserMenu.profilePhoto();
		UserMenu.clickAddPhoto();
		UserMenu.switchToPhotoframe();
		UserMenu.uploadPhoto();
		UserMenu.clickSavePhoto();
		UserMenu.cropperSW();
		UserMenu.cropperSE();
		UserMenu.saveProfile();
		UserMenu.ValidateTitle("User: Sobha Harshini ~ Salesforce - Developer Edition");

	}

//TC7
//	@Test
	public void TC7() throws InterruptedException {
		login.enterUserName(UserName);
		login.enterPassword(Password);
		login.clickLoginButton();
		UserMenu.clickUserMenuDropDown();
		UserMenu.clickmySettings();
		UserMenu.clickPersonalTab();
		UserMenu.clickLoginHistory();
		UserMenu.clickDownloadLoginHistory();
		UserMenu.clickmySettingsTab();
		UserMenu.clickDisplay();
		UserMenu.clickCustomizeMyTab();
		UserMenu.selectSalesforceChatterCustomApp();
		UserMenu.selectReportSel();
		UserMenu.clickRemove();
		UserMenu.selectReportTab();
		UserMenu.clickAdd();
		UserMenu.clickSaveButton();
		UserMenu.clickTopRightDDwn();
		UserMenu.clickSalesforcechatter();
		UserMenu.clickClose();
		UserMenu.clickTopRightDDwn();
		UserMenu.clickSales();
		UserMenu.clickTopRightDDwn();
		UserMenu.clickMarketing();
		UserMenu.clickTopRightDDwn();
        UserMenu.clickContent(); 
		UserMenu.clickUserMenuDropDown();
		UserMenu.clickmySettings();
		UserMenu.clickEmail();
		UserMenu.clickMyemail();
		UserMenu.clickEmailName();
		UserMenu.clickEmailID();
		UserMenu.clickAutomaticBCC();
		UserMenu.clickSaveemail();
		UserMenu.clickmySettingsTab();
		UserMenu.clickCalenderRemindersLink();
		UserMenu.clickActivityReminder();
		UserMenu.clickOpenReminder(1);
		UserMenu.ValidationText();
	}

//TC8
//	@Test
	public void clickDeveloperConsoleFromUserMenu() throws InterruptedException {
		login.enterUserName(UserName);
		login.enterPassword(Password);
		login.clickLoginButton();
		UserMenu.clickUserMenuDropDown();
		UserMenu.DeveloperConsoleLink();
		UserMenu.ValidateTitle("Home Page ~ Salesforce - Developer Edition");

	}

//TC9
	@Test
	public void LogoutFromSFDC() throws InterruptedException {
		login.enterUserName(UserName);
		login.enterPassword(Password);
		login.clickLoginButton();
		UserMenu.clickUserMenuDropDown();
		UserMenu.LogoutFromSFDCFromUsermenu();
		UserMenu.ValidateTitle("Login | Salesforce");
	}

//@AfterMethod
	public void AfterMethod(Method method) {
		String sTestcase = method.getName();
		takeScreenshot(driver, sTestcase);
		driver.close();
	}
}
