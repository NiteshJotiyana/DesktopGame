package com.nick.java.handler;

import com.nick.java.Graph;
import com.nick.java.Insert;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertHandler implements ActionListener
{
	Insert i;
	public InsertHandler(Insert i)
	{
		this.i = i;
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if (o==i.m1)
		{
			try
			{

				Graph g = new Graph(i.n);
				g.setVisible(true);
			}
			catch (Exception e)
			{
			}

		}
		if (o==i.m2)
		{
			CardLayout c1 = (CardLayout)(i.n.getLayout());
			c1.show(i.n,"text");
		}
	}
}