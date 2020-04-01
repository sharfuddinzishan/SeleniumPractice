package screenShotSelenium;

import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class screenAShot {

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.opera.driver","operadriver.exe");
		WebDriver driver = new OperaDriver();
		
		driver.get("http://bcc.gov.bd");
		driver.manage().window().maximize();
		
//		Screenshot screenshot = new AShot().takeScreenshot(driver);
		/*
		 * 1000 is scrolled out time in milliseconds, 
		 * so for taking a screenshot, 
		 * the program will scroll for each 1000 msec.
		*/
		
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		
		ImageIO.write(screenshot.getImage(), "jpg", new File(System.getProperty("user.dir")+"\\screenshot\\screenshot4.jpg"));

		System.out.println("Captured");
		
		driver.close();
		driver.quit();
	}

}
