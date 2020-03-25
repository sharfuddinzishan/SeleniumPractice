package filesOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class props 
{
	static File file = null;
	static FileInputStream fis = null;
	static FileOutputStream fos = null;
	private static Properties prop =null;
	
	public props(String filePath) throws Throwable
	{
		file = new File(System.getProperty("user.dir")+filePath);
//		file.createNewFile();
		prop = new Properties();
	}
	
	public static void loadFile() throws Throwable
	{
		fis = new FileInputStream(file);
		prop.load(fis);
		fis.close();
		System.out.println("Loaded########"+"\n"+prop);
	}
	
	public static void saveFile(String Key, String keyVal) throws Throwable
	{
		fos = new FileOutputStream(file);
		prop.setProperty(Key, keyVal);
		prop.store(fos, null);
		fos.close();
	}
	
}
