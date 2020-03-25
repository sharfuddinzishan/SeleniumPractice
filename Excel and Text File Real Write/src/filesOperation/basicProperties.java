package filesOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class basicProperties {

	public static void main(String[] args) throws Throwable 
	{
		File file = new File(System.getProperty("user.dir")+"\\src\\utilities\\basicProperties.properties");
		
		/*
		 * Java FileInputStream class obtains input bytes from a file. 
		 * It extends the InputStream abstract class.
		 * It is used for reading (streams of raw bytes) such as image data, audio, video etc. 
		 * You can also read character-stream data. 
		 * But, for reading streams of characters, it is recommended to use FileReader class.
		 */
		FileInputStream fis = new FileInputStream(file);
		
		/*
		 * Properties class is a subclass of Hashtable
		 * to maintain lists of values 
		 * key is a String and the value is also a String.
		 */
		Properties prop = new Properties();
		/* Inputs a property list from the input stream */
		prop.load(fis);
		
		System.out.println(prop.getProperty("Name"));
		prop.setProperty("Pass", "Yes");
		System.out.println(prop.getProperty("Pass"));
		
		
		FileOutputStream output = new FileOutputStream(file);
		prop.store(output, null);
		System.out.println(prop);
		
		System.out.println(prop.keySet());
		
		prop.forEach((k, v) -> 
		System.out.println("Key : " + k + ", Value : " + v));
	}

}
