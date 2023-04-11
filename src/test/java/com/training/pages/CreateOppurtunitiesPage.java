package com.training.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class CreateOppurtunitiesPage extends BasePage {

	public CreateOppurtunitiesPage(WebDriver driver) {
		super(driver);
	}
	

@FindBy(id="Opportunity_Tab")
WebElement opptytab;

@FindBy(id="fcf")
WebElement opptyviewdropdown;

@FindBy(xpath="//select[@id='fcf']")
WebElement listofoppty;

@FindBy(name="new")
WebElement newbutton;

@FindBy(id="opp3")
WebElement newoppty;

@FindBy(id="opp4")
WebElement accountnamefield;

@FindBy(id="opp4_lkwgt")
WebElement searchicon;

@FindBy(xpath="//frameSet[@framespacing='0']")
WebElement newwindowframe;

@FindBy(xpath="//frame[@id='resultsFrame']")
WebElement subframe2;

@FindBy(xpath="//a[text()='Edge Communications']")
WebElement accountname;

@FindBy(id="opp11")
WebElement stageDD;

@FindBy(id="opp12")
WebElement probablity;

@FindBy(id="opp6")
WebElement leadsource;

@FindBy(xpath="//a[@title='Primary Campaign Source Lookup (New Window)']//img[@class='lookupIcon']")
WebElement campaingSearchIcon;

@FindBy(xpath="//a[text()='Harshini']")
WebElement campaing;

@FindBy(xpath="//a[text()='Opportunity Pipeline']")
WebElement pipeline;

@FindBy(xpath="//a[text()='Stuck Opportunities']")
WebElement stuckopportunities;

@FindBy(id="quarter_q")
WebElement interval;

@FindBy(id="open")
WebElement include;

@FindBy(name="go")
WebElement runreport;

@FindBy(xpath="//span[@class='dateFormat']")
WebElement closeDate;

@FindBy(xpath="//td[@id='topButtonRow']//input[@name='save']")
WebElement saveOppty;


public void clickSaveOppty() {
	ExcplictWait(5, saveOppty);
	saveOppty.click();
}
public void clickCloseDate() {
	ExcplictWait(5, closeDate);
	closeDate.click();
}

public void clickRunReport() {
	ExcplictWait(5, runreport);
	runreport.click();
}

public void selectQuaterlyInclude() {
	ExcplictWait(30, include);
	Select selectint = new Select(include);
	selectint.selectByVisibleText("All Opportunities");	
}
public void selectQuaterlyInterval() {
	ExcplictWait(30, interval);
	Select selectint = new Select(interval);
	selectint.selectByVisibleText("Previous FQ");
	}

public void clickStuckOpportunites() {
	stuckopportunities.click();
}


public void clickPipeLine() {
	pipeline.click();
}

public void ClickOnNew() {
	newbutton.click();
}
public void enterOppurtunityName(String name) {
	ExcplictWait(5, newoppty);
	newoppty.sendKeys(name);
}

public void clickSearchIcon() {
	ExcplictWait(60,searchicon);
	searchicon.click();
}
public void clickCampaignSearchIcon() {
	ExcplictWait(60,campaingSearchIcon);
	campaingSearchIcon.click();
}

public void clearAccountName() {
	accountnamefield.clear();
}

public void newWindow() throws InterruptedException {
				Set<String> handle = driver.getWindowHandles();
				int n = handle.size();
				 String[] indexOfWindows = handle.toArray(new String[n]);
					driver.switchTo().window(indexOfWindows[1]);
					Thread.sleep(3000);
					//driver.switchTo().frame(newwindowframe);
					driver.switchTo().frame(subframe2);
					accountname.click();
					driver.switchTo().window(indexOfWindows[0]);
}

public void newWindowCamping() throws InterruptedException {
	Set<String> handle = driver.getWindowHandles();
	int n = handle.size();
	 String[] indexOfWindows = handle.toArray(new String[n]);
		driver.switchTo().window(indexOfWindows[1]);
		Thread.sleep(3000);
		driver.switchTo().frame(subframe2);
		campaing.click();
		driver.switchTo().window(indexOfWindows[0]);
}

public void SelectStage() {
	//stageDD.click();
	Select stage = new Select(stageDD);
	stage.selectByVisibleText("Needs Analysis");
}

public void enterProbability() {
	probablity.clear();
	probablity.sendKeys("15");
}

public void SelectLeadSource() {
	Select stage = new Select(leadsource);
	stage.selectByVisibleText("Phone Inquiry");
	
}
public void ClickOnOpportunityTab() {
	opptytab.click();
}

public void clickVerifyOppurtunitiesDropDown() {
	opptyviewdropdown.click();
}

public void VerifyOppurtunitiesDropDown () {
	Select viewDropDown = new Select(listofoppty);
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
	exceptedlAllOptions.add("All Opportunities");
	exceptedlAllOptions.add("Closing Next Month");
	exceptedlAllOptions.add("Closing This Month");
	exceptedlAllOptions.add("My Opportunities");
	exceptedlAllOptions.add("New Last Week");
	exceptedlAllOptions.add("New This Week");
	exceptedlAllOptions.add("Opportunity Pipeline");
	exceptedlAllOptions.add("Private");
	exceptedlAllOptions.add("Recently Viewed Opportunities");
	exceptedlAllOptions.add("Won");
	//compare Actual List with Excepted List
	Assert.assertEquals(actualAllOptions,exceptedlAllOptions);
	



}
}
