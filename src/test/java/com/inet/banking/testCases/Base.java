package com.inet.banking.testCases;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Base {

	public String BaseURL;
	public String Username;
	public String Password;
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("banking");
		if(br.equals("firefox"))
		{
			driver=new FirefoxDriver();
			logger.info("Driver Initialization done..");
		}
		
		
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
