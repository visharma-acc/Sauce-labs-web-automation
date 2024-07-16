package com.inet.saucedemoshopping.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Checkout2Page {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private final int TimeOutDurtion;
	private By finishbutton=By.name("finish");
	
	 public Checkout2Page(WebDriver driver) {
         this.driver = driver;
         TimeOutDurtion=5;
         wait=new WebDriverWait(driver, Duration.ofSeconds(TimeOutDurtion));
     }

	 public OrderCompletePage finishorder()
	 {
	    //Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html"));
	    WebElement finish_btn=driver.findElement(finishbutton);
	    finish_btn.click();
	    return new OrderCompletePage(driver);
	 }   
}
