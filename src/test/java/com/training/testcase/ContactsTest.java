package com.training.testcase;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.ContactsPage;
import com.training.pages.CreateAccountPage;
import com.training.pages.CreateOppurtunitiesPage;
import com.training.pages.LoginPage;

public class ContactsTest extends BaseTest {
	WebDriver driver;
	ContactsPage contactpage;
	String url, UserName, Password, contactName = contactpage.ContactviewName;
	LoginPage loginPage;
	CreateAccountPage account;
	CreateOppurtunitiesPage oppty;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriverH("chrome");
		url = geturlH("salesforceURL");
		driver.get(url);
		UserName = geturlH("username");
		Password = geturlH("password");
		contactpage = new ContactsPage(driver);
		loginPage = new LoginPage(driver);
		account = new CreateAccountPage(driver);
		oppty = new CreateOppurtunitiesPage(driver);
	}

//25
	@Test
	public void createNewContact() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		contactpage.clickContactsTab();
		account.ClosePopup();
		contactpage.clickNewContact();
		contactpage.enterContactLastName("Pranav");
		contactpage.clickContactSearchIcon();
		oppty.newWindow();
		contactpage.clickSaveContact();
		contactpage.validateNewContact("Pranav");
	}

	// 26
	@Test
	public void createNewViewContact() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		contactpage.clickContactsTab();
		account.ClosePopup();
		contactpage.clickContactNewView();
		contactpage.enterViewName(contactName);
		contactpage.enterViewUniqueName();
		contactpage.clicksaveContactView();
		contactpage.validateContactsNameList(contactName);
	}

	// 27
	@Test
	public void checkRecentContact() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		contactpage.clickContactsTab();
		account.ClosePopup();
		contactpage.selectRecentCreatedContact();
		contactpage.ValidateTitle("Contacts: Home ~ Salesforce - Developer Edition");
	}

	// 28
	@Test
	public void checkMyContact() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		contactpage.clickContactsTab();
		account.ClosePopup();
		contactpage.selectMyContacts();
		contactpage.ValidateContactViewDD("My Contacts");
	}

	// 29
	@Test
	public void viewContactInContactPage() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		contactpage.clickContactsTab();
		account.ClosePopup();
		contactpage.clickFirstContactName();
		contactpage.ValidateTitle("Contact: Pranav ~ Salesforce - Developer Edition");

	}

	// 30
	@Test
	public void errorMsgCreateNewViewContacts() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		contactpage.clickContactsTab();
		account.ClosePopup();
		contactpage.clickCreateNewViewContacts();
		contactpage.enterViewUniqueNameContacts("EFGH");
		contactpage.clickSaveNewViewContact();
		contactpage.validateErrorMessage("Error: You must enter a value");
	}

	// 31
	@Test
	public void checkCancelInCreateNewView() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		contactpage.clickContactsTab();
		account.ClosePopup();
		contactpage.clickCreateNewViewContacts();
		contactpage.enterViewNameContacts("ABCD");
		contactpage.enterViewUniqueNameContacts("EFGH");
		contactpage.clickCancel();
		contactpage.ValidateTitle("Contacts: Home ~ Salesforce - Developer Edition");
	}

	// 32
	@Test
	public void checkSaveAndNew() throws InterruptedException {
		loginPage.enterUserName(UserName);
		loginPage.enterPassword(Password);
		loginPage.clickLoginButton();
		contactpage.clickContactsTab();
		account.ClosePopup();
		contactpage.clickNewContact();
		contactpage.enterContactLastName("Indian");
		contactpage.clickContactSearchIcon();
		oppty.newWindow();
		contactpage.clickSaveAndNew();
		contactpage.validateNewContactEditPage("Contact Edit");

	}

	// @AfterMethod
	public void AfterMethod(Method method) {
		String sTestcase = method.getName();
		takeScreenshot(driver, sTestcase);
		driver.close();
	}
}
