package com.framework.ecommerce.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

public class FailureScreenshots {
	
	WebDriver driver = null;
	public FailureScreenshots(WebDriver driver) {
		this.driver = driver;
	}

	public String dateStamp(String fileExtension) {
		Date date = new Date();
		String stringDate = date.toString().replace(":", "_").replace(" ", "_") + fileExtension;
		return stringDate;
	}
	public void ScreenShot() throws IOException
	{
		
		String screenshotPath = dateStamp(".jpg");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\FailedTestScreenshot\\"+screenshotPath;
		File file = new File(dest);
		FileUtils.copyFile(source,file);
		Reporter.addStepLog("<a target=\"_blank\",href= "+dest+ "><img src="+ dest+ " height = 200 width = 300></img></a>");
		
		
	}
}
