   import java.util.*;
   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import java.awt.geom.*;
//  \_(o.O)_/
public class Bullets {
	
	int damage;
	double bxvel;
	double byvel;
	double bxcor;
	double bycor;
	double bwidth;
   double bheight; 
	double bangle;
	Rectangle2D.Double bullet;
	public  Bullets(double bx, double by, double ba) {
	bxvel = 5 * Math.sin(Math.toRadians(ba));
	byvel = -5 * Math.cos(Math.toRadians(ba));
	System.out.println(byvel + "," + bxvel);
	bxcor = bx;
	bycor = by;
	bangle = ba;
	bwidth = 3;
	bheight = 3;
	bullet = new Rectangle2D.Double(bxcor,bycor,bwidth,bheight);
	}
}