package com.training.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class RandomScenarioPage extends BasePage {
	public static String Actual;

	public RandomScenarioPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Home']")
	WebElement home;

	@FindBy(xpath = "//h1[@class='currentStatusUserName']")
	WebElement userFirstnameLastnameHomeTab;

	@FindBy(id = "tailBreadcrumbNode")
	WebElement userFirstnameLastnameLink;

	@FindBy(id = "tailBreadcrumbNode")
	WebElement userName;

	@FindBy(xpath = "//img[@alt='All Tabs']")
	WebElement AllTabs;

	@FindBy(name = "customize")
	WebElement CustomizeMyTabs;

	@FindBy(id = "duel_select_1")
	WebElement selectedTabs;

	@FindBy(id = "duel_select_0")
	WebElement moveToSelected;

	@FindBy(xpath = "//img[@alt='Remove']")
	WebElement remove;

	@FindBy(xpath = "//select[@id='duel_select_1']")
	WebElement selectedTabsList;

	@FindBy(xpath = "//span[@class='pageDescription']//a")
	WebElement dateLink;

	@FindBy(id="p:f:j_id25:j_id61:28:j_id64")
	WebElement EightPM;
	
	@FindBy(xpath="//img[@class='comboboxIcon']")
	WebElement searchIcon;
	
	@FindBy(xpath="//li[@class='listItem4']//a")
	WebElement newWindowOther;
	
	@FindBy(id="EndDateTime_time")
	WebElement endTimeField;
	
	@FindBy(id="timePickerItem_42")
	WebElement click9pm;
	
	@FindBy(xpath="//td[@id='topButtonRow']//input[@name='save']")
	WebElement saveCalendarEvent;
	
	@FindBy(xpath="//a[contains(text(),' 4:00 PM')]")
	WebElement fourPM;
	
	@FindBy(id="timePickerItem_38")
	WebElement sevenPM;
	
	@FindBy(id="IsRecurrence")
	WebElement checkRecurrence;
	
	@FindBy(id="rectypeftw")
	WebElement weeklyRadioButton;
	
	@FindBy(id="RecurrenceEndDateOnly")
	WebElement endDateBox;

	@FindBy(xpath="//tr[@id='calRow4']//td[text()='16']")
	WebElement date16th;
	
	@FindBy(xpath="//img[@alt='Month View']")
	WebElement monthIcon;
	
	public void clickMonthIcon() throws InterruptedException {
		Thread.sleep(5000);
		ExcplictWait(10, monthIcon);
		monthIcon.click();
	}	
	
	public void clickDate16th() {
		ExcplictWait(10, date16th);
		date16th.click();
	}
		
	public void clickEndDateBox() {
		ExcplictWait(10, endDateBox);
		endDateBox.click();
	}
	
	public void checkWeeklyRadioButton() {
		ExcplictWait(10, weeklyRadioButton);
		weeklyRadioButton.click();
	}	
	
	public void checkRecurrence() {
		ExcplictWait(10, checkRecurrence);
		checkRecurrence.click();
	}
	
	public void click7PM() {
		ExcplictWait(10, sevenPM);
		sevenPM.click();
	}
	
	public void click4PM() {
		ExcplictWait(10, fourPM);
		fourPM.click();
	}
	
	public void clickSaveCalendarEvent() {
		ExcplictWait(10, saveCalendarEvent);
		saveCalendarEvent.click();
	}
	
	public void click9PM() {
		ExcplictWait(10, click9pm);
		click9pm.click();
	}
	public void clickEndTimeField() {
		ExcplictWait(10, endTimeField);
		endTimeField.click();
	}
	
	
	public void switchToNewWindow() throws InterruptedException {
        Thread.sleep(3000);
		Set<String> handle = driver.getWindowHandles();
		//System.out.println(handle);
		int n = handle.size();
		//System.out.println("Number of windows : "+n);

		//assigning index value for handle 
		 String[] indexOfWindows = handle.toArray(new String[n]);
      // System.out.println(indexOfWindows[1]);

		driver.switchTo().window(indexOfWindows[1]);
	}
	
	public void switchToParentWindow() throws InterruptedException {
        Thread.sleep(3000);
		Set<String> handle = driver.getWindowHandles();
		//System.out.println(handle);
		int n = handle.size();
		//System.out.println("Number of windows : "+n);

		//assigning index value for handle 
		 String[] indexOfWindows = handle.toArray(new String[n]);
      // System.out.println(indexOfWindows[1]);

		driver.switchTo().window(indexOfWindows[0]);
	}
	
//	public void switchBackToParentWindow() {
//		driver.switchTo().parentFrame();
//	}
	
	public void clickOther() {
		ExcplictWait(30, newWindowOther);
		newWindowOther.click();
	}
	
	public void clickSearchIcon() {
		ExcplictWait(30, searchIcon);
		searchIcon.click();
	}
	
	public void clickEightPM() {
		ExcplictWait(30, EightPM);
		EightPM.click();
	}

	public void clickDateLink() {
		ExcplictWait(30, dateLink);
		dateLink.click();
	}

	public void ValidateSelectedTabsListDropDown() {
		Select viewDropDown = new Select(selectedTabsList);
		//get List of WebElements from select DropDown
		List<WebElement>alloptions=viewDropDown.getOptions();
		//create another List<String>Array to add text of all WebElements from alloptions
		List<String>actualAllOptions = new ArrayList<String>();
		for(WebElement element : alloptions) {
			//Here we are adding alloptions to actualAllOptions List
			actualAllOptions.add(element.getText().toString());
		}
		//create one empty List<String>Array to add all Excepted data
		List<String>exceptedlAllOptions = new ArrayList<String>();
		//Adding List of Excepted string items to exceptedlAllOptions
		exceptedlAllOptions.add("Home (default)");
		exceptedlAllOptions.add("Content");
		exceptedlAllOptions.add("Subscriptions");
		exceptedlAllOptions.add("Accounts");
		exceptedlAllOptions.add("Contacts");
		exceptedlAllOptions.add("Opportunities");
		exceptedlAllOptions.add("Leads");
		exceptedlAllOptions.add("Chatter");
		exceptedlAllOptions.add("Campaigns");
		//compare Actual List with Excepted List
		Assert.assertEquals(actualAllOptions,exceptedlAllOptions);
		
	}

	public void clickRemove() {
		ExcplictWait(30, remove);
		remove.click();
	}

	public void selectLibraries() {
		ExcplictWait(60, selectedTabs);
		Select sel = new Select(selectedTabs);
		sel.selectByVisibleText("Libraries");
	}

	public void MoveLibrariesToSelected() {
		ExcplictWait(60, moveToSelected);
		Select select = new Select(moveToSelected);
		select.selectByVisibleText("Libraries");
	}

	public void clickCustomizeMyTabs() {
		ExcplictWait(30, CustomizeMyTabs);
		CustomizeMyTabs.click();
	}

	public void clickAllTabs() {
		ExcplictWait(30, AllTabs);
		AllTabs.click();
	}

	public void clickHomeTab() {
		ExcplictWait(50, home);
		home.click();
	}

	public void clickUserFirstLastName() {
		ExcplictWait(50, userFirstnameLastnameHomeTab);
		System.out.println("First :" + userFirstnameLastnameHomeTab.getText());
		userFirstnameLastnameHomeTab.click();
	}

	public void validateUserFirstnameLastname(String a) {
		ExcplictWait(50, userName);
		String Actual = userName.getText();
		System.out.println(Actual);
		Assert.assertEquals(Actual, a);
	}

}
