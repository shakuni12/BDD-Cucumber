package com.framework.ecommerce.steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;

import com.framework.ecommerce.utils.DriverHelper;
import com.framework.ecommerce.utils.FailureScreenshots;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class MasterHooks extends DriverHelper  {
	
	FailureScreenshots shots;
//	public static WebDriver driver;
//	DriverHelper helper = new DriverHelper();
	@Before
	public void setUp() {
		driver = getDriver();
		 shots = new FailureScreenshots(driver);
	}
	@BeforeMethod
	public void waitForSecond() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown(Scenario scenario) throws IOException {
		if(driver != null && scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
			shots.ScreenShot();
			driver.close();
			driver.quit();
			driver = null;
		}
		if(driver!=null) {
			driver.quit();
			driver = null;
			
		}
		
	}
}
