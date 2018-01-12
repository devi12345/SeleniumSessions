package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	//In the Base class, we define, Maximize Window(), PageLoadTimePut(), ImplicitWait(), deleteAllCookies(), get(url)
	//TestBase class is the Parent class, we need to establish a relation with the Child class, use(extends TestBase after child classname)
	//prop is declared at Global level, hence can be called anywhere.

	public static WebDriver driver; //Selenium Webdriver
	public static Properties prop; //Properties is a class
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {
	//create Constructor of this Class
	//Read the properties
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\CodeRepositoryJava\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		    } catch(FileNotFoundException e) {
		    	e.printStackTrace();
		    } catch(IOException e) {
		    	e.printStackTrace();
		    }
		
	}
	//Create Initialization method
	public static void initialization() {
		String browserName=prop.getProperty("browser"); //Reading the property of the browser and assigning it to a String.
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\mvnre\\Desktop\\SELENIUM\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();	
		}
			else if(browserName.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\mvnre\\Desktop\\SELENIUM\\SOFTWARE\\geckodriver-v0.19.1-win64\\geckodriver.exe");
				driver=new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver); //create a object of class (EventFiringWebDriver)
		//now create a object of EventListener Handle to register it with EventFiringWebDriver
		eventListener = new WebEventListener(); //create a object of class (WebEventListener)
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//We created class TestUtil and defined these variables, press ctrl and do mouseover on page_load_timeout
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
}

