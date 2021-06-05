package com.nick.java;

import com.nick.java.handler.GraphTypeHandler;

import java.awt.*;

public class GraphType extends Panel
{
	public List list1;
	public Button b1,b2;
	public Panel p;
	public Label l1,l2;
	public Graph g;

	public GraphType(Graph ob)
	{	
		g =ob;
		//make instance of components
		b1 = new Button("Next");
		b2 = new Button("Cancel");
		
		l1 = new Label("Graph-Type");
		l2 = new Label("Graph-Sample");
		list1 = new List();
		p = new Panel();
		p.setBackground(Color.white);

		//add item in list &set properties of list
		String s[] = {"Column-Graph","Pie-Graph","Line-Graph"};
		for (int i=0;i<s.length;i++ )
		{
			list1.add(s[i]);
		}
		list1.select(0);
		list1.setMultipleMode(false);

		//set size & postion of components 
		setLayout(null);
		l1.setBounds(10,10,120,20);
		l2.setBounds(140,10,180,20);
		list1.setBounds(10,30,120,200);
		p.setBounds(140,30,180,200);
		b1.setBounds(210,240,50,20);
		b2.setBounds(270,240,50,20);
		b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		//adding components on panel
		add(list1);
		add(b1);
		add(b2);
		add(p);
		add(l1);
		add(l2);
		
		//adding listener
		GraphTypeHandler h = new GraphTypeHandler(this);
		b1.addActionListener(h);
		b2.addActionListener(h);
	}
}
