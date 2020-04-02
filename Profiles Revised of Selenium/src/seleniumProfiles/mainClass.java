package seleniumProfiles;


public class mainClass 
{
	public static String url = "https://google.com";
	public static void main(String[] args) throws Throwable 
	{
		try
		{
			Driver.firefoxDriver(url);
//			Driver.chromeDriver(url);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		finally
		{
			Driver.quit();
		}
		
	}

}
