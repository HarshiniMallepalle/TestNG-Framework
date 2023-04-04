package com.training.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class UserMenuDropDownPage extends BasePage {

	public UserMenuDropDownPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "userNavButton")
	WebElement UserMenuDD;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	List<WebElement> UserMenuValues;

	@FindBy(xpath = "//div//a[@class='contactInfoLaunch editLink']//img[@alt='Edit Profile']")
	WebElement editpro;

	@FindBy(xpath = "//a[text()='Developer Console']")
	WebElement DeveloperConsole;

	@FindBy(xpath = "//iframe[@id='contactInfoContentId']")
	WebElement Frame1;

	@FindBy(xpath = "//a[contains(text(),'About')]")
	WebElement about;

	@FindBy(id = "lastName")
	WebElement lastname;

	@FindBy(xpath = "//input[@value='Save All']")
	WebElement saveacc;

	@FindBy(xpath = "//span[text()='Post']")
	WebElement post;

	@FindBy(xpath = "//iframe[@frameborder='0']")
	WebElement frame2;

	@FindBy(xpath = "//body[contains(text(),'Share an update')]")
	WebElement textarea;

	@FindBy(id = "publishersharebutton")
	WebElement sharebutton;

	@FindBy(xpath = "//span[text()='File']")
	WebElement file;

	@FindBy(id = "chatterUploadFileAction")
	WebElement uploadfile;

	@FindBy(id = "chatterFile")
	WebElement chosefile;

	@FindBy(id = "publishersharebutton")
	WebElement sharebutton1;

	@FindBy(xpath = "//span[@class='profileImage chatter-avatarFull chatter-avatar']//img[@class='chatter-photo']")
	WebElement profilephoto;

	@FindBy(id = "uploadLink")
	WebElement addphoto;

	@FindBy(id = "uploadPhotoContentId")
	WebElement photoframe;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	WebElement choosefile1;

	@FindBy(id = "j_id0:uploadFileForm:uploadBtn")
	WebElement savephoto;

	@FindBy(xpath = "//div[@class='imgCrop_handle imgCrop_handleSW']")
	WebElement croppersw;

	@FindBy(xpath = "//div[@class='imgCrop_handle imgCrop_handleSE']")
	WebElement cropperse;

	@FindBy(id = "j_id0:j_id7:save")
	WebElement savefinal;

	@FindBy(xpath = "//a[text()='My Settings']")
	WebElement mySettings;

	@FindBy(id = "PersonalInfo_font")
	WebElement personalTab;

	@FindBy(id = "LoginHistory_font")
	WebElement LoginHistory;

	@FindBy(xpath = "//a[contains(text(),'Download login history')]")
	WebElement DownloadLoginHistory;

	@FindBy(xpath = "//span[text()='My Settings']")
	WebElement mySettingsTab;

	@FindBy(id = "DisplayAndLayout_font")
	WebElement Display;

	@FindBy(id = "CustomizeTabs_font")
	WebElement CustomizeMyTab;

	@FindBy(id = "p4")
	WebElement CustomApp;

	@FindBy(xpath = "//select[@id='duel_select_1']")
	WebElement ReportSel;

	@FindBy(xpath = "//img[@alt='Remove']")
	WebElement remove;

	@FindBy(xpath = "//select[@id='duel_select_0']")
	WebElement ReportTab;

	@FindBy(xpath = "//img[@alt='Add']")
	WebElement Add;

	@FindBy(xpath = "//input[@name='save']")
	WebElement saveButton;

	@FindBy(id = "tsid-arrow")
	WebElement TopRightDDwn;

	@FindBy(xpath = "//a[text()='Salesforce Chatter']")
	WebElement salesforcechatter;

	@FindBy(id = "tryLexDialogX")
	WebElement close;

	@FindBy(xpath = "//a[text()='Sales']")
	WebElement Sales;

	@FindBy(xpath = "//a[text()='Marketing']")
	WebElement marketing;

	@FindBy(xpath="//a[text()='Content']")
	WebElement Content;
	
	@FindBy(id = "EmailSetup_font")
	WebElement email;

	@FindBy(id = "EmailSettings_font")
	WebElement myemail;

	@FindBy(id = "sender_name")
	WebElement emailName;

	@FindBy(id = "sender_email")
	WebElement emailID;

	@FindBy(id = "auto_bcc1")
	WebElement automaticBCC;

	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@name='save' ]")
	WebElement saveemail;

	@FindBy(xpath = "//span[text()='Calendar & Reminders']")
	WebElement CalenderRemindersLink;

	@FindBy(xpath = "//span[text()='Activity Reminders']")
	WebElement ActivityReminder;

	@FindBy(id = "testbtn")
	WebElement OpenReminder;

	@FindBy(xpath = "//th[text()='Subject']")
	WebElement validationText;

	public void ValidationText() {
		String actualValue = validationText.getText();
		Assert.assertEquals(actualValue, "Subject");
	}

