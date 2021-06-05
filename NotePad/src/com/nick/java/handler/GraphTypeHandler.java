package com.nick.java.handler;

import com.nick.java.GraphType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphTypeHandler implements ActionListener
{
	GraphType gt;
	public GraphTypeHandler(GraphType gt)
	{
		this.gt = gt;
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		if (o==gt.b1)
		{
			if (gt.list1.getSelectedItem().equals("Column-Graph")|gt.list1.getSelectedItem().equals("Line-Graph")|gt.list1.getSelectedItem().equals("Pie-Graph"))
			{
				CardLayout c1 = (CardLayout)(gt.g.getLayout());
				c1.show(gt.g,"enter_data");
			}		
		}
		if (o==gt.b2)
		{
			gt.g.setVisible(false);
		}
	}	
}