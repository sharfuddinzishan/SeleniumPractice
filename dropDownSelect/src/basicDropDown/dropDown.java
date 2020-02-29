package basicDropDown;

public class dropDown {
	
	
	public static String driverURL=null;
	public static String webURL=null; // As main method is static so non-static not allowed

	public static void main(String[] args) throws Throwable 
	{
		webURL="http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html";
		driverURL="operadriver.exe";
		gDriver.createDriver(driverURL, "opera",webURL); // Check gDriver.java File
		
		String selectPath="//select[@id='dropdowm-menu-1']";
		String optionPath= "//select[@id='dropdowm-menu-1']//option";
		
		gDriver.getText(optionPath);
		gDriver.getAttribute(optionPath,"value");
		
		gDriver.getText(selectPath);
		gDriver.getAttribute(selectPath,"value");
		
		gDriver.showElement(optionPath,"value");
		gDriver.showElement(selectPath,"value");
		
		gDriver.closeDriver();
	}

}
