package com.inet.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()
	{
		File src=new File("./configurations/config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
			
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public String getUrl()
	{
		return prop.getProperty("url");
	}
	
	public String getUsername()
	{
		return prop.getProperty("username");
	}
	
	
	public String getPassword()
	{
		return prop.getProperty("password");
	}
	
	
}
