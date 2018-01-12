package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewContactsPage extends TestBase {
	
	
	//@CacheLoopup is available in Selenium, is a new annotation available in Page Factory API, means it will store the WebElement in Cache, whenever you
	//interact with this element, it will bring it from Cache instead of Page, speed of script will be improved.
	//Major drawback ; if the page gets refreshed or element properties gets refreshed; then Cache memory will be corrected ; will give stale element exception.
	//dont use for all the elements, only if you are sure that properties dont change only then use it.
	
	
	
	@FindBy(id="first_name")
	@CacheLookup
	WebElement FirstName;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(name="client_lookup")
	WebElement clientName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	public NewContactsPage() {
		
		PageFactory.initElements(driver, this);	//driver is cmng from base class, (this) means current class object ; all the variables will be initialized with the driver.
			
		}
	public void createNewContact(String title, String fName, String lName, String cName ) {
		
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
				
		FirstName.sendKeys(fName);		
		
		LastName.sendKeys(lName);
		clientName.sendKeys(cName);
		saveBtn.click();
				
	}

}
