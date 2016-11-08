   import java.util.*;
   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import java.awt.geom.*;
    public class Brick{
      double brxcor;
      double brycor;
      double brwidth;
      double brheight;
      int brhealth;
   
      Rectangle2D.Double Brick;
       public Brick(double brx, double bry){
         brxcor = brx;
         brycor = bry;
         brwidth = 100;
         brheight = 25;
         brhealth = 3;
         Brick = new Rectangle2D.Double(brxcor,brycor,brwidth,brheight);
      }
   
   }
			
