package com.inet.saucelabs.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;

import com.inet.saucelabs.listeners.SaucelabsEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	public static WebDriver createWebdriver(BrowserType browsertype)
	{
		WebDriver webdriver;
		WebDriver driver;
		WebDriverListener listener;
		switch(browsertype) {
		case CHROME:
				WebDriverManager.chromedriver().setup();
				webdriver=new ChromeDriver();
				listener=new SaucelabsEventListener();
				driver=new EventFiringDecorator<>(listener).decorate(webdriver);
				break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			webdriver=new FirefoxDriver();
			listener=new SaucelabsEventListener();
			driver=new EventFiringDecorator<>(listener).decorate(webdriver);
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
