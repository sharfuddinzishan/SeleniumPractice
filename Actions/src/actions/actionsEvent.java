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
import org.openqa.selenium.interactions.Action;
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
		
        driver.get("https://www.jqueryscript.net/demo/drag-drop-image-uploader/");
        driver.manage().window().maximize();
		
        By pageDown = By.xpath("//*[@id='form-example-2']/button");
        driver.findElement(pageDown).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		
		Actions acts = new Actions(driver);
        By name = By.id("name-2");
        WebElement doubleClick = driver.findElement(name);
		Action act=acts.moveToElement(doubleClick).doubleClick().keyDown(Keys.CONTROL).sendKeys("a").
		keyUp(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("liar Zishan").keyUp(Keys.SHIFT).build();
		act.perform();
		Thread.sleep(2000);
		
		WebElement image1 = driver.findElement(By.xpath("//img[@src='https://picsum.photos/500/500?random=1']"));
		WebElement image1Click = driver.findElement(By.xpath("//img[@src='https://picsum.photos/500/500?random=1']//following::button[1]//i"));
		acts.moveToElement(image1).click().click(image1Click).build().perform();
		Thread.sleep(2000);
		
		acts.contextClick(image1).moveByOffset(100,100).build().perform();
		

		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}