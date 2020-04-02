package chromeProfiles;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeProfiles 
{

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver","chromedriver81.exe");
		
		ChromeOptions option = new ChromeOptions();
		option.setBinary("C:\\Users\\LiarZishan\\AppData\\Local\\Chromium\\Application\\chrome.exe");
		option.setAcceptInsecureCerts(true);
		// Hide Chrome is being control by
		option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		
		option.addArguments("start-maximized");
		option.addArguments("user-data-dir=C:\\Users\\LiarZishan\\AppData\\Local\\Chromium\\User Data");
		option.addArguments("--profile-directory=Profile 1");


		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://untrusted-root.badssl.com");
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		System.out.println("Title : "+driver.getTitle());
		Thread.sleep(1500);
		WebElement ele = driver.findElement(By.id("content"));
		System.out.println(ele.getText());
		Thread.sleep(1500);
		
		driver.quit();	
		System.out.println("Quit");
	}

}
 