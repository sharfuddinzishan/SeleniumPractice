package seleniumHandler4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumHandler4 {

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
        
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        
        Set<String> s = driver.getWindowHandles();
        List<String> list = new ArrayList<String>(s);
        
        driver.switchTo().window(list.get(1));
        driver.get("https://www.w3schools.com/php/php_intro.asp");
        System.out.println(driver.getTitle());
        Thread.sleep(4000);
        
        driver.switchTo().window(list.get(2));
        driver.get("https://www.w3schools.com/css/default.asp");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        
        driver.switchTo().window(list.get(0));
        driver.get("https://www.w3schools.com/sql/default.asp");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        
        driver.close();
        
        Thread.sleep(2000);
        driver.quit();
        
        System.out.println("QUIT");

	}

}
