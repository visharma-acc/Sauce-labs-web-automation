package com.inet.practice.testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inet.banking.utilities.WebDriverFactory;
import com.inet.banking.utilities.WebDriverFactory.BrowserType;

public class StaticWebTableTest {

	@Test
	public void WebTableCasestest()
	{
		WebDriver driver=WebDriverFactory.createWebdriver(BrowserType.FIREFOX);
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// no of rows
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
		List<WebElement> cols=driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		
		System.out.println("No of rows in table "+rows.size());
		System.out.println("No of cols in table "+cols.size());
		
		
		// display content of each row
		
		for(int i=1;i<rows.size();i++)
		{
			for(int j=1;j<cols.size();j++)
			{
		       WebElement element=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]"));
		       System.out.print(element.getText()+" ");
			}
			System.out.println();
		}
	}
	
}