//Switch to next window
	public void clickOpenReminder() throws InterruptedException {
		ExcplictWait(50, OpenReminder);
		OpenReminder.click();
		Thread.sleep(5000);
		Set<String> handle = driver.getWindowHandles();
		String[] indexOfWindows = handle.toArray(new String[handle.size()]);
		driver.switchTo().window(indexOfWindows[1]);
	}

	public void clickActivityReminder() {
		ExcplictWait(50, ActivityReminder);
		ActivityReminder.click();
	}

	public void clickCalenderRemindersLink() {
		ExcplictWait(50, CalenderRemindersLink);
		CalenderRemindersLink.click();
	}

	public void clickSaveemail() throws InterruptedException {
		ExcplictWait(50, saveemail);
		saveemail.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}

	public void clickAutomaticBCC() {
		ExcplictWait(50, automaticBCC);
		automaticBCC.click();
	}

	public void clickEmailID() {
		ExcplictWait(10, emailID);
		emailID.clear();
		emailID.sendKeys("m.harshini.reddy@gmail.com");
	}

	public void clickEmailName() {
		ExcplictWait(60, emailName);
		emailName.clear();
		emailName.sendKeys("Harshini M");
	}

	public void clickMyemail() {
		ExcplictWait(50, myemail);
		myemail.click();
	}

	public void clickEmail() {
		ExcplictWait(50, email);
		email.click();
	}
	
	public void clickContent() {
		ExcplictWait(50, Content);
		Content.click();
	}

	public void clickMarketing() {
		ExcplictWait(50, marketing);
		marketing.click();
	}

	public void clickSales() {
		ExcplictWait(50, Sales);
		Sales.click();
	}

	public void clickClose() {
		ExcplictWait(50, close);
		close.click();
	}

	public void clickSalesforcechatter() {
		ExcplictWait(50, salesforcechatter);
		salesforcechatter.click();
	}

	public void clickTopRightDDwn() {
		ExcplictWait(50, TopRightDDwn);
		TopRightDDwn.click();
	}

	public void clickSaveButton() {
		ExcplictWait(50, saveButton);
		saveButton.click();
	}

	public void clickAdd() {
		ExcplictWait(50, Add);
		Add.click();
	}

	public void selectReportTab() {
		ExcplictWait(50, ReportTab);
		Select selectr = new Select(ReportTab);
		selectr.selectByValue("report");
	}

	public void clickRemove() {
		ExcplictWait(50, remove);
		remove.click();
	}

	public void selectReportSel() {
		ExcplictWait(50, ReportSel);
		Select sel = new Select(ReportSel);
		sel.selectByValue("report");
	}

	public void selectSalesforceChatterCustomApp() {
		ExcplictWait(50, CustomApp);
		Select custom = new Select(CustomApp);
		custom.selectByVisibleText("Salesforce Chatter");
	}

	public void clickCustomizeMyTab() {
		ExcplictWait(50, CustomizeMyTab);
		CustomizeMyTab.click();
	}

	public void clickDisplay() {
		ExcplictWait(50, Display);
		Display.click();
	}

	public void clickmySettingsTab() {
		ExcplictWait(50, mySettingsTab);
		mySettingsTab.click();
	}

	public void clickDownloadLoginHistory() {
		ExcplictWait(50, DownloadLoginHistory);
		DownloadLoginHistory.click();
	}

	public void clickLoginHistory() {
		ExcplictWait(50, LoginHistory);
		LoginHistory.click();
	}

	public void clickPersonalTab() {
		ExcplictWait(50, personalTab);
		personalTab.click();
	}

	public void clickmySettings() {
		ExcplictWait(50, mySettings);
		mySettings.click();
	}

	public void saveProfile() {
		ExcplictWait(50, savefinal);
		savefinal.click();
	}

	public void cropperSE() {
		Actions crop = new Actions(driver);
		crop.clickAndHold(cropperse).moveByOffset(20, 10).build().perform();
	}

	public void cropperSW() {
		ExcplictWait(60, croppersw);
		Actions crop1 = new Actions(driver);
		crop1.clickAndHold(croppersw).moveByOffset(20, 10).build().perform();
	}

	public void clickSavePhoto() {
		ExcplictWait(50, savephoto);
		savephoto.click();
	}

	public void uploadPhoto() throws InterruptedException {
		Thread.sleep(5000);
		choosefile1.sendKeys("C:\\Users\\harsh\\OneDrive\\Desktop\\ProfilePhoto.jpg");
	}

	public void switchToPhotoframe() throws InterruptedException {
		Thread.sleep(5000);
		ExcplictWait(30, photoframe);
		driver.switchTo().frame(photoframe);
	}

	public void clickAddPhoto() {
		ExcplictWait(20, addphoto);
		addphoto.click();
	}

	public void profilePhoto() throws InterruptedException {
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(profilephoto).build().perform();
	}

	public void clickUserMenuDropDown() {
		ExcplictWait(60, UserMenuDD);
		UserMenuDD.click();
	}

	public void clickMyProfile() {
		for (int i = 0; i < UserMenuValues.size(); i++)

			if (UserMenuValues.get(i).getText().equalsIgnoreCase("My Profile")) {
				UserMenuValues.get(i).click();
			}
	}

	public void clickEditProfile() throws InterruptedException {
		Thread.sleep(5000);
		editpro.click();
	}

	public void clickAbout() {
		ExcplictWait(10, Frame1);
		driver.switchTo().frame(Frame1);
		about.click();
	}

	public void enterLastName(String lname) {
		ExcplictWait(10, lastname);
		lastname.clear();
		lastname.sendKeys(lname);
	}

	public void clickSaveEditProfile() {
		saveacc.click();
	}

	public void clickPost() {
		ExcplictWait(10, post);
		post.click();
	}

	public void enterText(String text) throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame(frame2);
		textarea.sendKeys(text);
		driver.switchTo().parentFrame();
	}

	public void clickShareButton() {
		ExcplictWait(60, sharebutton);
		sharebutton.click();
	}

	public void clickFile() throws InterruptedException {
		Thread.sleep(5000);
		file.click();
	}

	public void clickUploadFile() {
		ExcplictWait(60, uploadfile);
		uploadfile.click();
	}

	public void chooseFile() throws InterruptedException {
		Thread.sleep(5000);
		chosefile.sendKeys("C:\\Users\\harsh\\OneDrive\\Desktop\\FilePhoto.jpg");
	}

	public void shareButtonForFile() {
		sharebutton1.click();
	}

	public void validateUserMenuDropDown() {
		String[] A = { "My Profile", "My Settings", "Developer Console", "Switch to Lightning Experience", "Logout" };

		for (int i = 0; i < UserMenuValues.size(); i++) {

			if (UserMenuValues.get(i).getText().equalsIgnoreCase(A[i])) {
				System.out.println("ActualValue : " + UserMenuValues.get(i).getText() + " Excepted value : " + A[i]);

			}

		}
	}

	public void DeveloperConsoleLink() throws InterruptedException {

		for (int i = 0; i < UserMenuValues.size(); i++)

			if (UserMenuValues.get(i).getText().equalsIgnoreCase("Developer Console")) {
				UserMenuValues.get(i).click();
				Set<String> handle = driver.getWindowHandles();
				int n = handle.size();
				String[] indexOfWindows = handle.toArray(new String[n]);
				driver.switchTo().window(indexOfWindows[1]);
				// Thread.sleep(2000);
				driver.close();
				driver.switchTo().window(indexOfWindows[0]);
			}
	}

	public void LogoutFromSFDCFromUsermenu() {

		for (int i = 0; i < UserMenuValues.size(); i++)

			if (UserMenuValues.get(i).getText().equalsIgnoreCase("Logout")) {
				UserMenuValues.get(i).click();
			}
	}

}
