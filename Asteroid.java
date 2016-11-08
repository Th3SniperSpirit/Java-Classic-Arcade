   import java.util.*;
   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import java.awt.geom.*;

    public class Asteroid{
      int size;
      double xvel;
      double yvel;
      double xcor;
      double ycor;
      double width;
      double height;
		double angle;
   
      Ellipse2D.Double asteroid;
       public Asteroid(double xcor, double ycor, int size){
         this.xcor = xcor;
         this.ycor = ycor;
			angle = Math.random()* 360;
			
         this.xvel = 2 * Math.sin(Math.toRadians(angle));
         this.yvel = 2 * Math.cos(Math.toRadians(angle));        
			this.size = size;
         if(size == 1) {
            width = 10;
            height = 10;
         }
         if(size == 2) {
            width = 30;
            height = 30;
         }
         if(size == 3) {
            width = 50;
            height = 50;
         }
      	 
         asteroid = new Ellipse2D.Double(xcor, ycor, width, height);
      
      
      }
   }
