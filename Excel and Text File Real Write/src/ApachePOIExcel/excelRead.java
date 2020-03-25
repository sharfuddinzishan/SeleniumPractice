package ApachePOIExcel;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRead 
{
	private FileInputStream fis=null;
	private XSSFWorkbook workbook=null;
	private XSSFSheet sheet=null;
	String col=null;
	String FilePath=null;
	
	public excelRead(String excelFile) throws Throwable
	{
		this.FilePath = excelFile;
		this.fis= new FileInputStream(excelFile);
		this.workbook= new XSSFWorkbook(this.fis);
		fis.close();
	}
	
	public boolean viewtData(String sheetname ) throws Throwable
	{
		int sheetIndex = workbook.getSheetIndex(sheetname);
		
		if(sheetIndex==-1)
		{
			return false;
		}
		
		else
			sheet= workbook.getSheet(sheetname);
		
		for(Row row:sheet)
		{
			for(Cell cell:row)
			{
				switch(cell.getCellType())
				{
				case STRING :
					System.out.print(cell.getStringCellValue()+" ");
					break;
				case BLANK :
					System.out.print("Its Blank ");
					break;
				case NUMERIC :
					System.out.print((int)cell.getNumericCellValue()+" ");
					break;
				default:
					break;			
				}
			 }
			System.out.println();
		 } 
		return true;
		
	}
	
}
