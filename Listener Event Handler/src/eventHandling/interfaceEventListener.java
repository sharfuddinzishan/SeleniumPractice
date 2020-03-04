package eventHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class interfaceEventListener implements WebDriverEventListener
{
	public void beforeNavigateTo(String url, WebDriver driver) 
	{
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) 
	{
		System.out.println("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) 
	{
		System.out.println("Value of the:" + element.toString()
				+ " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) 
	{
		System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) 
	{
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) 
	{
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) 
	{
		System.out.println("(Beforr) Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) 
	{
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) 
	{
		System.out.println("(Beforr) Navigating Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) 
	{
		System.out.println("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) 
	{
		System.out.println("Exception occured: " + error);
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) 
	{
		System.out.println("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) 
	{
		System.out.println("Found Element By : " + by.toString());
	}
	
	public void beforeSwitchToWindow(String windowName, WebDriver driver) 
	{
		System.out.println("Before Switch to window : "+windowName);
	}
	
	public void afterSwitchToWindow(String windowName, WebDriver driver) 
	{
		System.out.println("After Switch to window : "+windowName);
	}

	public void beforeGetText(WebElement element, WebDriver driver) 
	{
		System.out.println("Before get text of Web Element : "+element);
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) 
	{
		System.out.println("After get text of Web Element : "+element);
	}

	public void beforeAlertAccept(WebDriver driver) 
	{
		
	}
	
	public void afterAlertAccept(WebDriver driver) 
	{

	}

	public void afterAlertDismiss(WebDriver driver) 
	{

	}

	public void beforeAlertDismiss(WebDriver driver) 
	{
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) 
	{
		
	}
	
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) 
	{
	
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) 
	{
		
	}
	
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) 
	{
	
	}

	public void beforeNavigateRefresh(WebDriver driver) 
	{
		
	}
	
	public void afterNavigateRefresh(WebDriver driver) 
	{
		
	}
	
	public void beforeScript(String script, WebDriver driver) 
	{
		
	}

	public void afterScript(String script, WebDriver driver) 
	{
		
	}
	

}