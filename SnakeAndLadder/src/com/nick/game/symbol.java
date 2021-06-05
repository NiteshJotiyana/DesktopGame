package com.nick.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class symbol extends JLabel 
{
	Icon i;
	symbol(Icon i)
	{
		super(i);
		this.i=i;
		int x=i.getIconWidth();
		int y=i.getIconHeight();
		
		setSize(x,y);
	}
	public void setImage(Icon image)throws Exception
	{
		int x =image.getIconWidth();
		int y =image.getIconHeight();
		if (x<5|x>40|y<0|y>40)
		{
			Exception ae = new Exception("You have passed wrong size Image");
		}
		setIcon(image);
	}
	public Icon getImage()
	{
		return(i);
	}
}
