package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	//create the constructor of LoginPageTest
	
	LoginPage loginPage; //defined at the class level so that we can use it through out the program
	HomePage homepage;
	//its compulsory to call TestBase class Constructor; hence using super()
	public LoginPageTest() {
	super();
	
}
	
	@BeforeMethod
	public void setUp() {
			initialization();
			//create the object of LoginPage Class
		loginPage= new LoginPage();
				
	}
	
	//IMP: it worked fast after i used priority
	//if u get delete this token, it's probably a control-Z or other unprintable character at the end of the file that is ignored in Windows but not on the Mac.Delete the last few characters and re-enter them - it will go away.
	//Windows - show error log
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
	String title =	loginPage.ValidateLoginPageTitle();
	
	Assert.assertEquals(title,"#1 Free CRM for Any Business: Online Customer Relationship Software","Wrong Title");
		
	}
	
	@Test(priority=2)
	public void CRMLogoImageTest() {
		Assert.assertTrue(loginPage.validateCRMImage());
		
	}
	
	
	@Test(priority=3)
	public void loginTest() {
		
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	
	
	@AfterMethod 
	public void tearDown(){
		driver.quit();
		
	}
	
	
	
	
	
}
