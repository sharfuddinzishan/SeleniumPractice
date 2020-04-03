package explicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicilyWait2 
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
		
		WebDriverWait wait = new WebDriverWait(driver,10L); // It tries in every ms to loacte element
		wait.until(ExpectedConditions.presenceOfElementLocated(clickLoc)).click();
//		wait.until(ExpectedConditions.presenceOfElementLocated(wrongClickLoc)).click();
		
		driver.quit();
		System.out.println("quit");
	}
}
