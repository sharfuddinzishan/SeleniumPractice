package ApachePOIExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelWrite 
{
	private FileInputStream fis=null;
	private XSSFWorkbook workbook=null;
	private XSSFSheet sheet=null;
	private XSSFRow row=null;
	private XSSFCell cell=null;
	String col=null;
	String FilePath=null;
	
	public excelWrite(String excelFile) throws Throwable
	{
		this.FilePath = excelFile;
		this.fis= new FileInputStream(excelFile);
		this.workbook= new XSSFWorkbook(this.fis);
		fis.close();
	}
	
	public int getRowCount(String sheetName)
	{
		int sheetIndex = workbook.getSheetIndex(sheetName);
      
	    if(sheetIndex==-1) // No sheet name matched
	    {
//	    	sheet= workbook.createSheet(sheetName);
	    	return 0;
	    }
	    
	    else
	    	sheet= workbook.getSheet(sheetName);
	    
	    return sheet.getLastRowNum()+1;    
	}
	
	public int getColCount(String sheetName)
	{
		int sheetIndex = workbook.getSheetIndex(sheetName);
		
		if(sheetIndex==-1)
	    {
	    	return 0;
	    }
	    
	    else
	    	sheet= workbook.getSheet(sheetName);
		
		int a= sheet.getLastRowNum();
		row=sheet.getRow(a);
		
		if(row==null)
		{
			return 0;
		}
		
		return row.getLastCellNum();
	}
	
	public boolean insertData(String sheetname, String inputData, int columnIndex ) throws Throwable
	{
		sheet= workbook.getSheet(sheetname);
		int rowNb=sheet.getLastRowNum()+1;
		row= sheet.createRow(rowNb);
		cell=row.createCell(columnIndex);
		cell.setCellValue(inputData);
		
		FileOutputStream fout = new FileOutputStream(FilePath);
		workbook.write(fout);
		fout.close();
		
		return true;
	}
	
	public boolean insertData(String sheetname, String inputData, int rowIndex,int columnIndex ) throws Throwable
	{
		int rowIndex1 = workbook.getSheetIndex(sheetname);
		
		if(rowIndex1==-1)
		{
			sheet= workbook.createSheet(sheetname);
		}
		
		else
			sheet= workbook.getSheet(sheetname);
		
		row= sheet.getRow(rowIndex);
		
	    if(row==null) // Given row not exist then create row and set data by creating cell
		{
			row= sheet.createRow(rowIndex);	
		}
	    
		cell=row.createCell(columnIndex);
		cell.setCellValue(inputData);
		
		FileOutputStream fout = new FileOutputStream(FilePath);
		workbook.write(fout);
		
		fout.close();
		
		return true;
		
	}
	
}
