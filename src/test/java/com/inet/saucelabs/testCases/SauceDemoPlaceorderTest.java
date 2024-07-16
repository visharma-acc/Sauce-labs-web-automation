package com.inet.saucelabs.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inet.saucedemoshopping.pageObjects.CartPage;
import com.inet.saucedemoshopping.pageObjects.Checkout2Page;
import com.inet.saucedemoshopping.pageObjects.CheckoutPage;
import com.inet.saucedemoshopping.pageObjects.HomePage;
import com.inet.saucedemoshopping.pageObjects.LoginPage;
import com.inet.saucedemoshopping.pageObjects.OrderCompletePage;
import com.inet.saucelabs.listeners.SaucelabsEventListener;
import com.inet.saucelabs.utilities.WebDriverFactory;
import com.inet.saucelabs.utilities.WebDriverFactory.BrowserType;

public class SauceDemoPlaceorderTest {
	
	private static final Logger Log = LogManager.getLogger(SauceDemoPlaceorderTest.class);
	
	@Test(description = "This test case adds lowest price item to cart and places order")
	public void placeOrder()
	{
		System.out.println("order place test run in progress.");
		Log.info("Starting test case adds lowest price item to cart and places order....");
		WebDriver driver= WebDriverFactory.createWebdriver(BrowserType.FIREFOX);
		driver.get("https://www.saucedemo.com/");
		LoginPage loginPage=new LoginPage(driver);
		HomePage homepage=loginPage.login("standard_user", "secret_sauce");
		CartPage cartpage=homepage.additemtocartandclickoncart();
		CheckoutPage checkputpage= cartpage.clickoncheckout();
		Checkout2Page checkout2Page= checkputpage.fillcheckoutandclickfinish();
		OrderCompletePage ordercompletepage= checkout2Page.finishorder();
		Log.info("checking Order placed successfully....");
		Assert.assertTrue(ordercompletepage.getText().contains("Thank you for your order"));	
	}	

}
