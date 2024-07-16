package com.inet.saucedemoshopping.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	
	private WebDriver driver;
	private WebDriverWait wait;
	private final int TimeOutDurtion;
	private By checkout_btn=By.name("checkout");
	
	 public CartPage(WebDriver driver) {
         this.driver = driver;
         TimeOutDurtion=5;
         wait=new WebDriverWait(driver, Duration.ofSeconds(TimeOutDurtion));
     }
	 
	 public CheckoutPage clickoncheckout()
	 {
		 WebElement checkoutbutton=driver.findElement(checkout_btn);
		 checkoutbutton.click();
		 return new CheckoutPage(driver);
	 }
}
