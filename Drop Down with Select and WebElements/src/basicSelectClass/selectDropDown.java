package basicSelectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
/*
 * Task : Get an value for specific index and skip the later execution
 * Task : Select radio button
 * Alternative of select.getOptions is stored findElements in WebDriver type list
 * Custom findElements, we need to locate the location and then click
 * but in select, all list are stored and click done when you called a method.
 * Select only works with select tag and xpath shuold be from Select tag
 * For radio Button, Select not works, used findElements
 */
public class selectDropDown {

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.opera.driver", "operadriver.exe");
		WebDriver driver = new OperaDriver();
		String webURL="http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html";
		driver.get(webURL);
		
		String selectPath= "//select[@id='dropdowm-menu-1']";
		String selectPath2= "//select[@id='dropdowm-menu-2']";
		String selectPath3= "//select[@id='dropdowm-menu-3']";
		String selectPath4= "//*[@id='checkboxes']";
		
		
		WebElement element = driver.findElement(By.xpath(selectPath));
		WebElement element2 = driver.findElement(By.xpath(selectPath2));
		WebElement element3 = driver.findElement(By.xpath(selectPath3));
		WebElement element4 = driver.findElement(By.xpath(selectPath4));
		
		Thread.sleep(2500);
		
		selectByVisibleText(element,"Python");
		selectByVisibleText(element2,"JUnit");
		selectByVisibleText(element3,"HTML");
		
		Thread.sleep(2000);
		
		String testData = "SQL-Maven-CSS";
		String[] str =testData.split("-");
		
		selectByVisibleText(element,str[0]);
		selectByVisibleText(element2,str[1]);
		selectByVisibleText(element3,str[2]);
		
		Thread.sleep(2000);
		
		selectByIndex(element,0);
		selectByIndex(element2,0);
		selectByIndex(element3,0);
		
//		isMultiple(element4);// Select class support only select tag	
		isMultiple(element);
		
		getOptions(element); // to get all elements from Select reference
		
		Thread.sleep(1500);
		
		driver.close();
		driver.quit();
	}
	
	public static void selectByVisibleText(WebElement element, String textValue)
	{
		Select select = new Select(element);
		select.selectByVisibleText(textValue);
	}
	
	public static void selectByIndex(WebElement element, int indexValue)
	{
		Select select = new Select(element);
		select.selectByIndex(indexValue);
	}
	
	public static void isMultiple(WebElement element)
	{
		Select select = new Select(element);
		System.out.println("Multple Select Supported? "+select.isMultiple());
	}
	
	public static void getOptions(WebElement element)
	{
		Select select = new Select(element);
		List<WebElement> list =select.getOptions();
		
		int size = list.size();
		System.out.println("Total Item from getOptions() "+list.size());
		
		for(int i=0; i<size;i++)
		{
			System.out.print(list.get(i).isSelected()+" ");
			System.out.println(list.get(i).getText());
		}
	}

}
