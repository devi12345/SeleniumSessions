package NOTES;

public class POMNotes {
	/*
	 * Page Object Model is an approach will integrate with Data  Driven Framework.
	 * 
	 * 
	 * 1 Layer - is a Page Layer....define all the page level Web objects or Object Repository and define methods.
	 * 
	 * 2 Layer - Create Test Layer, will create Test cases in this layer.
	 * 	 
	 * 3 Layer - TestBase - Parent class of all the classes. Initialize properties file, launch browser, implicit wait, max windows, delete cookies, driver.get is defined here etc
	 * All the child classes will inherit the properties from PArent class.
	 * 
	 * 4 Layer - Congig.properties; will define environment variables like username, pwd, browser..common properties.
	 * 
	 * 5 Layer - Excel File, will use APACHE POI API for reading data from excel. TestData.xlsx
	 * 
	 * 6 Layer - Create utilities.(TestUtil.Java) like screenshot method, retrieve data from excel, log etc.
	 * 
	 * 7 Layer - Reports (HTMl Report, Extent Report, TestNG Report, XML Report)
	 * 
	 * 
	 * TechnologiesUsed:
	 * 
	 * Java to write the code
	 * Selenium Web Driver
	 * TestNG for test cases
	 * Maven for creating a Build.
	 * Apache POI API to read the data from excel
	 * Extent Report/TestNG Report
	 * Log4J to generate the logs.
	 * Jenkins 
	 * GIT repository to maintain the code and push the code
	 * Selenium GRID for parallel testing
	 * Different browsers like FF, Chrome, IE, Safari
	 * Platform Mac or Windows or Linux
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * JENKIN
	 * 
	 * Download JENKIN WAR file in Google Search
	 * Go to cmd prompt; specific folder (cd jenkin) and execute run java -jar jenkins.war; this will give username and pwd.
	 * to stop ctrl +c
	 * 
	 * By deafault Jenkins runs on 8080 port which is local machine.
	 * 
	 * Go to Browser - localhost:8080, install Jenkin
	 * username: devi
	 * pwd: devi123
	 * 
	 * Goals and Options:
	 * clean install
	 * 
	 * 
	 * ERRORS: Check console output
	 * 
	 * No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?
	 * Go To Jenkins -> Manage Jenkins -> Global Tool Configuration.
	 * Now click on "JDK installations.." under JDK
	 * Uncheck Install automatically
	 * Provide path to the JDK under JAVA_HOME field.
	 *	Name: JAVA
	 *	JAVA_HOME: c:\program files\java\jdk 1.8.0_131
	 *
	 *	You can install Jenkins in Virtual Machine or Server and can access Jenkin URL from their machine , you can directly execute the build and automate it from laptop.
	 *
	 * C:\Users\mvnre\Desktop\SELENIUM\SOFTWARE\JENKIN>java -jar jenkins.war.....command prompt folder
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
