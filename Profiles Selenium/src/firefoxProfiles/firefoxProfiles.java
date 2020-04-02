package firefoxProfiles;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class firefoxProfiles 
{

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		
		ProfilesIni profiles = new ProfilesIni();
		FirefoxProfile profile = profiles.getProfile("Selenium");
		if (profile == null) 
		{
			profile = new FirefoxProfile();
		}
		
		FirefoxOptions option = new FirefoxOptions();
		option.setCapability(FirefoxDriver.PROFILE, profile);

		WebDriver driver = new FirefoxDriver(option);
		
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
 