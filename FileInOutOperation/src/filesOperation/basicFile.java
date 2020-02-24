package filesOperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class basicFile {

	public static void main(String[] args) throws Throwable 
	{
		/* create new file class object */
		File file=new File(System.getProperty("user.dir")+"\\src\\utilities\\basicFile.txt");
		
		if (!file.exists()) {
		     file.createNewFile(); // return true or false
		  }; 
	
		/* write character-oriented data to a file */
		FileWriter fw = new FileWriter(file);
//		FileWriter fw = new FileWriter(file,true);
		
		/* BufferedWriter writes a larger block at a time */
		BufferedWriter writer = new BufferedWriter(fw);
		
		int count = (int) (Math.random()*3)+3;
		
		for (int i=0; i<=count; i++)
		{
			for(int j=0; j<=count; j++)
			{
				writer.write((int) (Math.random()*60)+"\t");
			}
			writer.newLine();
		}
		
		/* assure that any buffered data will be flushed (written) to disk */
		writer.flush();
		/* close the Writer instance to which the BufferedWriter is writing.
		 *  FileWriter will closed also. 
		 */
		writer.close();
		
		
		FileReader fr = new FileReader(file);
		BufferedReader reader = new BufferedReader(fr);
		
		String line = null;
		
		while((line=reader.readLine())!=null)
		{
			System.out.println(line);
		}
		reader.close();
	}

}
