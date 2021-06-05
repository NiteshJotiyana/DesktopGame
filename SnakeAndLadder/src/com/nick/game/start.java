package com.nick.game;

import java.awt.*;
import javax.swing.*;

class start extends Panel 
{
	JPanel main;
	theme t;
	cube cb;
	control c;
	gameSheet gs;
	play p;
	//TrayIcon icon;
	snakeLader snake;
	start(Game g)throws Exception
	{	
		UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		setLayout(new CardLayout());
		t = new theme();
		cb = new cube();
		main = new JPanel();
		gs = new gameSheet(t,this);
		c = new control(t,this,g);
		p = new play(this,g);
		snake = new snakeLader(this);
		
		
		add(snake);
		add(main,"main");
		
		//setting main Panel
		main.add(c);
		main.add(gs);
		main.add(cb);
		main.setLayout(null);
		main.setBackground(t.light_green);
		
		//setting location
		gs.setLocation(50,50);
		c.setLocation(875,20);
		cb.setLocation(700,400);
		cb.setVisible(false);
		
		//set Size of Frame
		setSize(1280,770);
	}

}
