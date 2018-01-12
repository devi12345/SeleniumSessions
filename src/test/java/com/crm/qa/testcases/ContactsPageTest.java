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

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;  //reference of contacts page
	
	public ContactsPageTest() {
		super();
}

@BeforeMethod
public void setup() throws InterruptedException {
	
initialization();
testUtil = new TestUtil();
contactsPage = new ContactsPage(); //Initialize
loginPage= new LoginPage();		// get loginPage to call login method
homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //First log into application to reach homepage
testUtil.switchToFrame();
contactsPage =	homePage.clickOnContactsLink();
Thread.sleep(2000);
}
	

@Test(priority=1)
public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLable(),"Contacts Label is Missing on the Page");
	}

@Test(priority=2)
public void selectContactsByNameTest(){
	contactsPage.selectContactsByName("Navaneeta Minnamareddy");
	}

@AfterMethod 
public void tearDown(){
	driver.quit();
	}
	

}
