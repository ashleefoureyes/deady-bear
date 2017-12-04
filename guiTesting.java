import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class guiTesting 
{
	public void test()
	{
		//Allows for viewing of dev notes to make finding errors easier
		boolean tracing = true;
		
		//Creats the pane that will control the right hand side of the GUI
		JPanel pane = new JPanel(new GridBagLayout());
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		//Creates the frame that holds the pane as well as the images and 2 extra buttons
		JFrame frame = new JFrame("Deady Bear");
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
		left.setMnemonic(KeyEvent.KEY_LOCATION_LEFT);
		left.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	System.out.println("Left Click");
	        }
	    });
		left.addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				System.out.println("Left Button");
			}
			@Override
			public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {}
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
	        	System.out.println("Right");
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
	        	System.out.println("Up");
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
	        	System.out.println("Down");
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
		
		JLayeredPane layPane = new JLayeredPane();
		layPane.setPreferredSize(new Dimension(396, 382));
		
		ImageIcon title = new ImageIcon(getClass().getResource("/resources/title.png"));
		ImageIcon roomBase = new ImageIcon(getClass().getResource("/resources/room1.png"));
		ImageIcon player = new ImageIcon(getClass().getResource("/resources/player.png"));
		ImageIcon key = new ImageIcon(getClass().getResource("/resources/key.png"));
		
		JLabel titleContainer = new JLabel();
		JLabel roomContainer = new JLabel();
		JLabel playerContainer = new JLabel();
		JLabel keyContainer = new JLabel();
		
		titleContainer.setIcon(title);
		roomContainer.setIcon(roomBase);
		playerContainer.setIcon(player);
		keyContainer.setIcon(key);
		
		//layPane.add(titleContainer, new Integer(1));
		layPane.add(roomContainer, new Integer(1));
		layPane.add(playerContainer, new Integer(2));
		layPane.add(keyContainer, new Integer(2));
		
		titleContainer.setBounds(0, 0, title.getIconWidth(), title.getIconHeight());
		roomContainer.setBounds(0, 0, roomBase.getIconWidth(), roomBase.getIconHeight());
		playerContainer.setBounds(150, 150, player.getIconWidth(), player.getIconHeight());
		keyContainer.setBounds(100, 80, player.getIconWidth(), player.getIconHeight());
		
		frame.add(BorderLayout.WEST, layPane);
		 
	
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
}