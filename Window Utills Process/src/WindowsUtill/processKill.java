package WindowsUtill;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;




public class processKill 
{
	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		WindowsUtils.killByName("RuntimeBroker.exe");
		
		driver.navigate().to("https://www.facebook.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.google.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		driver.navigate().to("https://github.com/sharfuddinzishan/SeleniumPractice");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		WindowsUtils.killByName("geckodriver.exe");
		System.out.println("quit");
	}
}
