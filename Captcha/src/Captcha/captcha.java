package Captcha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class captcha {

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver81.exe");
	    ChromeOptions opt = new ChromeOptions();
	    opt.setBinary("C:\\Users\\LiarZishan\\AppData\\Local\\Chromium\\Application\\chrome.exe");
	    WebDriver driver = new ChromeDriver(opt);
	    
	    driver.get("https://www.jqueryscript.net/demo/Basic-Math-Captcha-Plugin/");
	    
	    String text = driver.findElement(By.xpath("//*[@id=\"captchaText\"]")).getText();
	    System.out.print(text+" ");
	    
	    int num1 = Integer.valueOf((text.substring(0,1)));
	    int num2 = Integer.valueOf((text.substring(4,5)));
	    
	    String sum = String.valueOf((num1+num2));
	    System.out.println(sum);
	    
	    driver.findElement(By.xpath(" //*[@id=\"captchaInput\"]")).sendKeys(sum);
	    Thread.sleep(5000);
	    
	    driver.quit();
	}

}
