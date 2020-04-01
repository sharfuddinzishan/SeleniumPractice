package moveToElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

/*
 * go for Javascript Executor only when we are not able 
 * to perform a particular task with our
 *  selenium; like some, we may not be able to click an element, 
 *  such cases we can go for Javascript Executor.
 */
public class moveToElement 
{

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver","chromedriver81.exe");
		System.setProperty("webdriver.chrome.logs", ".\\chromeLogs.txt");
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary("C:\\Users\\LiarZishan\\AppData\\Local\\Chromium\\Application\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://tutsplus.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
		try
		{
//			List<WebElement> list = driver.findElements(By.linkText("Courses"));
//			System.out.println(list.size());
			
			WebElement mainMenu = driver.findElement(By.linkText("Courses"));
					
			Actions actions = new Actions (driver);
			actions.moveToElement(mainMenu).perform();
			Thread.sleep(1500);
			
			driver.findElement(By.linkText("Web Design")).click();
			Thread.sleep(1500);
			
			Locatable loc = (Locatable) driver.findElement(By.linkText("Guides"));
			Coordinates co = loc.getCoordinates();
			
			EventFiringMouse mouse = new EventFiringMouse(driver, null);
			mouse.mouseMove(co);
			Thread.sleep(1500);
			
			WebElement subMenu =driver.findElement(By.linkText("Courses"));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",subMenu);
			Thread.sleep(3000);
			
			((JavascriptExecutor)driver).executeScript("window.location ='https://facebook.com'");
			
			System.out.println(driver.getCurrentUrl());
			
			String url = ((JavascriptExecutor)driver).executeScript("return document.URL;").toString();
			System.out.println(url);
			
			((JavascriptExecutor)driver).executeScript("alert('Liar Zishan');");
		}
		
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		finally
		{
			Thread.sleep(3000);
			driver.quit();
		}
		
	}

}
