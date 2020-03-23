package mouseEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

public class mouseEvent 
{

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver81.exe");
		ChromeOptions option = new ChromeOptions();
		option.setBinary("C:\\Users\\LiarZishan\\AppData\\Local\\Chromium\\Application\\chrome.exe");
		WebDriver webDriver = new ChromeDriver(option);
		
		listenerMouse listener = new listenerMouse();
		
		EventFiringWebDriver driver = new EventFiringWebDriver(webDriver);
		driver.register(listener);
		
		driver.navigate().to("https://www.cricbuzz.com");
		EventFiringMouse mouse = new EventFiringMouse(driver,listener);
		Locatable loc = (Locatable) driver.findElement(By.xpath("//*[@id=\"teamDropDown\"]/a"));
		Coordinates co =loc.getCoordinates();
		mouse.mouseMove(co);
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
