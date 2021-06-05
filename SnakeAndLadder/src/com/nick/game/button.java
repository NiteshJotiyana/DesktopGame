package com.nick.game;/*
This is a special type Button.

Counstructer :

	1)	com.nick.game.button(String title)
		this make instance of com.nick.game.button with given title

Methods :


	1)	public void setColor(Color borderColor,Color backColor,Color fontColor)
			This is used to set BorderColor,BackGroundColor,FontColor;

	2)	public void setFont(Font font)
			This is used to setFont of Title;
		
	3)	public void setTitle(String title)
			this is used to set Title of Button;

	4)	public void setArea(int width,int height)
			this is used to set Size of Button;

	5)	public void setBackColor(Color backColor)
			this is used to set BackgroundColor;

	6)	public String getTitle()
			this is used to get com.nick.game.button Title;
	
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class button extends JLabel implements MouseListener 
{
	private String title;
	private int width,height;
	private Color borderColor,backColor,fontColor;
	private Font font;
	
	private final Font century = new Font("Century",Font.BOLD,15);
	private final Color blue = new Color(0,0,255);
	private final Color red = new Color(255,0,0);
	private final Color yellow = new Color(255,255,0);
	private final Color pink = new Color(255,0,255);
	private final Color light_red = new Color(187,0,0);
	
	button(String title)
	{
		super(title);
		this.title=title;
		width=124;
		height=44;
		backColor=red;
		borderColor=blue;
		fontColor=yellow;
		font=century;

		setSize(width,height);
		addMouseListener(this);
	}
	//paint method
	public void paint(Graphics g)
	{
		button1(g);
	}
	public void mouseClicked(MouseEvent me)
	{	
	}
	public void mouseEntered(MouseEvent me)
	{
		setSize(124,64);
		setArea(124,64);
		setBackColor(light_red);
	}
	public void mouseExited(MouseEvent me)
	{
		setSize(124,44);
		setArea(124,44);
		setBackColor(red);
	}
	public void mousePressed(MouseEvent me)
	{
		setBackColor(pink);
	}
	public void mouseReleased(MouseEvent me)
	{
		setBackColor(light_red);
	}
	
	//Methods
	//Button1
	private void button1(Graphics g)
	{
		g.setColor(borderColor);
		g.fillOval(0,0,width,height);
		g.setColor(backColor);
		g.fillOval(2,2,width-4,height-4);
		g.setColor(fontColor);
		g.setFont(font);
		g.drawString(title,20,25);
	}
	public void setColor(Color borderColor,Color backColor,Color fontColor)
	{
		this.borderColor = borderColor;
		this.backColor = backColor;
		this.fontColor = fontColor;
		repaint();
	}
	public void setBackColor(Color backColor)
	{
		this.backColor = backColor;
		repaint();
	}
	public void setFont(Font font)
	{
		this.font = font;
		repaint();
	}
	public void setArea(int width,int height)
	{
		this.width=width;
		this.height=height;
		repaint();
	}
	public void setTitle(String title)
	{
		this.title=title;
		repaint();
	}
	public String getTitle()
	{
		return(title);
	}
}
