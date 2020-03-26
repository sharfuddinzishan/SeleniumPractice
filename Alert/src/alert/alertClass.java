package alert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Type of Operation’s perform on Alert:
 * accept() : To accept the alert.
 * dismiss() : To dismiss the alert.
 * getText() : To get the text of the alert.
 * sendKeys() : To write some text to the alert.
 */

public class alertClass 
{
	
	public static WebDriver driver=null;
	public static WebElement element = null;
	public static String xPath,xPath1,xPath2 = null;
	public static Alert alert=null;

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
		
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
		Thread.sleep(3000);
		
		xPath="//button[text()='Click for JS Alert']";
		xPath1="//button[text()='Click for JS Confirm']";
		xPath2="//button[text()='Click for JS Prompt']";
		
		accept(xPath);
		Thread.sleep(3000);
		
		dismissal(xPath1);
		Thread.sleep(3000);
		
		sendKey(xPath2,"LiarZishan");
		Thread.sleep(3000);
		
		
//		Actions action = new Actions(driver);
//		action.doubleClick(link).perform();
		
		driver.close();
		driver.quit();
	}
	
	public static void accept(String xPath) throws Throwable
	{
		driver.findElement(By.xpath(xPath)).click();
		alert = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println("Alert Text: "+alert.getText()+" Accepted ! !!!! !!!");
		alert.accept();
	}
	
	public static void dismissal(String xPath) throws Throwable
	{
		driver.findElement(By.xpath(xPath)).click();
		alert = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.print("Alert Text: "+alert.getText());
		alert.dismiss();
		System.out.println(" Dismissed ! !!!! !!!");
	}
	
	public static void sendKey(String xPath, String alert_msg) throws Throwable
	{
		driver.findElement(By.xpath(xPath)).click();
		alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.sendKeys(alert_msg);
		System.out.println("Alert Text: "+alert.getText()+" Message Inserted");
		alert.accept();
	}
	
}