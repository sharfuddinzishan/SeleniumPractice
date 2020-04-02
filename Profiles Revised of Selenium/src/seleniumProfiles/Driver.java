package seleniumProfiles;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
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
	public static EventFiringWebDriver driver = null;
	public static listner listner = null;
	public static ProfilesIni profiles = null;
	public static FirefoxProfile profile = null;
	public static FirefoxOptions options = null;
	public static ChromeOptions option = null;
	
	public static void firefoxDriver(String URL)
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./Firefox.log");
		
		profiles = new ProfilesIni();
		profile = profiles.getProfile("Selenium");
		
		options = new FirefoxOptions();
		options.setCapability(FirefoxDriver.PROFILE, profile);
		
		webDriver = new FirefoxDriver(options);
		
		driver = new EventFiringWebDriver(webDriver);
		listner = new listner();
		driver.register(listner);
		
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public static void chromeDriver(String URL)
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
	
	public static void quit() throws Throwable
	{
		Thread.sleep(5000);
//		driver.close(); // It will generate On Exception
		driver.quit();
	}
}
