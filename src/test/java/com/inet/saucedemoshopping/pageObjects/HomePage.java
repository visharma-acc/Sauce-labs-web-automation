package com.inet.saucedemoshopping.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private final int TimeOutDurtion;
	private By sortlist=By.xpath("//select[@class='product_sort_container']");
	private By ItemPrice=By.xpath("//div[@class='pricebar']//div");
	
	 public HomePage(WebDriver driver) {
         this.driver = driver;
         TimeOutDurtion=5;
         wait=new WebDriverWait(driver, Duration.ofSeconds(TimeOutDurtion));
     }
	 
	 public CartPage additemtocartandclickoncart()
	 {
		    wait.until(ExpectedConditions.visibilityOfElementLocated(sortlist));
			WebElement sort_drop=driver.findElement(sortlist);
			Select dropdown = new Select(sort_drop);
			dropdown.selectByVisibleText("Price (low to high)");
			//List<WebElement> list=driver.findElements(By.xpath("//div[@class='pricebar']//div"));
			List<WebElement> list=driver.findElements(ItemPrice);
			WebElement Current=null;
			float min=Float.MAX_VALUE; 
			for(WebElement item :list)
			{
			 
			   String s =item.getText().substring(1);
			 // System.out.println(s);
			  float f=Float.parseFloat(s);
			  if(f<min)
			  {
				  min=f;
				  Current=item;
			  }
			 
	        }
			 System.out.println(min);
			WebElement parentElement = Current.findElement(By.xpath(".."));
	        // Find the sibling element of the target element
	         WebElement add_to_cart_button = parentElement.findElement(By.xpath("//following-sibling::button[contains(text(), 'Add to cart')]"));
			// WebElement add_to_cart_button = parentElement.findElement(By.xpath("//following-sibling::button"));
	         System.out.println(add_to_cart_button.getText());
	        add_to_cart_button.click();
	        
	      //  WebElement add_to_cart_button_chg = parentElement.findElement(By.xpath("//following-sibling::button[contains(text(), 'Remove')]"));
	      //  System.out.println(add_to_cart_button_chg.getText());
	        WebElement cart_link=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
	        cart_link.click();
	        
	        return new CartPage(driver);
	
}
}
	 
	 
