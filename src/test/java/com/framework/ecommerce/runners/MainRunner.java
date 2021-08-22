package com.framework.ecommerce.runners;

import java.io.File;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
//import cucumber.junit.Cucumber;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class) 
@CucumberOptions(plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", 
							"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"},
				  features = {"src/test/java/resources/features"},
				  glue = {"com.framework.ecommerce.steps","com.framework.ecommerce.runners"},
				  monochrome = true,
				  tags = "@signup")
public class MainRunner extends AbstractTestNGCucumberTests{
	
@AfterClass
public static void createReport() {
	Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\reportconfig\\extent-config.xml"));
	
}

}
