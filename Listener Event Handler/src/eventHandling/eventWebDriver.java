package eventHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class eventWebDriver {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver81.exe");
		ChromeOptions option = new ChromeOptions();
		option.setBinary("C:\\Users\\LiarZishan\\AppData\\Local\\Chromium\\Application\\chrome.exe");
		WebDriver webDriver = new ChromeDriver(option);
		
		EventFiringWebDriver driver = new EventFiringWebDriver(webDriver);
//		abstractEventListener AbstractListener = new abstractEventListener();
		interfaceEventListener interfaceListener = new interfaceEventListener();
		
//		driver.register(AbstractListener);
		driver.register(interfaceListener);
		
		try
		{
			driver.navigate().to("https://www.guru99.com/take-screenshot-selenium-webdriver.html");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			
			driver.findElement(By.xpath("//*[@id=\"demo1\"]/li[37]/a")).click();
		
			driver.navigate().back();
//			System.out.println("Back Home ");
			
			driver.navigate().forward();
//			System.out.println("Forword Maven");
		}
		
		catch (Throwable t)
		{
			t.printStackTrace();
		}
		
		finally
		{
			driver.close();
			driver.quit();
		}
	}

}
