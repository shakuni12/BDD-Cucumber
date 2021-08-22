package com.framework.ecommerce.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverHelper {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
	
	String browserName = PropertyHelper.getValue("browser");
	switch(browserName) {
	case "chrome":
		if(null == driver) {
			System.setProperty("webdriver.chrome.driver", Constant.chromeDriverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		break;
	case "firefox":
		System.setProperty("webdriver.gecko.driver", Constant.geckoDriverPath);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette",true);
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		break;
	
	}
	return driver;
	}

 
}




