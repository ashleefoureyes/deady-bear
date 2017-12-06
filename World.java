import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class World 
{
	public static Room[][] rooms;
	public Location entrance;
	public Thing goal;
	//public Player[] playerList = {new Rick(0, 0, 100, new ArrayList<Thing>()), new LeftZombie(0, 0, 1, new ArrayList<Thing>()), new DeadlyNPC(0, 0, 1, new ArrayList<Thing>()), new FriendlyNPC(0, 0, 1, new ArrayList<Thing>())};
	//public Thing[] thingList = {new Shield("Shield", 0, 0, 0), new Food("Food", 0, 0, 0), new Poison("Poison", 0, 0, 0)};
	public static void main(String args[]) throws IOException
	{
		//initialRead();
		GUI x = new GUI();
		x.mainScreen();
	}

	//Testing and setting up File writing and reading
	public static void initialRead(String fileName) throws IOException
	{
		//Creates the directory for the file
		File file = new File("src/resources/"+fileName+".txt");
		
		//Allows for viewing of dev notes to make finding errors easier
		boolean tracing = true;
		      
		//Creates the file
		file.createNewFile();
		 
		//Writes content to the file (make sure to flush and close file when you're done)
		//FileWriter writer = new FileWriter(file); 
		//writer.write("This is\na\ntest"); 
		//writer.flush();
		//writer.close();
		
		
		
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		int totalLines = 0;
		while (reader.readLine() != null)
		{
			totalLines++;
		}
		reader.close();
		
		String[] fileInfo = new String[totalLines];
		int counter=0;
		String line;
		while((line = bufferedReader.readLine()) != null) 
		{
			fileInfo[counter]=line;
			if(tracing)stringBuffer.append(line);
			if(tracing)stringBuffer.append("\n");
			counter++;
		}
		fileReader.close();
		//if(tracing)System.out.println("Contents of file from stringBuffer:");
		//if(tracing)System.out.println(stringBuffer.toString());
		
		/*
		if(tracing)
		{
			System.out.println("\nContents of file from string array:");
			for(int temp=0;temp<totalLines;temp++)
			{
				System.out.println(fileInfo[temp]);
			}
		}
		*/
		
		int roomsSize = Integer.parseInt(fileInfo[0]);
		int halfRoomSize;
		if(roomsSize%2==0)
		{
			halfRoomSize = roomsSize/2;
			rooms = new Room[roomsSize/2][2];
		}
		else
		{
			halfRoomSize = (roomsSize/2)+1;
			rooms = new Room[(roomsSize/2)+1][2];
		}
		
		for(int temp=0;temp<halfRoomSize;temp++)
		{
			ArrayList<Player> p = new ArrayList<Player>();
			ArrayList<Thing> t = new ArrayList<Thing>();
			
			String[] resultsP = fileInfo[4].split(",");
			if(resultsP[0].equals("1"))
			{
				System.out.println("It works");
			}
			else if(resultsP[1].equals("1"))
			{
				
			}
			else if(resultsP[2].equals("1"))
			{
				
			}
			else if(resultsP[3].equals("1"))
			{
				
			}
			
			String[] resultsT = fileInfo[5].split(",");
			if(resultsT[0].equals("1"))
			{
				System.out.println("It works");
			}
			else if(resultsT[1].equals("1"))
			{
				
			}
			else if(resultsT[2].equals("1"))
			{
				
			}
			
			
			rooms[temp][0] = new Room(p, t, temp, 0, new boolean[]{false, false, false, false});
		}
		
		
		
		
		
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
		/*
		//Creates an String arrayList seperating things by spaces (so by word not by line|needs to be by line) 
		List<String> output = new ArrayList<>();
		for (String line : Files.readAllLines(Paths.get("src/resources/world1.txt"))) 
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
		*/
	}

	public Player getRoom(int xPosition, int yPosition) 
	{
		return null;
	}


	// ADDED but check if this works. It solves alot of errors but idk.

	public Room getRoom(Location location){
		return rooms[location.getRow()][location.getCol()];
	}

	public Room getRoom(Player p){
		int r = p.getLocation().getRow();
		int c = p.getLocation().getCol();
		return rooms[r][c];
	}
}