package firefoxProfiles;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class firefoxProfiles 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		
		ProfilesIni profiles = new ProfilesIni();
		FirefoxProfile profile = profiles.getProfile("LiarZishan");
		
		FirefoxOptions option = new FirefoxOptions();
		option.setCapability(FirefoxDriver.PROFILE, profile);
		
		WebDriver driver = new FirefoxDriver(option);
		
		driver.get("https://google.com");
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		
		driver.quit();	
	}

}
 