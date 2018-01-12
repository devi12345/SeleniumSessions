package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//First define Page factory of the Login Page or Object Repository of the page
	
	@FindBy(name="username")	//@FindBy annotation
	WebElement username; 		//Define WebElement variable
	
	@FindBy(name="password")	//=driver.findelement(By.name("password"))
	WebElement password; 
	
	@FindBy(xpath="//input[@type='submit']")    //@type='submit'
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up') ]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")  ////img[contains(@class,'img-responsive')]
	WebElement crmlogo;
	
	
	//Initialize the elements with the help of Page Factory
	//Login Page Constructor
	
	public LoginPage() {
		PageFactory.initElements(driver, this); //driver is cmng from base class, (this) means current class object ; all the variables will be initialized with the driver.
		
	}
	
	//Actions or different Features on Login Page
	public String ValidateLoginPageTitle() {
		String pageTitle = driver.getTitle(); 	//return driver.getTitle();
		return pageTitle;   			
	}
	
	
	public boolean validateCRMImage() {
		boolean logo=crmlogo.isDisplayed();		//return crmlogo.isDisplayed();
		return logo;
	}
	


	//Returns HomePage class Object
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click();", loginBtn);
	    return new HomePage();
	    
	}
}
