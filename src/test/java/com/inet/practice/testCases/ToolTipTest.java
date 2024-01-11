package com.inet.practice.testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inet.banking.utilities.WebDriverFactory;
import com.inet.banking.utilities.WebDriverFactory.BrowserType;

public class ToolTipTest {

	@Test
	public void gettooltip_test()
	{
	
		WebDriver driver=WebDriverFactory.createWebdriver(BrowserType.FIREFOX);
		driver.get("https://demo.guru99.com/test/social-icon.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement element= driver.findElement(By.xpath("//div[@class='socialbtns']//div//a[@title='Github']"));
		String tooltip= element.getAttribute("title");
		assertEquals(tooltip, "Github");
	}
	
}
