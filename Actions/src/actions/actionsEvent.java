package actions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class actionsEvent {
	public static WebDriver driver=null;
	public static WebElement btn = null;

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\driver.properties"));
		Properties prop = new Properties();
		prop.load(fis);
		
		String chromedriver=prop.getProperty("chromiumDriver");
		String chromeurl=prop.getProperty("chromiumUrl");
		System.setProperty(chromedriver,chromeurl);
		
		ChromeOptions option = new ChromeOptions();
		option.setBinary("C:\\Users\\LiarZishan\\AppData\\Local\\Chromium\\Application\\chrome.exe");
		driver = new ChromeDriver();
		
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();
		
		driver.findElement(By.id("dblClkBtn")).sendKeys(Keys.PAGE_DOWN);
		
		btn = driver.findElement(By.id("dblClkBtn"));
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.doubleClick(btn).perform();
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();
	}

}