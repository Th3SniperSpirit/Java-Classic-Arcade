  import java.util.*;
   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import java.awt.geom.*;


public class Brall{

	double brspeed;
	Color brcolour1;
	double brangle;
	double brax;
	double bray;
	double brheight;
	double brwidth;
	Ellipse2D.Double brall;
	public Brall(double braxcor, double braycor)
	{
		
		brax = braxcor;
		bray = braycor;
		brheight = 25;
		brwidth = 25;
		brspeed = 2;
		brall = new Ellipse2D.Double(brax,bray,brwidth,brheight);
		brcolour1 = Color.white ; //Change to black to play only using the coords		
		int brdirection = (int)(Math.random() * 2);
		if(brdirection == 0)
		{
			brangle = Math.random() * 180 + 180;
		}	
			
	}  
}