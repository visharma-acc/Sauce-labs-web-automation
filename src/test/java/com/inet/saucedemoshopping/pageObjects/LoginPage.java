package com.inet.saucedemoshopping.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	 private WebDriver driver;
	 private By user = By.id("user-name");
	 private By pwd=By.id("password");
     private By loginbtn=By.id("login-button");
     private By lockedoutUserError=By.xpath("//h3[@data-test='error']");

     public LoginPage(WebDriver driver) {
         this.driver = driver;
     }
     
     public HomePage login(String username, String password) {
         WebElement usernameInput = driver.findElement(user);
         WebElement passwordInput = driver.findElement(pwd);
         WebElement loginButton = driver.findElement(loginbtn);

         usernameInput.sendKeys(username);
         passwordInput.sendKeys(password);
         loginButton.click();
         
         return new HomePage(driver);
     }
     
     public String lockedOutUserLogin(String username, String password)
     {
    	 WebElement usernameInput = driver.findElement(user);
         WebElement passwordInput = driver.findElement(pwd);
         WebElement loginButton = driver.findElement(loginbtn);
   
         usernameInput.sendKeys(username);
         passwordInput.sendKeys(password);
         loginButton.click();
         WebElement error_text= driver.findElement(lockedoutUserError);
         return error_text.getText();
     }
}
