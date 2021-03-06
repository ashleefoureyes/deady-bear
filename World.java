import java.io.*;
import java.util.ArrayList;

//Created by Matthew Kaprielian-Seferian

public class World 
{
	public static Room[][] rooms;
	public static Location entrance;
	public static Player human;
	public static Thing goal;
	public Player[] playerList = {new Rick(0, 0, 100, new ArrayList<Thing>()), new LeftZombie(0, 0, 1, new ArrayList<Thing>()), new DeadlyNPC(0, 0, 1, new ArrayList<Thing>()), new FriendlyNPC(0, 0, 1, new ArrayList<Thing>())};
	public Thing[] thingList = {new Shield("Shield", 0, 0, 0), new Food("Food", 0, 0, 0), new Poison("Poison", 0, 0, 0)};
	
	public static void main(String args[]) throws IOException
	{
		//initialRead();
		GUI x = new GUI();
		x.mainScreen();
		System.out.println("done");
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
		
		
		//This finds the total amount of lines in the file.
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
		
		//Creates a string array by line of the text file
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
		//Tests the code
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
		
		//Creates the rectangle structure of the map
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
		
		//Declares the 2D array of rooms
		int roomNumber=0;
		for(int temp=0;temp<halfRoomSize;temp++)
		{
			ArrayList<Player> p = new ArrayList<Player>();
			ArrayList<Thing> t = new ArrayList<Thing>();
			
			String[] resultsP = fileInfo[4+roomNumber].split(",");
			if(resultsP[0].equals("1"))
			{
				p.add(new Rick(temp, 0, 100, new ArrayList<Thing>()));
			}
			else if(resultsP[1].equals("1"))
			{
				p.add(new LeftZombie(temp, 0, 1, new ArrayList<Thing>()));
			}
			else if(resultsP[2].equals("1"))
			{
				p.add(new DeadlyNPC(temp, 0, 1, new ArrayList<Thing>()));
			}
			else if(resultsP[3].equals("1"))
			{
				p.add(new FriendlyNPC(temp, 0, 1, new ArrayList<Thing>()));
			}
			
			String[] resultsT = fileInfo[5+roomNumber].split(",");
			if(resultsT[0].equals("1"))
			{
				t.add(new Shield("Shield", 0, temp, 0));
			}
			else if(resultsT[1].equals("1"))
			{
				t.add(new Food("Food", 0, temp, 0));
			}
			else if(resultsT[2].equals("1"))
			{
				t.add(new Poison("Poison", 0, 0, 0));
			}
			
			String[] resultsR = fileInfo[3].split(",");
			boolean[] b = new boolean[4];
			for(int temp1=0;temp1<b.length;temp1++)
			{
				b[temp1]=false;
			}
			
			for(int temp1=0;temp1<resultsR.length;temp1++)
			{
				if(Integer.parseInt(resultsR[0])==temp+1)
				{
					if(temp!=halfRoomSize)
					{
						b[1]=true;
					}
				}
				if((temp+halfRoomSize)==Integer.parseInt(resultsR[temp1]))
				{
					b[2]=true;
				}
				if(temp-1==Integer.parseInt(resultsR[temp1]))
				{
					b[3]=true;
				}
			}
			
			rooms[temp][0] = new Room(p, t, temp, 0, b);
			roomNumber+=5;
		}
		for(int temp=halfRoomSize;temp<roomsSize;temp++)
		{
			ArrayList<Player> p = new ArrayList<Player>();
			ArrayList<Thing> t = new ArrayList<Thing>();
			
			String[] resultsP = fileInfo[4+roomNumber].split(",");
			if(resultsP[0].equals("1"))
			{
				p.add(new Rick(temp, 1, 100, new ArrayList<Thing>()));
			}
			else if(resultsP[1].equals("1"))
			{
				p.add(new LeftZombie(temp, 1, 1, new ArrayList<Thing>()));
			}
			else if(resultsP[2].equals("1"))
			{
				p.add(new DeadlyNPC(temp, 1, 1, new ArrayList<Thing>()));
			}
			else if(resultsP[3].equals("1"))
			{
				p.add(new FriendlyNPC(temp, 1, 1, new ArrayList<Thing>()));
			}
			
			String[] resultsT = fileInfo[5+roomNumber].split(",");
			if(resultsT[0].equals("1"))
			{
				t.add(new Shield("Shield", 1, temp, 0));
			}
			else if(resultsT[1].equals("1"))
			{
				t.add(new Food("Food", 1, temp, 0));
			}
			else if(resultsT[2].equals("1"))
			{
				t.add(new Poison("Poison", 1, temp, 0));
			}
			
			String[] resultsR = fileInfo[3].split(",");
			boolean[] b = new boolean[4];
			for(int temp1=0;temp1<b.length;temp1++)
			{
				b[temp1]=false;
			}
			for(int temp1=0;temp1<resultsR.length;temp1++)
			{
				if(Integer.parseInt(resultsR[0])==temp+1)
				{
					if(temp!=halfRoomSize)
					{
						b[1]=true;
					}
				}
				if((temp-halfRoomSize)==Integer.parseInt(resultsR[temp1]))
				{
					b[0]=true;
				}
				if(temp-1==Integer.parseInt(resultsR[temp1]))
				{
					b[3]=true;
				}
			}
			
			rooms[temp-halfRoomSize][1] = new Room(p, t, temp, 1, b);
			roomNumber+=5;
		}
		
		//Creates the entrance and exit
		entrance = new Location(0,0);
		String[] resultsE = fileInfo[fileInfo.length-1].split(",");
		rooms[Integer.parseInt(resultsE[0])][1].addThings(goal);
		
		setHuman(new Rick(0,0,100, new ArrayList<Thing>()));
		
		//Proceeds to the GUI creation
		GUI x = new GUI();
		x.switcharoo();
		
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

	public static Room[][] getRooms() 
	{
		return rooms;
	}

	public static void setRooms(Room[][] rooms) 
	{
		World.rooms = rooms;
	}

	public static Player getHuman() 
	{
		return human;
	}

	public static void setHuman(Player human) 
	{
		World.human = human;
	}
	
}