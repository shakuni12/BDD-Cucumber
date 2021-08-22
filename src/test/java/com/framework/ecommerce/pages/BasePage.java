package com.framework.ecommerce.pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.model.Log;
import com.framework.ecommerce.utils.DriverHelper;




public class BasePage extends DriverHelper  {
	
	
	public final int timeOut = 10;

	public By locatorParser(String locator) {
		return By.xpath(locator);
	}

	public void click(By element) {
		driver.findElement(element).click();
	}
	public void clear(By element) {
		driver.findElement(element).clear();
	}
	public void sendText(By element, String value) {
		driver.findElement(element).sendKeys(value);
	}
	
	public void get(String url){
		driver.get(url);
	}

	public void navigate(String url){
		driver.navigate().to(url);
	}

	public void clickOnElementUsingActions(By element){
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(element));
		actions.click().perform();
	}
	
	
	public void clickOnElementUsingJs(By element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement webElement = driver.findElement(element);
		js.executeScript("arguments[0].click();", webElement);
	}
	
	
	public int getIntValue(String getInt){
		Pattern intsOnly = Pattern.compile("\\d+");
		Matcher makeMatch = intsOnly.matcher(getInt);
		makeMatch.find();
		String inputInt = makeMatch.group();
		return Integer.parseInt(inputInt);
	}


	public String getTitle(){
		return driver.getTitle();
	}

	
	public void waitForPageToLoad(String PageName) {
		String pageLoadStatus;
		JavascriptExecutor js;

		do {
			js = (JavascriptExecutor) driver;
			pageLoadStatus = (String)js.executeScript("return document.readyState");
			
		} while ( !pageLoadStatus.equals("complete") );
		System.out.println(PageName + " page loaded successfully");
	}

	public Boolean isElementPresent(By targetElement) {
		Boolean isPresent = driver.findElements(targetElement).size() > 0;
		return isPresent;
	}
	
	public Boolean isElementNotPresent(By targetElement) throws InterruptedException{
		Boolean isPresent = (driver.findElements(targetElement).size() == 0);
		return isPresent;
	}

	public boolean waitForVisibility(By targetElement) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
			return true;
		}
		catch(TimeoutException e ){
			System.out.println("Element is not visible: " + targetElement );
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}


	public boolean waitForElementToBeClickable(By targetElement) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(targetElement));
			return true;
		}
		catch(TimeoutException e ){
			System.out.println("Element is not clickable: " + targetElement );
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}

	public boolean waitForInvisibility(By targetElement) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(targetElement));
			return true;
		}
		catch(TimeoutException e ){
			System.out.println("Element is still visible: " + targetElement );
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}

	public WebElement findElement(By locator){
		try {
			WebElement element = driver.findElement(locator);
			return element;
		}
		catch (NoSuchElementException e){
			System.out.println(this.getClass().getName()+" findElement Element not found " + locator);
			throw new NoSuchElementException(e.getMessage());
		}
	}


	public List<WebElement> findElements(By locator){
		try {
			List<WebElement> element = driver.findElements(locator);
			return element;
		}
		catch (NoSuchElementException e){
			System.out.println(this.getClass().getName()+"findElements element not found" + locator);
			throw new NoSuchElementException(e.getMessage());
		}
	}


	public void clickOnMatchingValue(List<WebElement> fetchedListElements, String valueToBeMatched){

		for (WebElement element : fetchedListElements) {
			if (element.getText().equalsIgnoreCase(valueToBeMatched)) {
				element.click();
				return;
			}
		}
	}


	public void clickOnContainingValue(List<WebElement> fetchedListElements, String valueToBeContained){

		for (WebElement element : fetchedListElements) {
			if (element.getText().toLowerCase().contains(valueToBeContained.toLowerCase())) {
				element.click();
				return;
			}
			
		}
	}

	
	public void acceptAlert(){
		try {
			Alert alert = driver.switchTo().alert(); 
			alert.accept();


		} catch (NoAlertPresentException e){
			throw new NoAlertPresentException();
		}	
	}

	public String getAlertText() 
	{ 
		try {
			Alert alert = driver.switchTo().alert(); 
			String alertText = alert.getText(); 
			return alertText; 
		} catch (NoAlertPresentException e){
			throw new NoAlertPresentException();
		}
	}   

	public boolean isAlertPresent() 
	{ 
		try 
		{ 
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert();
			return true; 
		}   
		catch (NoAlertPresentException e) 
		{   
			throw new NoAlertPresentException(); 
		}   
	}   

	public void selectValuefromDropdownviaIndex(By selectLocator, int valueToBeSelectedindex){
		Select  selectFromDropdown = new Select(findElement(selectLocator));
		selectFromDropdown.selectByIndex(valueToBeSelectedindex);

	}
	public void openNewtab() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.open();");
	}
	 public static void switchToWindow(int handle) {
	        // get browser windows list
	        List<String> handles = new ArrayList<>(driver.getWindowHandles());
	        
	            if (handles.size() - 1 >= handle) {
	                driver.switchTo().window(handles.get(handle));
	               }
	    }
	 
	 public static void waitForBrowserHandle(int handle, int sec) {
	        for (int i = 0; i < sec; i++) {
	            if (driver.getWindowHandles().size() > handle) {
	               
	                break;
	            } 
	        }
	    }
	 public static void scrollToElement(By objName) {
	        
		 WebElement webElement = driver.findElement(objName);
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
	            
	    }
	 
	 public static String getFieldValue(By element) {
		String value = driver.findElement(element).getText();
		return value;
	 }
	 

	

}
