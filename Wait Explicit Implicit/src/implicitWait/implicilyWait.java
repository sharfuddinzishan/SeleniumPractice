package implicitWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class implicilyWait 
{
	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.navigate().to("https://github.com/sharfuddinzishan/SeleniumPractice");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("/html/body/div[4]/div/main/div[2]/div/div[4]/span/details/summary")).click();
		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("quit");
	}
}
