package com.training.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class ContactsPage extends BasePage {
	public static String ContactviewName = RandomStringUtils.randomAlphanumeric(9);

	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Contacts']")
	WebElement contactsTab;

	@FindBy(name = "new")
	WebElement newcontact;

	@FindBy(id = "name_lastcon2")
	WebElement lastcontactname;

	@FindBy(id = "con4")
	WebElement accountcontactname;

	@FindBy(id = "con4_lkwgt")
	WebElement contactsearchicon;

	@FindBy(xpath = "//td[@id='topButtonRow']//input[@name='save']")
	WebElement savecontact;

	@FindBy(xpath = "//h2[@class='topName']")
	WebElement validateText;

	@FindBy(xpath = "//a[text()='Create New View']")
	WebElement contactNewView;

	@FindBy(id = "fname")
	WebElement viewName;

	@FindBy(id = "devname")
	WebElement viewUniqueName;

	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@name='save']")
	WebElement saveContactView;

	@FindBy(name = "fcf")
	WebElement accountView;

	@FindBy(id = "hotlist_mode")
	WebElement recentCreatedContact;

	@FindBy(xpath = "//tr[@class='dataRow even first']")
	WebElement validateRecent;

	@FindBy(id = "fcf")
	WebElement contactViewDD;

	//@FindBy(xpath = "//tr[@class='dataRow even first']//a[text()='Pranav']")
	@FindBy(xpath="//a[text()='Pranav']")
	WebElement contactnamelink;

	@FindBy(xpath = "//a[text()='Create New View']")
	WebElement createNewView;

	@FindBy(id = "devname")
	WebElement viewUniqueNameContacts;

	@FindBy(xpath = "//div[@class='pbHeader']//input[@name='save']")
	WebElement saveNewViewContact;

	@FindBy(xpath = "//div[text()=' You must enter a value']")
	WebElement errorMessage;

	@FindBy(id = "fname")
	WebElement viewNameContacts;

	@FindBy(xpath = "//div[@class='pbHeader']//input[@name='cancel']")
	WebElement cancel;

	@FindBy(xpath = "//td[@id='topButtonRow']//input[@name='save_new']")
	WebElement saveAndNew;

	@FindBy(xpath = "//h2[text()='Contact Edit']")
	WebElement contactEditText;

	public void validateNewContactEditPage(String a) {
		ExcplictWait(20, contactEditText);
		String actualValue = contactEditText.getText();
		Assert.assertEquals(actualValue, a);
	}

	public void clickSaveAndNew() {
		ExcplictWait(50, saveAndNew);
		saveAndNew.click();
	}

	public void clickCancel() {
		ExcplictWait(50, cancel);
		cancel.click();
	}

	public void enterViewNameContacts(String a) {
		ExcplictWait(50, viewNameContacts);
		viewNameContacts.sendKeys(a);
	}

	public void validateErrorMessage(String a) {
		ExcplictWait(50, errorMessage);
		String actualvalue = errorMessage.getText();
		System.out.println(actualvalue);
		Assert.assertEquals(actualvalue, a);
	}

	public void clickSaveNewViewContact() {
		ExcplictWait(50, saveNewViewContact);
		saveNewViewContact.click();
	}

	public void enterViewUniqueNameContacts(String a) throws InterruptedException {
		ExcplictWait(10, viewUniqueNameContacts);
		viewUniqueNameContacts.sendKeys(a);
		viewUniqueNameContacts.clear();
		viewUniqueNameContacts.sendKeys(a);
	}

	public void clickCreateNewViewContacts() {
		ExcplictWait(50, createNewView);
		createNewView.click();
	}

	public void clickFirstContactName() throws InterruptedException {
		ExcplictWait(50, contactnamelink);
		// Actions action=new Actions(driver);
		// action.moveToElement(contactnamelink).build().perform();
		contactnamelink.click();
	}

	public void selectMyContacts() {
		ExcplictWait(50, contactViewDD);
		Select selectDD = new Select(contactViewDD);
		selectDD.selectByVisibleText("My Contacts");
	}

	public void ValidateContactViewDD(String a) {
		ExcplictWait(50, contactViewDD);
		Select page = new Select(contactViewDD);
		String contactview = page.getFirstSelectedOption().getText();
		System.out.println("text from view :" + contactview);
		Assert.assertEquals(contactview, a);
	}

	public void selectRecentCreatedContact() {
		Select contact = new Select(recentCreatedContact);
		contact.selectByVisibleText("Recently Created");
	}

	public void clicksaveContactView() {
		ExcplictWait(50, saveContactView);
		saveContactView.click();
	}

	public void enterViewUniqueName() {
		ExcplictWait(50, viewUniqueName);
		viewUniqueName.sendKeys("");
	}

	public void enterViewName(String a) {
		ExcplictWait(50, viewName);
		viewName.sendKeys(a);
	}

	public void clickContactNewView() {
		ExcplictWait(50, contactNewView);
		contactNewView.click();
	}

	public void clickSaveContact() {
		savecontact.click();
	}

	public void clickContactSearchIcon() {
		contactsearchicon.click();
	}

	public void enterContactLastName(String cname) {
		ExcplictWait(60, lastcontactname);
		lastcontactname.sendKeys(cname);
	}

	public void clickNewContact() {
		ExcplictWait(5, newcontact);
		newcontact.click();
	}

	public void clickContactsTab() {
		contactsTab.click();
	}

	public void validateNewContact(String a) throws InterruptedException {
		Thread.sleep(5000);
		String name = validateText.getText();
		Assert.assertEquals(name, a);
	}

	public void validateContactsNameList(String a) throws InterruptedException {
		Thread.sleep(5000);
		Select select = new Select(accountView);
		select.selectByVisibleText(ContactviewName);
		Assert.assertEquals(ContactviewName, a);
	}

	public void validateRecentContact(String a) throws InterruptedException {
		Thread.sleep(5000);
		String name = validateRecent.getText();
		Assert.assertEquals(name, a);
	}

}
