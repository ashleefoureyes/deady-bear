import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class world 
{
	public static void main(String args[]) throws IOException
	{
		fileTesting();
	}
	
	//Testing and setting up File writing and reading
	public static void fileTesting() throws IOException
	{
		File file = new File("test.txt");
		
		//Allows for viewing of dev notes to make finding errors easier
		boolean tracing = true;
		      
		//Creates the file
		file.createNewFile();
		 
		FileWriter writer = new FileWriter(file); 
		  
		//Writes content to the file (make sure to flush and close file when you're done)
		writer.write("This\nis\na\ntest"); 
		writer.flush();
		writer.close();
		
		/*Finds the number of lines in the file (will need later)
		BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
		int lines = 0;
		while (reader.readLine() != null)
		{
			lines++;
		}
		reader.close();
		if(tracing)System.out.println("Line numbers in test.txt: "+lines);
		*/
		
		//Creates an String arrayList seperating things by spaces (so by word not by line|needs to be by line) 
		List<String> output = new ArrayList<>();
		for (String line : Files.readAllLines(Paths.get("test.txt"))) 
		{
		    for (String part : line.split("\\s+")) 
		    {
		        String i = part;
		        output.add(i);
		    }
		}
		
		System.out.println("Contents of test.txt in list form: " + output);
		
		//Creates a String array from the arrayList (I like working with arrays more)
		String[] sOutput = output.toArray(new String[output.size()]);
		System.out.print("Contents of test.txt in array form: ");
		for(int x=0;x<sOutput.length;x++)
		{
			//Removes the last character in the string|not necessary right now
			//sOutput[x] = sOutput[x].substring(0, sOutput[x].length() - 1);
			System.out.print(sOutput[x]+", ");
		}
	}
}