package com.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Leads']")
	WebElement leadstab;

	@FindBy(xpath = "//select[@id='fcf']/option")
	List<WebElement> leadsDD;

	@FindBy(name = "go")
	WebElement go;

	@FindBy(name = "new")
	WebElement newlead;

	@FindBy(id = "name_lastlea2")
	WebElement lastname;

	@FindBy(id = "lea3")
	WebElement companyname;

	@FindBy(xpath = "//td[@id='topButtonRow']//input[@name='save']")
	WebElement saveLead;

	@FindBy(name = "fcf")
	WebElement accountView;
	
	@FindBy(xpath="//h2[@class='topName']")
    WebElement validateText; 
    
	public void clickSaveLead() {
		saveLead.click();
	}

	public void enterCompanyName(String a) {
		companyname.sendKeys(a);
	}

	public void enterLastName(String b) {
		ExcplictWait(50, lastname);
		lastname.sendKeys(b);
	}

	public void clickNew() {
		ExcplictWait(20, newlead);
		newlead.click();
	}

	public void clickGo() {
		go.click();
	}

	public void clickOnLeadsTab() {
		ExcplictWait(20, leadstab);
		leadstab.click();
	}

	public void validateLeadsDropDown() {
		String[] Ab = { "All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads",
				"View - Custom 1", "View - Custom 2" };
		for (int i = 0; i < leadsDD.size(); i++) {
			if (leadsDD.get(i).getText().equalsIgnoreCase(Ab[i])) {
			}
		}
	}

	public void selectAllOpenLeads() throws InterruptedException {
		Thread.sleep(5000);
		for (int i = 0; i < leadsDD.size(); i++) {

			if (leadsDD.get(i).getText().equalsIgnoreCase("All Open Leads")) {
				leadsDD.get(i).click();
			}
		}
	}

	public void selectTodayLeads() throws InterruptedException {
		Thread.sleep(5000);
		for (int i = 0; i < leadsDD.size(); i++) {
			if (leadsDD.get(i).getText().equalsIgnoreCase("Today's Leads")) {
				leadsDD.get(i).click();
			}
		}
	}

	public void validateLeadsList(String a) {
       	Select select = new Select(accountView);
		String Actualvalue=select.getFirstSelectedOption().getText();
		Assert.assertEquals(Actualvalue, a);
	}
	
	public void validateLeadView(String a) throws InterruptedException {
		Thread.sleep(5000);
		String name=validateText.getText();
		Assert.assertEquals(name, a);
	}

}
