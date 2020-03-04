package checkChromium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class checkChromium {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver81.exe");

	    ChromeOptions opt = new ChromeOptions();

	    opt.setBinary("C:\\Users\\LiarZishan\\AppData\\Local\\Chromium\\Application\\chrome.exe");

	    WebDriver driver = new ChromeDriver(opt);

	    driver.get("https://www.google.com/");

	    System.out.println(driver.getTitle());
	    
	    driver.close();
	    driver.quit();
	}

}
