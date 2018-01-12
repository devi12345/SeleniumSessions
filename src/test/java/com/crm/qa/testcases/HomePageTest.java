package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;  //reference of contacts page
	
	//its compulsory to call TestBase class Constructor; hence using super()
	public HomePageTest() {
			super();
	}
	
	@BeforeMethod
	public void setup() {
		
	initialization();
	testUtil = new TestUtil();
	contactsPage = new ContactsPage(); //Initialize
	loginPage= new LoginPage();		// get loginPage to call login method
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //First log into application to reach homepage
	}
	

	
	
	//test cases should be separated, independent of each other
	//before each test case launch the browser and login
	//@Test - execute test case
	//quit the browser after each test case
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Title is Wrong");
	}
	
	
	@Test(priority=2)
	public void verifyUsernameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
	contactsPage =	homePage.clickOnContactsLink();
		
		
		
	}
	@AfterMethod 
	public void tearDown(){
		driver.quit();
		
	}
	
	

}
