package com.training.pages;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class CreateAccountPage extends BasePage {

public static	String viewName=RandomStringUtils.randomAlphanumeric(9);

public CreateAccountPage(WebDriver driver) {
	super(driver);
	}

@FindBy(xpath="//li[@id='Account_Tab']//a[text()='Accounts']")
WebElement accounts;

@FindBy(id="tryLexDialogX")
WebElement closepopup;

@FindBy(name="new")
WebElement newButton;

@FindBy(id="acc2")
WebElement AccountName;

@FindBy(id="acc6")
WebElement TypeDropDown;

@FindBy(id="00N2w00000ZSDJJ")
WebElement Priority;

@FindBy(name="save")
WebElement save;

@FindBy(xpath="//h2[contains(text(),'HarshSaanvi')]")
WebElement validatename;

@FindBy(xpath="//a[text()='Create New View']")
WebElement createnewview;

@FindBy(id="fname")
WebElement viewname;

@FindBy(id="devname")
WebElement viewuniquename;

@FindBy(xpath="//div[@class='pbHeader']//input[@name='save']")
WebElement  NewViewsave;

@FindBy(id="fcf")
WebElement viewnameDD;

@FindBy(xpath="//div//a[text()='Edit']")
WebElement editButton;

@FindBy(id="fname")
WebElement newviewname;

@FindBy(id="fcol1")
WebElement field;

@FindBy(id="fop1")
WebElement operator;

@FindBy(id="fval1")
WebElement value;

@FindBy(xpath="//a[text()='Merge Accounts']")
WebElement mergeaccount;

@FindBy(id="srch")
WebElement mergeAccountsAdd;

@FindBy(name="srchbutton")
WebElement findaccounts;

@FindBy(id="cid0")
WebElement checkbox1;

@FindBy(id="cid1")
WebElement checkbox2;

@FindBy(name="goNext")
WebElement next;

@FindBy(xpath="//div[@class='pbWizardHeader']//input[@name='save']")
WebElement merge;

@FindBy(xpath="//h2[text()=' Home']")
WebElement validateHomeButton;

@FindBy(xpath="//a[contains(text(),'Accounts with last')]")
WebElement accountslastactivity;

@FindBy(id="ext-gen148")
WebElement datefield;

@FindBy(xpath="//div[text()='Created Date']")
WebElement createdate;

@FindBy(name="fcf")
WebElement accountView;

@FindBy(id="ext-gen152")
WebElement fromCalendarIcon;

@FindBy(xpath="//td[@class='x-btn-mc']//button[@id='ext-gen283']")
WebElement fromTodayCalendar;

public void clickFromTodayCalendar() {
	//driver.switchTo().alert();
	ExcplictWait(10, fromTodayCalendar);
	fromTodayCalendar.click();
}

public void clickFromCalendarIcon() {
	ExcplictWait(5, fromCalendarIcon);
	fromCalendarIcon.click();
}

public void accountsLastActivity() {
	accountslastactivity.click();
}

public void dateFieldDropDown() {
	ExcplictWait(5, datefield);
	datefield.click();
}
public void createDate() {
	createdate.click();
}
public void mergeAccounts() {
	mergeaccount.click();
}

public void mergeFindAccounts(String merge) {
	mergeAccountsAdd.sendKeys(merge);
}

public void findAccounts() {
	findaccounts.click();
}

public void FirstCheckBox() {
	ExcplictWait(20,checkbox1);
	checkbox1.click();
}

public void SecondCheckBox() {
	ExcplictWait(20,checkbox2);
	checkbox2.click();
}

public void ClickOnNext() {
	next.click();
}

public void mergeAccountssave() {
	ExcplictWait(50, merge);
	merge.click();
	driver.switchTo().alert().accept();
}
public void SelectViewName() {
	ExcplictWait(15,viewnameDD);
Select select2=new Select(viewnameDD);
select2.selectByValue("00B3x00000BUg9N");
}
public void clickOnEdit() {
	ExcplictWait(10,editButton);
	editButton.click();
}
public void EditNewViewName(String ENVName) {
	ExcplictWait(15,newviewname);
	newviewname.clear();
	newviewname.sendKeys(ENVName);
}
public void SelectField() {
	ExcplictWait(10, field);
	Select fieldselect = new Select(field);
	fieldselect.selectByVisibleText("Account Name");
}

public void SelectOperator() {
	Select operatorselect = new Select(operator);
	operatorselect.selectByVisibleText("contains");
}
public void enterValue(String val) {
	value.clear();
	value.sendKeys(val);
}
public void ClickOnAccountsTab() {
	accounts.click();
}

public void ClosePopup() {
	ExcplictWait(5,closepopup);
	closepopup.click();
}

public void CreateNewAccount() {
	newButton.click();
}
public void EnterAccountName() {
	ExcplictWait(5, AccountName);
	AccountName.sendKeys("HarshSaanvi");
}
public void SelectType() {
	Select select = new Select(TypeDropDown);
	select.selectByVisibleText("Technology Partner");
}
public void CustomerPriority() {
	ExcplictWait(5, Priority);
	Select value = new Select(Priority);
	value.selectByVisibleText("High");
}
public void SaveNewAccount() {
	save.click();
}

public void CreateNewView() {
	createnewview.click();
}
public void enterViewName( String viewName) {
	ExcplictWait(5, viewname);
	viewname.sendKeys(viewName);
}
public void enterViewUniqueName(String VUniqueName) throws InterruptedException {
	viewuniquename.clear();
	Thread.sleep(2000);
	viewuniquename.sendKeys(VUniqueName);
}
public void ClickOnSave() {
	NewViewsave.click();
}
public void validateAccountsHome() {
	String value=validateHomeButton.getText();
	ExcplictWait(20, validateHomeButton);
	Assert.assertEquals(value, "Home");
}

public void validateAccountName() {
	String VAN= validatename.getText();
	Assert.assertEquals(VAN, "HarshSaanvi");
}

public void validateAccountNameList(String a) throws InterruptedException {

Thread.sleep(5000);
Select select = new Select(accountView);
	select.selectByVisibleText(viewName);
	 Assert.assertEquals(viewName,a);

}

}
