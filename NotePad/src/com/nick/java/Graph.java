package com.nick.java;

import com.nick.java.handler.GraphWindowHandler;

import java.awt.*;

public class Graph extends Dialog
{
	public NotePad n;
	public EnterData ed;
	public GraphType gt;

	public Graph(NotePad ob)
	{
		super(ob,true);
		
		setTitle("Graph");
		n=ob;
		//make instance
		setLayout(new CardLayout());
		gt = new GraphType(this);
		ed = new EnterData(this);
		
		//adding card on dialog
		add(gt,"graph_type");
		add(ed,"enter_data");
		
		//set dialog properities
		this.setResizable(false);
		setSize(350,300);
		GraphWindowHandler h = new GraphWindowHandler(this);
		addWindowListener(h);
	}
}
