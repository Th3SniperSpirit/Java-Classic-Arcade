   import java.util.*;
   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import java.awt.geom.*;


public class Paddle
{
	double height; 
	double width;
	double x;
	double y;
	double speed;
	Color colour;
	
	public Paddle(double xcor, double ycor)
	{
		height = 100;
		width = 15;
		x = xcor;
		y = ycor;
		speed = 2;
		colour = Color.white;
	}  
	
	public void printpaddle ()
	{
		System.out.println(height);
		
	}
	public double getx ()
	{
		return x;
	}
	public void setx (double xcor) 
	{
		x = xcor;
	}	
}
	