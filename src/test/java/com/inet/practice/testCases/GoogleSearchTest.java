package com.inet.practice.testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.inet.banking.utilities.WebDriverFactory;
import com.inet.banking.utilities.WebDriverFactory.BrowserType;

public class GoogleSearchTest {
	
	
	@Test
	public void test1()
	{
		System.out.println("Inside google serach..........");
		WebDriver driver= WebDriverFactory.createWebdriver(BrowserType.FIREFOX);
		driver.get("https://www.google.com");
		WebElement searchkey= driver.findElement(By.name("q"));
		searchkey.sendKeys("Selenium");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		By dynamic_ele=By.xpath("//ul[@role='listbox']//li[@role='presentation']//*[@aria-label='selenium interview questions']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(dynamic_ele));
		

        // Find all drop-down lists
        List<WebElement> dropdowns = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
        
        driver.findElement(dynamic_ele).click();
        
        // Print the text of each suggestion
       /* for (WebElement dropdown : dropdowns) {
            System.out.println(dropdown.getText());
        } */
		
	}

}
