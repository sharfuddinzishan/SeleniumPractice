package WindowHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;


public class getWindowHandlers 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.opera.driver","operadriver.exe");
		WebDriver driver = new OperaDriver();
						
        driver.get("http://demo.guru99.com/popup.php");
        driver.manage().window().maximize();	 
        
        driver.findElement(By.xpath("//*[contains(@href,'articles_popup.php')]")).click();
        System.out.println("Please wait to load page");
        driver.get("https://www.w3schools.com/css/default.asp"); 
        // driver points now facebook not open in new tab, this problem overcome in selenium 4
        Set<String> s1=driver.getWindowHandles(); // As set not allowed duplicate values	
     
        
/*      Iterator<String> i1=s1.iterator();
        String mainWin=  i1.next();
		String childWin=  i1.next();
 */
        
        List<String> i1 = new ArrayList<String>(s1);
        String mainWin=  i1.get(0);
        String childWin=  i1.get(1);
        
        
        
		driver.switchTo().window(mainWin);
		Thread.sleep(3000);
		driver.get("https://www.w3schools.com/sql/default.asp"); 
		driver.switchTo().window(childWin); // Now driver points to second window
		driver.findElement(By.name("emailid")).sendKeys("selenium.zishan@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		
		driver.switchTo().window(childWin);
		driver.close();
		Thread.sleep(1000);
 
		driver.quit();
		System.out.println("Driver Quit");
		
	}
}
