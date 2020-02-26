package log4jMail;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/*
 * Console
 * File
 * Mail
 */
public class HelloLog4j {
	public static void main(String[] args) 
	{     
//		PropertyConfigurator.configure("src\\log4j.properties");
//		Logger logger = Logger.getLogger(HelloLog4j.class);
		Logger logger = LogManager.getLogger(HelloLog4j.class);
		
		logger.debug("This is debug message");

		System.out.println("Logic executed successfully....");
		logger.info("This is info message");
		logger.fatal("This is fatal message");
	}


}
