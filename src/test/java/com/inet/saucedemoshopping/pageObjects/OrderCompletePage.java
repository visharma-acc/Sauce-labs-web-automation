package com.inet.saucedemoshopping.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderCompletePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private final int TimeOutDurtion;
	private By OrderCompleteText=By.xpath("//h2[@class='complete-header']");
	
	 public OrderCompletePage(WebDriver driver) {
         this.driver = driver;
         TimeOutDurtion=5;
         wait=new WebDriverWait(driver, Duration.ofSeconds(TimeOutDurtion));
     }
	 
	 public String getText()
	 {
	        WebElement order_complete_text=driver.findElement(OrderCompleteText);
	      //  System.out.println(order_complete_text.getText());
	        return order_complete_text.getText();
	      //  Assert.assertTrue(order_complete_text.getText().contains("Thank you for your order"));
	 }
	
}
