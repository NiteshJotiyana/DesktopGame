package com.nick.java.game.runner;

import com.nick.java.game.items.Constants;
import com.nick.java.game.items.Control;
import com.nick.java.game.items.Box;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

/*
	
	<APPLET CODE="start" HEIGHT="500" WIDTH="800"> 	
	
	</APPLET>
*/
public class StartTicTacToe extends Applet implements MouseListener,ActionListener
{
	//creating font of text
	Font century = new Font("Century",Font.BOLD,20);
	Font kristen = new Font("Kristen ITC",Font.BOLD,30);
	//info box 
	JLabel board = new JLabel();
	//creating squares
	private Box s[]=new Box[9];

	//creating current position
	private int user,computer=-1;
	
	//setting the priority of square
	private static final int pri[] ={4,0,2,6,8,1,3,5,7};
	
	//creating wining condition
	private static final int win[][] = {
							{0,1,2},{3,4,5},{6,7,8},
							{0,3,6},{1,4,7},{2,5,8},
							{0,4,8},{2,4,6}
						  };
	private static final int win1[][] = {
							{4,1,3},{4,0,2},{4,1,5},
							{4,0,6},{0,2,6,8,1,3,5,7},{4,2,8},
							{4,3,7},{4,6,8},{4,5,7}
						  };
	private int temp[];
	
	//setting symbol of players
	private static final String s1 ="X";		//for user
	private static final String s2 ="O";		//for computer
	private String st;
	
	//creating number of palyesr
	private int player;
	
	//creating counter
	private int counter;

	//count no of win & draw
	private int cwin,uwin,draw;

