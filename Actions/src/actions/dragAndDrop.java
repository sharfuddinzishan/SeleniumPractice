package actions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop {
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
		
        driver.get("https://jquery-drag-drop-demo.webflow.io");
        driver.manage().window().maximize();
		
		Actions acts = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		acts.dragAndDrop(source, target).build().perform();
		Thread.sleep(1500);
		acts.clickAndHold(source).moveToElement(target,-10,-10).release(source).build().perform();
		

		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}