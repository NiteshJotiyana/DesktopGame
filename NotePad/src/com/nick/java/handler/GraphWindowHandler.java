package com.nick.java.handler;

import com.nick.java.Graph;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphWindowHandler extends WindowAdapter
{
	Graph g;
	public GraphWindowHandler(Graph f)
	{
		g = f;
	}
	public void windowClosing(WindowEvent we)
	{
		g.setVisible(false);
	}
}