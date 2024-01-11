package com.inet.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver ldriver;
	
	@FindBy(name="uid") 
	private WebElement user_name;

	@FindBy(name="password") 
	private WebElement pass_word;
	
	@FindBy(name="btnLogin") 
	private WebElement loginbtn;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	public void login(String username, String password)
	{
		user_name.sendKeys(username);
		pass_word.sendKeys(password);
		loginbtn.click();
	}
	
}
