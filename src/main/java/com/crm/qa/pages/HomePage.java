package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: sridevi reddy')]")
	WebElement userName;
		
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
		
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	public HomePage() {
		
	PageFactory.initElements(driver, this);	//driver is cmng from base class, (this) means current class object ; all the variables will be initialized with the driver.
		
	}
	
	//Actions or different Features on Login Page
	
	public String verifyHomePageTitle() {
	String title = 	driver.getTitle();
	return title;
		}
	
	public boolean verifyCorrectUserName() {
	boolean name = userName.isDisplayed();	
	return name;
		}
	
	
	public ContactsPage clickOnContactsLink() {
	contactsLink.click(); //this method returns contacts page object
	return new ContactsPage();
		}
	
	
	public DealsPage clickOnDealsLink() {
	dealsLink.click(); //this method returns Task page object
	return new DealsPage();
		}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click(); //this method returns Task page object
		return new TasksPage();
			}
	
	public NewContactsPage clickOnNewContactLink() throws InterruptedException {
		Thread.sleep(2000);
				Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		
		newContactLink.click();
		Thread.sleep(2000);
		return new NewContactsPage();
	}
	
}





