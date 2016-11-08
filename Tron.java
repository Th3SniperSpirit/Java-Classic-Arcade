   import java.util.*;
   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import java.awt.geom.*;

    public class Tron{
    int whowon;
      boolean win;
      double speed1;
      double speed2;
      int direction1;
      int direction2;
      int angle1;
      int angle2;
      Color troncolor1;
      Color troncolor2;
      double tx;
      double ty;
      double theight;
      double twidth;
      double tx1;
      double ty1;
      double theight1;
      double twidth1;
      int trongrid[][];
       public Tron(double txcor, double tycor, double txcor1, double tycor1)
      {
      	whowon = 0;
         win = true;
         direction1 = 1;
         direction2 = 1;
         trongrid = new int[700][1000];
         for(int row = 0; row < 700; row = row + 1)
         {
            for(int col = 0; col < 1000; col = col + 1)
            {
               trongrid[row][col] = 1;
            }
         }	
         tx = txcor;
         ty = tycor;
         theight = 25;
         twidth = 25;
         tx1 = txcor1;
         ty1 = tycor1;
         theight1 = 25;
         twidth1 = 25;
         speed1 = 5;
         speed2 = 5;
         troncolor1 = Color.red;
         troncolor2 = Color.blue;
      
       
      
      }
       public void movetron() {
         if(direction1 == 1)
         {
            ty -= 1;
            
         }
         else if(direction1 == 2)
         {
            tx += 1;
         }
         else if(direction1 == 3)
         {
            ty += 1;
         }
         else if(direction1 == 4)
         {
            tx -= 1;
         }
         if(direction2 == 1)
         {
            ty1 -= 1;
         }
         else if(direction2 == 2)
         {
            tx1 += 1;
         }
         else if(direction2 == 3)
         {
            ty1 += 1;
         }
         else if(direction2 == 4)
         {
            tx1 -= 1;
         }
         if(ty < 0){
            ty = 699;
         }
         else if(ty >= 700){
            ty = 1;
         }
         else if(tx < 0) {
            tx = 999;
         }
         else if(tx > 999){
            tx = 1;
         } 
         if(ty1 < 0){
            ty1 = 699;
         }
         else if(ty1 >= 700){
            ty1 = 1;
         }
         else if(tx1 < 0) {
            tx1 = 999;
         }
         else if(tx1 > 999){
            tx1 = 1;
         } 
         if(trongrid[(int) ty][(int) tx] != 1) {
            JOptionPane meh = new  JOptionPane();
            meh.showMessageDialog(null, "Red lost THE GAME");
            win = false;
            whowon = 2;
            
         }
         
         	
         
         else if(trongrid[(int) ty][(int) tx] == 1) {
            trongrid[(int)ty][(int)tx] = 2;
         }
         if(trongrid[(int) ty1][(int) tx1] != 1) {
            JOptionPane meh1 = new  JOptionPane();
            meh1.showMessageDialog(null, "Blue lost THE GAME");
            win = false;
            whowon = 1;
            
         }        
         else if(trongrid[(int)ty1][(int)tx1] == 1) {
            trongrid[(int)ty1][(int)tx1] = 3;
         }
      	
      
      
      
      
      
      
      
      
      
      
      
      
      }
   }
