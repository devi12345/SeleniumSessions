package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.util.TestUtil;

public class AddNewContactsTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;  //reference of contacts page
	NewContactsPage newContactPage;
	String sheetName="CRM";
	
	public AddNewContactsTest() {
		super();
}

@BeforeMethod
public void setup() throws InterruptedException {
	
initialization();
testUtil = new TestUtil();
contactsPage = new ContactsPage(); 
newContactPage = new NewContactsPage();  														//Initialize
loginPage= new LoginPage();		// get loginPage to call login method
homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //First log into application to reach homepage
testUtil.switchToFrame();
newContactPage = homePage.clickOnNewContactLink();
}
	
//Page Object Model with Data Driven Approach
//java.lang.RuntimeException:NoClassDefFoundError: org/apache/poi/poifs/filesystem/FileMagic
//Add the JAR files correctly or upgrade <artifactId>poi</artifactId>...<version>3.17</version>

@DataProvider
public Object[][] getCRMDataTest() {
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
	}

//its a mandatory to define the variables in the method again(String title, String fName, String lName, String cName)
@Test(priority=1, dataProvider="getCRMDataTest")
public void createNewContact(String title, String fName, String lName, String cName) {
		//newContactPage.createNewContact("Mr.", "devi", "reddy", "wipro");
	newContactPage.createNewContact(title, fName, lName, cName);


}


@AfterMethod 
public void tearDown(){
	driver.quit();
	}
	


}
