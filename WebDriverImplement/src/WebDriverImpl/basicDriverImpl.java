package WebDriverImpl;

import com.openqa.selenium.WebDriver;
import com.openqa.selenium.chrome.ChromeDriver;
import com.openqa.selenium.firefox.FirefoxDriver;
/*
 * Here Import a zishanDriver003.jar files (custom created) to support WebDriver
 * You Find this jar file information from WebDriverBasic java project which later export as .jar and
 * import in this project
 */
public class basicDriverImpl 
{
	public static void main(String[] args) 
	{
		FirefoxDriver firefox = new FirefoxDriver();
		firefox.click("username");
		
		
		WebDriver driver = new ChromeDriver();
		driver.sendKeys("Password", "123");
	}
}