	Control con;
	URL baseUrl;
	//intiating the applet.................................
	public void init()
	{	
		con = new Control(this);
		setLayout(null);
		setBackground(Color.black);
		for(int i=0;i<9;i++)
		{
			s[i]= new Box();
			s[i].setSize(100,100);
			add(s[i]);
			if(i%2!=0)
				s[i].setBackground(Color.yellow);
			s[i].addMouseListener(this);
		}
		s[0].setLocation(50,50);
		s[1].setLocation(150,50);
		s[2].setLocation(250,50);
		s[3].setLocation(50,150);
		s[4].setLocation(150,150);
		s[5].setLocation(250,150);
		s[6].setLocation(50,250);
		s[7].setLocation(150,250);
		s[8].setLocation(250,250);
		
		board.setBounds(50,400,300,50);
		board.setForeground(Color.yellow);
		board.setFont(kristen);
		add(board);
		con.setLocation(500,0);
		add(con);
		setPlayer(con.counter2+1);
		//clear();
		this.setSize(1000,500);



		//create URL
		try {
			baseUrl = new URL("file:"+ Constants.resourceFolder+"/audio/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	public void setPlayer(int p)
	{
		player=p;
	}
	//public void method 
	/*
	*	starting private methods..................
	*
	*/
	
	//call when game is finished
	private void finish()
	{
		for(int i=0;i<9;i++)
		{
			s[i].removeMouseListener(this);
		}
	}

	//call when start the game
	public void clear()
	{	
		for(int i=0;i<9;i++)
		{
			s[i].addMouseListener(this);
			s[i].setStatus(0);
			s[i].setText(null);
			board.setText("");
		}
		
		if(counter%2==0&&player==1)
		{	turn();
			counter=0;
		}
		if(counter%2==0&&player==2)
			st=s2;
		counter++;
	}

	//computer normal turn
	private void normalTurn(int sum)
	{
		for(int i=0;i<8;i++)
		{	
			int b1 =s[win[i][0]].getStatus();
			int b2 =s[win[i][1]].getStatus();
			int b3 =s[win[i][2]].getStatus();
		
			if(b1+b2+b3==sum)
			{
				if(b1==0)
					computer=win[i][0];
				else if(b2==0)
					computer=win[i][1];
				else if(b3==0)
					computer=win[i][2];
				break;
			}
		}
	}
	//computer advanced turn
	private void advancedTurn()
	{
		for(int k=0;k<9;k++)
		{
			if(user==k)
			{
				temp=win1[k];
			}
		}

		for(int i=0;i<temp.length;i++)
		{
			if(s[temp[i]].getStatus()==0)
			{
				for(int j=0;j<8;j++)
				{
				int x1=s[win[j][0]].getStatus();
				int x2=s[win[j][1]].getStatus();
				int x3=s[win[j][2]].getStatus();
				
				if(s[win[j][0]]==s[temp[i]]&&((x2==0&&x3==-1)|(x3==0&&x2==-1)))
				{	computer=temp[i];
					break;
				}
				else if(s[win[j][1]]==s[temp[i]]&&((x1==0&&x3==-1)|(x1==-1&&x3==0)))
				{	computer=temp[i];
					break;
				}
				else if(s[win[j][2]]==s[temp[i]]&&((x2==0&&x1==-1)|(x2==-1&&x1==0)))
				{	computer=temp[i];
					break;
				}
			}
		}
		}				
	}
	//computer default turn
	private void defaultTurn()
	{
		for(int i=0;i<9;i++)
		{
			if(s[pri[i]].getStatus()==0)
			{
				computer=pri[i];
				break;
			}
		}
	}
	//calling all computer turns
	private void turn()
	{

		//cheking when computer going to win
		if(computer==-1&&(con.counter1==1||con.counter1==2))
			normalTurn(-2);
		
		//checking when user going to win
		if(computer==-1&&(con.counter1==1||con.counter1==2))
			normalTurn(2);
		
		//checking according to user
		if(computer==-1&&con.counter1==2)
			advancedTurn();
		
		//play default turn
		if(computer==-1)
			defaultTurn();
		
		//finally display the copmuter turn
		if(computer!=-1)
		{
			s[computer].setText(s2);
			s[computer].setStatus(-1);
			computer=-1;
		}
		check();
	}
	
	//check the game
	private void check()
	{
		//checking darw condition
		int c=0;
		for(int k=0;k<9;k++)
		{
			if(s[k].getStatus()!=0)
				c++;
			if(c==9)
			{	board.setText("Game is Draw");
				play(baseUrl,"lader.au");
			}
		}
		
		//checking wining condition
		int x=0;
		for(int i=0;i<8;i++)
		{
			x=0;
			for(int j=0;j<3;j++)
			{	
				x=s[win[i][j]].getStatus()+x;
			}
			if(x==3)
			{
				if(player==1)
				board.setText("User Win");
				else
				board.setText("User1 Win");
				
				finish();
				play(baseUrl,"yahoo2.au");
				break;
			}
			else if(x==-3)
			{	
				if(player==1)
				board.setText("Computer Win");
				else
				board.setText("User2 Win");
				finish();
				play(baseUrl,"yahoo2.au");
				break;
			}	
		}
	}
	
	/*
	*
	*	Starting Listener methods
	*/
	
	public void mouseClicked(MouseEvent me)
	{
		play(baseUrl,"click2.au");
		Object o = me.getSource();
		
		if(player==1)
			st=s1;
		else
		{	
			if(st==s1)
				st=s2;
			else
				st=s1;
		}
		for(int i=0;i<9;i++)
		{
			if(o==s[i]&&s[i].getStatus()==0)
			{	
				if(player==2)
				{
					s[i].setText(st);
					s[i].removeMouseListener(this);
					if(st==s1)
						s[i].setStatus(1);
					else
						s[i].setStatus(-1);
					check();
				}
				else
				{
				user=i;
				s[i].setText(st);
				s[i].removeMouseListener(this);
				s[i].setStatus(1);
				
				check();
				if(board.getText().equals("Computer Win")||board.getText().equals("User Win")) {
					finish();

				}else {

					turn();
				}
				break;
				}
			}	
		}
	}
	public void mouseEntered(MouseEvent me)
	{
	}
	public void mouseExited(MouseEvent me)
	{
	}
	public void mousePressed(MouseEvent me)
	{
	}
	public void mouseReleased(MouseEvent me)
	{
	}
	public void actionPerformed(ActionEvent ae)
	{	
	}
	
}
