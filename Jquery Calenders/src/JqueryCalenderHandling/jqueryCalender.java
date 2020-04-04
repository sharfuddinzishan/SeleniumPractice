package JqueryCalenderHandling;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class jqueryCalender 
{
	static int currentDay = 0, currentMonth = 0, currentYear = 0;
	
	static int targetDay = 0, targetMonth = 0, targetYear = 0;
	
	static boolean  increment = true;
	
	public static void main(String[] args) throws Throwable 
	{
		String myDate = "06/01/1989";
		
		getCurrentDate();
		
		System.out.println("Today is : "+currentDay+"-"+currentMonth+"-"+currentYear);
		
		getTargetDate(myDate);
		
		
		System.out.println("My Date : "+targetDay+"-"+targetMonth+"-"+targetYear);
		
		System.out.println("Month Difference : "+geMonthDiff());
		
		System.out.println(increment);
		
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.navigate().to("https://jqueryui.com/resources/demos/datepicker/other-months.html");
		
		By datePicker = By.xpath("//*[@id='datepicker']");
		By nextClick = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span");
		By previousClick = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span");
		
		driver.findElement(datePicker).click();
		Thread.sleep(2000);
		
		int num = geMonthDiff();
		for (int i=0; i<num; i++)
		{
			if(increment)
			{
				driver.findElement(nextClick).click();
			}
			else
			{
				driver.findElement(previousClick).click();
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	public static void getCurrentDate()
	{
		Calendar cal = Calendar.getInstance();
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH)+1;
		currentYear = cal.get(Calendar.YEAR);
	}
	
	public static void getTargetDate(String myDate)
	{
		String[] splitDate = myDate.split("\\/");
		targetDay = Integer.parseInt(splitDate[0]);
		targetMonth = Integer.parseInt(splitDate[1]);;
		targetYear = Integer.parseInt(splitDate[2]);;
	}
	
	public static int geMonthDiff()
	{
		if((targetMonth-currentMonth)>0)
		{
			return (targetMonth-currentMonth);
		}
		else
		{
			increment=false;
			return (currentMonth-targetMonth);
		}
	}
}
