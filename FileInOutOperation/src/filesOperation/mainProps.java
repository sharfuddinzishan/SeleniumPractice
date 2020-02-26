package filesOperation;


public class mainProps {

	public static void main(String[] args) throws Throwable 
	{
		String path = "\\src\\utilities\\mainProps.properties";
		new props(path);
		
		props.saveFile("Name", "Sharfuddin");
		props.saveFile("Id", "C101001R");
		props.saveFile("Dept", "CSE");
		
		props.loadFile();
	}

}
