package seleniumIframe;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Driver 
{
	public static WebDriver webDriver = null;
	public static WebElement element = null;
	public static EventFiringWebDriver driver = null;
	public static listner listner = null;
	public static ProfilesIni profiles = null;
	public static FirefoxProfile profile = null;
	public static FirefoxOptions options = null;
	public static ChromeOptions option = null;
	
	public void firefoxDriver(String URL)
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./Firefox.log");
		
		profiles = new ProfilesIni();
		profile = profiles.getProfile("LiarZishan");
		
		options = new FirefoxOptions();
		options.setCapability(FirefoxDriver.PROFILE, profile);
		
		webDriver = new FirefoxDriver(options);
		
		driver = new EventFiringWebDriver(webDriver);
		listner = new listner();
		driver.register(listner);
		
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public void chromeDriver(String URL)
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver81.exe");
		System.setProperty("webdriver.chrome.logfile", "./Chrome.log");
		
		option = new ChromeOptions();
		
		option.addArguments("start-maximized");
		option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		option.addArguments("user-data-dir=C:\\Users\\LiarZishan\\AppData\\Local\\Chromium\\User Data");
		option.addArguments("--profile-directory=Profile 1");
		webDriver = new ChromeDriver(option);
		
		driver = new EventFiringWebDriver(webDriver);
		listner = new listner();
		driver.register(listner);
		
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	public int iframeSize()
	{
//		int num = driver.findElements(By.tagName("iframe")).size();
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer num = Integer.parseInt(exe.executeScript("return window.length").toString());
		return num;
	}
	
	public void iframe( int index )
	{
//		driver.switchTo().frame(driver.findElements(By.tagName("iframe")).get(index));
		
		int size = driver.findElements(By.tagName("iframe")).size();
		for(int i=0; i<size; i++)
		{
			if(i==index)
			{
				driver.switchTo().frame(i);
				System.out.println("iframe number "+i);
				driver.findElement(By.xpath("/html/body/input")).clear();
				driver.findElement(By.xpath("/html/body/input")).sendKeys("LiarZishan");
				driver.switchTo().defaultContent();
				break;
			}
			else
				continue;
		}
		
	}
	
	public void iframeName( String FrameName)
	{
		element = driver.findElement(By.name(FrameName));
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("/html/body/input")).clear();
		driver.findElement(By.xpath("/html/body/input")).sendKeys("LiarZishan");
		driver.switchTo().defaultContent();
	}
	
	public void iframeId( String FrameId)
	{
		element = driver.findElement(By.id(FrameId));
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("/html/body/input")).clear();
		driver.findElement(By.xpath("/html/body/input")).sendKeys("LiarZishan");
		driver.switchTo().defaultContent();
	}
	
	public void quit() throws Throwable
	{
		Thread.sleep(5000);
		driver.close(); // It will generate On Exception
		driver.quit();
	}
}
