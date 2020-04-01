package screenShotSelenium;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class takeScreenShots 
{

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.opera.driver","operadriver.exe");
		WebDriver driver = new OperaDriver();
		
		driver.get("https://www.guru99.com/take-screenshot-selenium-webdriver.html");
		
		// TakesScreenshot is interface
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"\\screenshot\\screenshot.jpg")); 
		
		 /* 
		  * FileUtils founds in Apache Commons IO
		 * Selenium version 3.9.0 and above does not provide Apache Commons IO JAR.
		 *You have to download manually this JAR
		 */
		
		/*
		TakesScreenshot takeScreen = ((TakesScreenshot)driver);
		File srcFile = takeScreen.getScreenshotAs(OutputType.FILE);
		File destfile = new File(System.getProperty("user.dir")+"\\screenshot\\screenshot.jpg");
		*/
		
		System.out.println("Captured");
		driver.close();
		driver.quit();
	}

}
