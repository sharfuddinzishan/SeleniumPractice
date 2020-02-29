package navigationSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class navigationSelenium 
{

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.opera.driver","operadriver.exe");
		WebDriver driver = new OperaDriver();
		
		driver.get("https://www.guru99.com/take-screenshot-selenium-webdriver.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//*[@id=\"demo1\"]/li[37]/a")).click();
	
		
		driver.navigate().back();
		System.out.println("Back Home ");
		
		Thread.sleep(2000);
		
		driver.navigate().forward();
		System.out.println("Forword Maven");
		
		driver.quit();
		
	}

}
