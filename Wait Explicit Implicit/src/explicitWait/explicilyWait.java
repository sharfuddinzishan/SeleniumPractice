package explicitWait;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class explicilyWait 
{
	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.google.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		By locator = By.name("q");
		By clickLoc =By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[2]/div[2]/ul/li[5]");
		By wrongClickLoc =By.xpath("/html/body/form/div[2]/div[1]/div[2]/div[2]/ul/li[5]");
		
		driver.findElement(locator).sendKeys("Selenium");
		
		Wait <WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(600))
		.ignoring(NoSuchElementException.class)
		.withMessage("Element Not Found. Liar Zishan"); // It tries every 2s within 20seconds to find element. so it checks 10 times only
		wait.until(ExpectedConditions.presenceOfElementLocated(clickLoc)).click();
//		wait.until(ExpectedConditions.presenceOfElementLocated(wrongClickLoc)).click();
		
		driver.quit();
		System.out.println("quit");
	}
}
