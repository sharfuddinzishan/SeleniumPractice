package ApachePOIExcel;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class basicPOI {

	public static void main(String[] args) throws Throwable 
	{
		String FilePath=System.getProperty("user.dir")+"\\src\\utilities\\basicPOI.xlsx";
		File file= new File(FilePath);
		FileInputStream fis= new FileInputStream(file);
		
        /*
        File -> WorkBook -> XSSFSheet -> XSSFRow -> XSSFCell
        */
		
        @SuppressWarnings("resource")
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
        XSSFSheet sheet= workbook.getSheet("Sheet1");
        XSSFRow row= sheet.getRow(0);
        int collCount= row.getLastCellNum();
        int rowCount = sheet.getLastRowNum()+1;
        
        System.out.print("Row "+rowCount+"\n"+"Column "+collCount);
	}

}
