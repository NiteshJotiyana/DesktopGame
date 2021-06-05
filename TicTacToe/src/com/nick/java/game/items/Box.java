package com.nick.java.game.items;

import javax.swing.*;
import java.awt.*;

public class Box extends JTextField
{
	int status;
	Font century = new Font("Century",Font.BOLD,50);
	Font kristen = new Font("Kristen ITC",Font.BOLD,50);

	public Box()
	{
		setStatus(0);
		setEditable(false);
		setFont(kristen );
		setBackground(Color.green);
		setForeground(Color.black);
			
	}
	
	public void setStatus(int s)
	{
		status=s;
	}
	public int getStatus()
	{
		return status;
	}
}
