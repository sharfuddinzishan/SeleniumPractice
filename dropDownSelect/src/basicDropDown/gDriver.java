package basicDropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class gDriver 
{
	public static WebDriver driver=null; // As method is static so this not allowed
	public static WebElement element = null;
	public static List<WebElement> list = null;
	
	public static void createDriver(String driverURL, String webURL)
	{
			System.setProperty("webdriver.gecko.driver",driverURL); 
			driver = new FirefoxDriver();
			driver.get(webURL);
	}
	
	public static void createDriver(String driverURL, String Browser, String webURL)
	{
		if(Browser.equalsIgnoreCase("opera"))
		{
			System.setProperty("webdriver.opera.driver",driverURL); 
			driver = new OperaDriver();
		}
		
		else if(Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",driverURL); 
			driver = new ChromeDriver();
		}
		
		else
		{
			System.setProperty("webdriver.gecko.driver",driverURL); 
			driver = new FirefoxDriver();
		}
		
		driver.get(webURL);
	}
	
	public static void getText(String path)
	{
		element = driver.findElement(By.xpath(path));
		System.out.println("getText()");
		System.out.println(element.getText());
		System.out.println("#############################");
	}
	
	public static void getAttribute(String path, String AttrbuteValue)
	{
		element = driver.findElement(By.xpath(path));
		System.out.println("getAttribute ");
		System.out.println(element.getAttribute(AttrbuteValue));
		System.out.println("#############################");
	}
	
	public static void showElement(String path, String AttrbuteValue)
	{
		list = driver.findElements(By.xpath(path));
		
		System.out.println("Total Element : "+list.size());
		
		/*
		 Iterator iterator = list.iterator();
		 while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		 */
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i)); // same as iterator.next
			System.out.println("getTextin list : "+list.get(i).getText());
			System.out.println("getAttribute in list : "+list.get(i).getAttribute(AttrbuteValue));
		}
		System.out.println("#############################");
	}
	
	public static void closeDriver() throws Throwable
	{
		Thread.sleep(1500);
		driver.close();
		driver.quit();
	}	
}
