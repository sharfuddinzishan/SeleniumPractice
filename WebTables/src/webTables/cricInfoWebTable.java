package webTables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cricInfoWebTable 
{
	public static WebDriver driver = null;
	public static XSSFWorkbook wb = null;
	public static XSSFSheet sheet = null;
	public static Row row = null;
	public static Cell cell = null;
	public static FileInputStream fis = null;
	public static FileOutputStream fos = null;

	public static void main(String[] args) throws Throwable 
	{
//		firefoxDriver();
		chromeDriver();
		
		String url ="https://www.cricbuzz.com/live-cricket-scorecard/27025/ban-vs-zim-2nd-odi-zimbabwe-tour-of-bangladesh-2020";
		getSite(url);
		
		/* ***************Row Column Initialize, XPATH Assign to find row and cell ***** */
		String[][] str = new String[10][4];
		
		String start ="//*[@id='innings_1']/div[1]/div[";
		String middle = "]/div[";
		String end ="]";
		
		/* *****************Store Data in Workbook ************************************** */
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("cricket");
		
		for (int i=0;i<10;i++)
		{
			row = sheet.createRow(i);
			for (int j=0;j<4;j++)
			{
				str[i][j]= driver.findElement(By.xpath(start+(i+3)+middle+(j+1)+end)).getText();
				cell = row.createCell(j);
				cell.setCellValue(str[i][j]);
			}
		}
		
		/* **************** File Created and Workbook stored data are stored in Excel ****** */
		File file = new File (System.getProperty("user.dir")+"\\scoreboard.xlsx");
		if(!file.exists())
		{
			file.createNewFile();
		}
		
		fos = new FileOutputStream(file);
		
		wb.write(fos);
		fos.flush();
		fos.close();
		wb.close();
		
		/* **************************** Show Excel Data  ************************ */
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("cricket");
		
		for(Row row:sheet)
		{
			for(Cell cell:row)
			{
				System.out.print(cell.getStringCellValue()+"||");
			}
			System.out.println();
		}
		/* ****************************  ************************ */
		
		driver.quit();

	}
	
	public static void chromeDriver()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver81.exe");
		System.setProperty("webdriver.chrome.logfile", "./Chrome.log"); // Its generate logs file
	    ChromeOptions opt = new ChromeOptions();
	    opt.setBinary("C:\\Users\\LiarZishan\\AppData\\Local\\Chromium\\Application\\chrome.exe");
	    driver = new ChromeDriver(opt);
	}
	
	public static void firefoxDriver()
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./Firefox.log");
		driver = new FirefoxDriver();
	}
	
	public static void getSite(String url) throws Throwable
	{
		driver.get(url);
		Thread.sleep(3000);
		driver.manage().window().maximize();
	}

}
