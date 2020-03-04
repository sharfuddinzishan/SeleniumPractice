package eventHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class abstractEventListener extends AbstractWebDriverEventListener
{
	public void beforeNavigateTo(String url, WebDriver driver) 
	{
		System.out.println("Before Navigate To: " + url + 
		" and Current url is: " + driver.getCurrentUrl());
	}
	
	public void afterNavigateTo(String url, WebDriver driver)
	{
		System.out.println("After Navigate To: " + url +
		" and Current url is: " + driver.getCurrentUrl());
	}
	
	public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) 
	{
		System.out.println("Started Searching Element BY "+by+" webElement "+webElement);
	}
	
	public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) 
	{
		System.out.println("Successful Searching Element BY "+by+" webElement "+webElement);	
	}
	
	public void beforeClickOn(WebElement webElement, WebDriver webDriver) 
	{
		System.out.println("Started Clicking Element "+webElement);
	}
	
	public void afterClickOn(WebElement webElement, WebDriver webDriver) 
	{
		System.out.println("Successful Clicking Element "+webElement);
	}
}
