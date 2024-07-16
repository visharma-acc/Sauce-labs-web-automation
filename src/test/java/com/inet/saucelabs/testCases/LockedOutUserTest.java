package com.inet.saucelabs.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.inet.saucedemoshopping.pageObjects.LoginPage;
import com.inet.saucelabs.utilities.WebDriverFactory;
import com.inet.saucelabs.utilities.WebDriverFactory.BrowserType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LockedOutUserTest {

	WebDriver driver;
	
	@BeforeTest
	void init()
	{
		driver= WebDriverFactory.createWebdriver(BrowserType.FIREFOX);
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test(description = "This test case checks error message for locked in User")
	void checklockeduserError()
	{
		LoginPage loginPage=new LoginPage(driver);
		String str=loginPage.lockedOutUserLogin("locked_out_user", "secret_sauce");
		Assert.assertTrue(str.contains("Sorry, this user has been locked out"));
	}

	//select[@class='product_sort_container']
	
}
