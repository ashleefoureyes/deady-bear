import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

//Created by Matthew Kaprielian-Seferian

public class GUI
{
	JFrame mainFrame = new JFrame("Deady Bear");
	JFrame frame = new JFrame("Deady Bear");
	public void test()
	{
		//Allows for viewing of dev notes to make finding errors easier
		boolean tracing = true;
		
		//Creates the pane that will control the right hand side of the GUI
		JPanel pane = new JPanel(new GridBagLayout());
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		//Creates the frame that holds the pane as well as the images and 2 extra buttons
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(800, 500);
		frame.setLocation(520,200);
		
		//Creates the font for the project
		Font font = new Font("Verdana", Font.BOLD, 16);
	
		//Creates the left button
		JButton left = new JButton("Left");
		left.setPreferredSize(new Dimension(60, 60));
		left.setFont(font);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(left, c);
		left.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	if(tracing)System.out.println("Left Click");
	        	Room[][] rooms = World.getRooms();
	        	boolean[] doors = rooms[World.getHuman().getXPosition()][World.getHuman().getYPosition()].getDirections();
	        	
	        	if(doors[3])
	        	{
	        		World.getHuman().setLocation(World.getHuman().getXPosition()-1, World.getHuman().getYPosition());
	        		frame.add(BorderLayout.WEST, rePaint());
	        	}
	        }
	    });		
		
		//Creates the right button
		JButton right = new JButton("Right");
		right.setPreferredSize(new Dimension(60, 60));
		right.setFont(font);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		pane.add(right, c);
		right.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	if(tracing)System.out.println("Right");
	        	Room[][] rooms = World.getRooms();
	        	boolean[] doors = rooms[World.getHuman().getXPosition()][World.getHuman().getYPosition()].getDirections();
	        	
	        	if(doors[1])
	        	{
	        		World.getHuman().setLocation(World.getHuman().getXPosition()+1, World.getHuman().getYPosition());
	        		frame.add(BorderLayout.WEST, rePaint());
	        	}
	        }
	    });
	
		//Creates the up button
		JButton up = new JButton("Up");
		up.setPreferredSize(new Dimension(60, 60));
		up.setFont(font);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		//c.weighty = 1;
		c.gridx = 1;
		c.gridy = 1;
		pane.add(up, c);
		up.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	if(tracing)System.out.println("Up");
	        	Room[][] rooms = World.getRooms();
	        	boolean[] doors = rooms[World.getHuman().getXPosition()][World.getHuman().getYPosition()].getDirections();
	        	
	        	if(doors[0])
	        	{
	        		World.getHuman().setLocation(World.getHuman().getXPosition(), World.getHuman().getYPosition()-1);
	        		frame.add(BorderLayout.WEST, rePaint());
	        	}
	        }
	    });
	
		//Creates the down button
		JButton down = new JButton("Down");
		down.setPreferredSize(new Dimension(60, 60));
		down.setFont(font);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 2;
		pane.add(down, c);
		down.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	if(tracing)System.out.println("Down");
	        	Room[][] rooms = World.getRooms();
	        	boolean[] doors = rooms[World.getHuman().getXPosition()][World.getHuman().getYPosition()].getDirections();
	        	
	        	if(doors[2])
	        	{
	        		World.getHuman().setLocation(World.getHuman().getXPosition(), World.getHuman().getYPosition()+1);
	        		frame.add(BorderLayout.WEST, rePaint());
	        	}
	        }
	    });
		
		//Adds the textarea for the output/inventory
		JTextArea tOutput = new JTextArea(">Output/Inventory", 10, 35);
		tOutput.setFont(font);
		//tOutput.setForeground(Color.GREEN);
		tOutput.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.weighty = 0.5;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(tOutput, c);

		//The image layering on layered panes
		JPanel testPane = new JPanel(new GridBagLayout());
		testPane.setLayout(new GridBagLayout());
		GridBagConstraints t = new GridBagConstraints();
		t.fill = GridBagConstraints.HORIZONTAL;
		t.weightx = 1;
		t.fill = GridBagConstraints.HORIZONTAL;
		t.gridx = 0;
		t.gridy = 0;
		
		
		
		frame.add(BorderLayout.WEST, rePaint());
		 
	
		JPanel bPane = new JPanel(new GridBagLayout());
		bPane.setLayout(new GridBagLayout());
		GridBagConstraints b = new GridBagConstraints();
		b.fill = GridBagConstraints.HORIZONTAL;
		
		//Adds the button for output on the bottom pane
		JButton output = new JButton("Output");
		output.setPreferredSize(new Dimension(30, 30));
		output.setFont(font);
		b.weightx = 1;
		b.weighty = 0.5;
		b.gridwidth = 1;
		b.gridx = 0;
		b.gridy = 0;
		bPane.add(output, b);
		output.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	System.out.println("Output");
	        }
	    });
		
		//Adds the button for Inventory on the bottom pane
		JButton inventory = new JButton("Inventory");
		inventory.setPreferredSize(new Dimension(30, 30));
		inventory.setFont(font);
		b.weightx = 1;
		b.weighty = 0.5;
		b.gridwidth = 1;
		b.gridx = 1;
		b.gridy = 0;
		bPane.add(inventory, b);
		inventory.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	System.out.println("Inventory");
	        }
	    });
	
	    //Adds the panes to the frame
	    frame.getContentPane().add(BorderLayout.EAST, pane);
	    frame.getContentPane().add(BorderLayout.SOUTH, bPane);
	
	    //Shows the GUI
	    frame.pack();
	    frame.setVisible(true);
	}
	
	public void mainScreen()
	{
		//Allows for viewing of dev notes to make finding errors easier
		boolean tracing = true;
				
		//Creates the pane that will control the right hand side of the GUI
		JPanel mainPane = new JPanel(new GridBagLayout());
		mainPane.setLayout(new GridBagLayout());
		GridBagConstraints x = new GridBagConstraints();
		x.fill = GridBagConstraints.HORIZONTAL;
		
		//Creates the frame that holds the pane as well as the images and 2 extra buttons
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 500);
		mainFrame.setLocation(520,200);
		
		//Creates the font for the project
		Font font = new Font("Verdana", Font.BOLD, 16);
		
		//Creates buttons as long as demos exist
		int suffix=0;
		while(new File("src/resources/demo"+Integer.toString(suffix)+".txt").exists())
		{
			if(tracing)System.out.println("Loading Demo"+suffix);
			suffix++;
		}
		
		JButton[] buttons = new JButton[suffix];
		for(int a=0; a<suffix; a++)
		{
			buttons[a]= new JButton("demo"+a);
			buttons[a].setPreferredSize(new Dimension(60, 60));
			buttons[a].setFont(font);
			x.weightx = 0.5;
			x.fill = GridBagConstraints.HORIZONTAL;
			x.gridx = 0;
			x.gridy = a;
			mainPane.add(buttons[a], x);
			buttons[a].addActionListener(new ActionListener() 
		    {
		        @Override
		        public void actionPerformed(ActionEvent e) 
		        {
		        	if(tracing)System.out.println(((JButton)e.getSource()).getText());
		        	try 
		        	{
						World.initialRead(((JButton)e.getSource()).getText());
					} 
		        	catch (IOException e1) 
		        	{
						e1.printStackTrace();
					}
		        }
		    });
		}
		
		//Adds the panes to the frame
		mainFrame.getContentPane().add(BorderLayout.CENTER, mainPane);
	
	    //Shows the GUI
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	public void switcharoo()
	{
		mainFrame.setVisible(false);
		mainFrame.dispose();
		
		test();
	}
	public JLayeredPane rePaint()
	{
		//Creates the layeredPane that will allow me to layer images
		JLayeredPane layPane = new JLayeredPane();
		layPane.setPreferredSize(new Dimension(396, 382));
		
		//Base
		ImageIcon title = new ImageIcon(getClass().getResource("/resources/title.png"));
		ImageIcon roomBase = new ImageIcon(getClass().getResource("/resources/room1.png"));
		ImageIcon player = new ImageIcon(getClass().getResource("/resources/player.png"));
		//Things
		//ImageIcon key = new ImageIcon(getClass().getResource("/resources/key.png"));
		ImageIcon food = new ImageIcon(getClass().getResource("/resources/food.png"));
		ImageIcon poison = new ImageIcon(getClass().getResource("/resources/poison.png"));
		ImageIcon shield = new ImageIcon(getClass().getResource("/resources/shield.png"));
		//NPC's
		ImageIcon lZombie = new ImageIcon(getClass().getResource("/resources/lZombie.png"));
		ImageIcon friendlyNPC = new ImageIcon(getClass().getResource("/resources/friendlyNPC.png"));
		ImageIcon deadlyNPC = new ImageIcon(getClass().getResource("/resources/deadlyNPC.png"));
		
		//Base
		JLabel titleContainer = new JLabel();
		JLabel roomContainer = new JLabel();
		JLabel playerContainer = new JLabel();
		//Things
		//JLabel keyContainer = new JLabel();
		JLabel foodContainer = new JLabel();
		JLabel poisonContainer = new JLabel();
		JLabel shieldContainer = new JLabel();
		//NPC's
		JLabel lZombieContainer = new JLabel();
		JLabel friendlyNPCContainer = new JLabel();
		JLabel deadlyNPCContainer = new JLabel();
		
		//Base
		titleContainer.setIcon(title);
		roomContainer.setIcon(roomBase);
		playerContainer.setIcon(player);
		//Things
		//keyContainer.setIcon(key);
		foodContainer.setIcon(food);
		poisonContainer.setIcon(poison);
		shieldContainer.setIcon(shield);
		//NPC's
		lZombieContainer.setIcon(lZombie);
		friendlyNPCContainer.setIcon(friendlyNPC);
		deadlyNPCContainer.setIcon(deadlyNPC);
		
		Room[][] rooms = World.getRooms();
		
		//Base
		layPane.add(roomContainer, new Integer(1));
		layPane.add(playerContainer, new Integer(2));
		
		//Things
		List<Thing> t = rooms[World.getHuman().getXPosition()][World.getHuman().getYPosition()].getThings();
		Object[] tArray = t.toArray();
		for(int x=0;x<tArray.length;x++)
		{
			if(tArray[x] instanceof Food)
			{
				layPane.add(foodContainer, new Integer(2));
			}
			else if(tArray[x] instanceof Poison)
			{
				layPane.add(poisonContainer, new Integer(2));
			}
			else if(tArray[x] instanceof Shield)
			{
				layPane.add(shieldContainer, new Integer(2));
			}
		}
		//layPane.add(keyContainer, new Integer(2));

		//NPC's
		List<Player> p = rooms[World.getHuman().getXPosition()][World.getHuman().getYPosition()].getPlayers();
		Object[] pArray = p.toArray();
		for(int x=0;x<tArray.length;x++)
		{
			if(pArray[x] instanceof LeftZombie)
			{
				layPane.add(lZombieContainer, new Integer(2));
			}
			else if(pArray[x] instanceof FriendlyNPC)
			{
				layPane.add(friendlyNPCContainer, new Integer(2));
			}
			else if(pArray[x] instanceof DeadlyNPC)
			{
				layPane.add(deadlyNPCContainer, new Integer(2));
			}
		}		
		
		//Base
		titleContainer.setBounds(0, 0, title.getIconWidth(), title.getIconHeight());
		roomContainer.setBounds(0, 0, roomBase.getIconWidth(), roomBase.getIconHeight());
		playerContainer.setBounds(150, 150, player.getIconWidth(), player.getIconHeight());
		//Things
		//keyContainer.setBounds(70, 70, key.getIconWidth(), key.getIconHeight());
		foodContainer.setBounds(110, 70, food.getIconWidth(), food.getIconHeight());
		poisonContainer.setBounds(165, 70, poison.getIconWidth(), poison.getIconHeight());
		shieldContainer.setBounds(230, 70, shield.getIconWidth(), shield.getIconHeight());
		//NPC's
		lZombieContainer.setBounds(70, 250, lZombie.getIconWidth(), lZombie.getIconHeight());
		friendlyNPCContainer.setBounds(150, 250, friendlyNPC.getIconWidth(), friendlyNPC.getIconHeight());
		deadlyNPCContainer.setBounds(230, 250, deadlyNPC.getIconWidth(), deadlyNPC.getIconHeight());
		
		return layPane;
	}
}