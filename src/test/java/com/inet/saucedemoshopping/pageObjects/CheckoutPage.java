package com.inet.saucedemoshopping.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private final int TimeOutDurtion;
	private By checkoutfirstname=By.id("first-name");
	private By checkoutlastname=By.id("last-name");
	private By checkoutpostalcode= By.id("postal-code");
	private By continuebutton= By.name("continue");
	
	 public CheckoutPage(WebDriver driver) {
         this.driver = driver;
         TimeOutDurtion=5;
         wait=new WebDriverWait(driver, Duration.ofSeconds(TimeOutDurtion));
     }
	
	public Checkout2Page fillcheckoutandclickfinish()
	{
	 
    WebElement check_out_firstname=driver.findElement(checkoutfirstname);
    WebElement check_out_lastname=driver.findElement(checkoutlastname);
    WebElement check_out_postal_code=driver.findElement(checkoutpostalcode);
    WebElement continue_btn=driver.findElement(continuebutton);
    check_out_firstname.sendKeys("Vivek");
    check_out_lastname.sendKeys("Sharma");
    check_out_postal_code.sendKeys("226017");
    continue_btn.click();
    
    return new Checkout2Page(driver);
    
   
	} 
	
}
