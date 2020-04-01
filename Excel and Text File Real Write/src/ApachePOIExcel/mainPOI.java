package ApachePOIExcel;

public class mainPOI 
{
	/* 
	 * What happened if Sheet Name not matched or Sheet not created?
	 * How you count number of row or column, if sheet not exist
	 * How can u create row or count column, if no row exist in sheet?
	 * How can you insert data by giving column name but not index of column?
	 */

	public static void main(String[] args) throws Throwable 
	{
		String FilePath=System.getProperty("user.dir")+"\\src\\utilities\\mainPOI.xlsx";
		
		excelWrite wr= new excelWrite(FilePath);
		
		System.out.println("Before write Row Total: "+wr.getRowCount("login"));
		System.out.println("Before Write Column Total: "+wr.getColCount("login")+"\n");
		
		wr.insertData("login","Minar",3,0);
		wr.insertData("login","Samsuddin",3,1);
		
		
		wr.insertData("login","Manha",4,0);
		wr.insertData("login","Minnatun",4,1);
		wr.insertData("login","Yes",4,2);
		
		wr.insertData("login","LiarZishan",4,0); // Value replaced by previous one
		wr.insertData("login","Sharfuddin",4,1);
		wr.insertData("login","No",4,2);
		
		
		excelRead er= new excelRead(FilePath);
		er.viewtData("login");
		
		er.viewtData("login1"); // no login1 sheet exist
		
		System.out.println("\n"+"Row Total: "+wr.getRowCount("login"));
		System.out.println("Column Total: "+wr.getColCount("login"));
	}

}

