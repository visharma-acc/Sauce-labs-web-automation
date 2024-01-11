package com.inet.banking.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	public static WebDriver createWebdriver(BrowserType browsertype)
	{
		WebDriver driver;
		switch(browsertype) {
		case CHROME:
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
            throw new IllegalArgumentException("Unsupported browser type: " + browsertype);	
		}
		return driver;
	}

	public enum BrowserType
	{
		CHROME,
		FIREFOX
	}
}
