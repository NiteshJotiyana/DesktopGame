package com.nick.java.handler;

import com.nick.java.Format;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormatHandler implements ActionListener
{
	Format f;
	public FormatHandler(Format f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		if (o==f.t2)
		{	
			f.n.f.setVisible(true);
		
			
		}
	}
}