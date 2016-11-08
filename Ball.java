   import java.util.*;
   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import java.awt.geom.*;


public class Ball{

	double speed;
	Color colour1;
	double angle;
	double bx;
	double by;
	double bheight;
	double bwidth;
	public Ball(double bxcor, double bycor)
	{
		bx = bxcor;
		by = bycor;
		bheight = 25;
		bwidth = 25;
		speed = 2;
		colour1 = Color.white ; //Change to black to play only using the coords		
		int direction = (int)(Math.random() * 2);
		if(direction == 0)
		{
			angle = Math.random() * 90 + 135;
		}	
		else
		{
			angle = Math.random() * 90 - 45;
		
		}
	
	}  
}
