package com.nick.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class item extends JPanel implements Runnable 
{
	private int size,n,i;
	Thread thread1;

	
	int x[]={10,10,60,60};
	int y[]={35,85,85,35};
	
	int x1[]={10,35,85,60};
	int y1[]={35,10,10,35};
		
	int x2[]={60,85,85,60};
	int y2[]={35,10,60,85};
	
	int x3[]={35,85,85,35};
	int y3[]={10,10,60,60};
	
	int a[]={10,10,60,60};
	int b[]={35,85,85,35};
	
	int a1[]={10,35,85,60};
	int b1[]={35,10,10,35};
		
	int a2[]={60,85,85,60};
	int b2[]={35,10,60,85};
	
	int a3[]={10,35,85,60};
	int b3[]={35,10,10,35};
	
	
	//Cunstructer
	item()
	{	
		
		n=4;
		size=100;
		thread1 = new Thread(this,"hello");
		thread1.start();
		setSize(size,size);
		
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.yellow);
		g.fillRect(0,0,100,100);
		g.setColor(Color.blue);
		g.fillPolygon(x3,y3,n);
		
		g.setColor(Color.blue);
		g.fillPolygon(x,y,n);
		g.setColor(Color.red);
		g.fillPolygon(x1,y1,n);
		g.setColor(Color.green);
		g.fillPolygon(x2,y2,n);
		
		
		
	}
	public void run()
	{
		for ( i=0;i<5;)
		{	
			try
			{
				thread1.sleep(500);
				if(i>=0)
				{	
					y[0]=y[0]+10;
					x[1]=x[1]+5;
					y[1]=y[1]-5;
					x[2]=x[2]+5;
					y[2]=y[2]-5;
					y[3]=y[3]+10;
					
					x1[1]=x1[1]-5;
					x1[2]=x1[2]-5;
					y1[1]=y1[1]+5;
					y1[2]=y1[2]+5;

					y1[0]=y1[0]+10;
					y1[3]=y1[3]+10;
					
					y2[0]=y2[0]+10;
					x2[1]=x2[1]-5;
					y2[1]=y2[1]+5;

					y2[2]=y2[2]-10;
					
					x2[3]=x2[3]+5;
					y2[3]=y2[3]-5;
				
					x3[0]=x3[0]-5;
					y3[0]=y3[0]+5;

					x3[1]=x3[1]-5;
					y3[1]=y3[1]+5;

					y3[2]=y3[2]-10;
					y3[3]=y3[3]-10;

				}
				i++;
				
				repaint();
				
			}
			catch (InterruptedException e1)
			{
				System.out.println("child thread interrupted");	
			}
		}
	}
		
}
					