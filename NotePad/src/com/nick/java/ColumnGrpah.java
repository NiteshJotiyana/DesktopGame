package com.nick.java;

import java.awt.*;
import java.awt.event.*;

public class ColumnGrpah extends Panel
{
	public double data[];
	public Graph gr;
	public ColumnGrpah(double ob[], Graph obj)
	{
		data =ob;
		gr= obj;
	}
	public void paint(Graphics g)
	{
		int l = data.length;			//get length of DataArray
		//creating color
		
		Color c1 = new Color(0,255,0);
		Color c2 = new Color(255,0,0);
		Color c3 = new Color(0,0,255);
		Color c4 = new Color(255,255,0);
		Color c5 = new Color(128,255,0);
		Color c6 = new Color(0,255,255);
		Color c7 = new Color(202,0,202);
		Color c8 = new Color(255,128,255);
		Color c9 = new Color(0,0,128);
		Color c10 = new Color(192,192,192);
		Color c[] = {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10};
		
		//drawing line graph
		if (gr.gt.list1.getSelectedItem().equals("Line-Graph"))
		{
			//drawing  y axis
			g.drawLine(50,50,50,300);
			
			//drawing item on y axis
			int a =50;
			for (int i=0;i<5;i++ )
			{	
				g.drawString(""+(200-(50*i)),50-25,a+50);
				g.drawLine(50,a+50,50-5,a+50);
				a=a+50;
			}
			g.drawLine(50,300,(l+3)*55,300);		//origin (50,300)
			a = 0;
			for (int i=0;i<l+2;i++ )
			{	
				g.drawString(""+50*i,a+50,300+20);
				g.drawLine(a+50,300,a+50,300+5);
				a=a+50;
			}
			for (int i=0;i<l-1;i++ )
			{	
				g.setColor(c[i]);
				g.drawLine(50*(i+2),300-(int)data[i],50*(i+3),300-(int)data[i+1]);
			}
			for (int i=0;i<l;i++ )
			{
				g.setColor(c4);
				g.drawString(""+data[i],50*(i+2),300-(int)data[i]-20);	
			}
		}
		//drawing column graph
		if (gr.gt.list1.getSelectedItem().equals("Column-Graph"))
		{
			//drawing  y axis
			g.drawLine(50,50,50,300);
			
			//drawing item on y axis
			int a =50;
			for (int i=0;i<5;i++ )
			{	
				g.drawString(""+(200-(50*i)),50-25,a+50);
				g.drawLine(50,a+50,50-5,a+50);
				a=a+50;
			}

			g.drawLine(50,300,(l+1)*110,300);		//origin (50,300)
			a = 0;
			for (int i=0;i<2*l+1;i++ )
			{	
				g.drawString(""+50*i,a+50,300+20);
				g.drawLine(a+50,300,a+50,300+5);
				a=a+50;
			}
			for (int i=0;i<l;i++ )
			{	
				g.setColor(c[i]);

				g.fillRect(100*(i+1),300-(int)data[i],50,(int)data[i]);
				g.setColor(c2);
				g.drawString(""+data[i],100*(i+1)+10,(300-(int)data[i])+(int)data[i]/2);
			}
		}
		//draw pie-graph
		if (gr.gt.list1.getSelectedItem().equals("Pie-Graph"))
		{	int sum=0,a=0;
			for (int i=0;i<l ;i++ )
			{
				sum = (int)data[i]+sum;
			}
			int xpos=450, ypos=200;
			for (int i=0;i<l;i++ )
			{	
				g.setColor(c[i]);
				int angle =(int)((data[i]/sum)*360);
				System.out.println(data[i]+" "+sum +"  "+angle+ ""+a);
				g.fillArc(100,100, 250, 250,a,angle);
				a = angle+a;
				g.fillRect(xpos,ypos,15,10);
				g.setColor(c3);
				g.drawString(""+data[i],xpos+20,ypos+10);
				ypos= ypos+15;
			}


		}

	}
}