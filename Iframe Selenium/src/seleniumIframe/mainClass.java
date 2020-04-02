package seleniumIframe;

import org.openqa.selenium.WebElement;

public class mainClass 
{
	public static String url = "https://chercher.tech/practice/frames";
	public static WebElement webelement = null;
	public static void main(String[] args) throws Throwable 
	{
		Driver driver = new Driver();
		
		try
		{
//			driver.firefoxDriver(url);
//			driver.quit();
			driver.chromeDriver(url);
			System.out.println(driver.iframeSize());
//			driver.iframeName("iamframe");
//			driver.iframeId("frame1");
			driver.iframe(0);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		finally
		{
			driver.quit();
		}
		
	}

}
