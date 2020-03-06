package Captcha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class captchaStripReplaceAll {

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver81.exe");
	    ChromeOptions opt = new ChromeOptions();
	    opt.setBinary("C:\\Users\\LiarZishan\\AppData\\Local\\Chromium\\Application\\chrome.exe");
	    WebDriver driver = new ChromeDriver(opt);
	    
	    driver.get("https://www.jqueryscript.net/demo/Basic-Math-Captcha-Plugin/");
	    
	    String text = driver.findElement(By.xpath("//*[@id=\"captchaText\"]")).getText();
	    System.out.println("Retriving Text By WebElement is "+text);
	    
	    String replaceText = text.replaceAll("[\\=\\s]*", "");
	    System.out.println("Replaced text is now  "+replaceText);
	    
	    String[] splitText = replaceText.split("\\+");
	    
	    int n1 = Integer.valueOf(splitText[0]);
	    int n2 = Integer.valueOf(splitText[1]);
	    System.out.print(n1+" + "+n2+" "+"= ");

	    String sum = String.valueOf((n1+n2));
	    System.out.println(sum);
	    
	    driver.findElement(By.xpath(" //*[@id=\"captchaInput\"]")).sendKeys(sum);
	    Thread.sleep(3000);
	    
	    driver.quit();

	}

}
