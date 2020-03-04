package browserLogGenerate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browserLogs 
{
	public static WebDriver driver = null;
	
	public static void main(String[] args) 
	{
		chromeDriver();
		
		driver.navigate().to("https://google.com");
		System.out.println(driver.getTitle());
		
		driver.quit();
	}
	
	public static void chromeDriver()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver81.exe");
		System.setProperty("webdriver.chrome.logfile", "./Chrome.log"); // Its generate logs file
	    ChromeOptions opt = new ChromeOptions();
	    opt.setBinary("C:\\Users\\LiarZishan\\AppData\\Local\\Chromium\\Application\\chrome.exe");
	    driver = new ChromeDriver(opt);
	}
	
	public static void firefoxDriver()
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./Firefox.log");
		driver = new FirefoxDriver();
	}

}
