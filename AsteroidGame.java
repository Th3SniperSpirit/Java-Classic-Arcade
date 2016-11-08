   import java.util.*;
   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import java.awt.geom.*;


    public class AsteroidGame {
      ArrayList <Asteroid> asteroids;
      ArrayList <Bullets> bullets;
      double pxvel;
      double pyvel;
      double pxcor;
      double pycor;
      double pwidth;
      double pheight; 
      double pangle;
      double maxspeed;
      int health;
      Rectangle2D.Double player;
   	
       public AsteroidGame()  {	
         bullets = new ArrayList <Bullets>();
         asteroids = new ArrayList <Asteroid> ();
         pxcor = 500;
         pycor = 350;
         pheight = 20;
         pwidth = 20;
         pangle = 0;
         maxspeed = 4.5;
         health = 2;
         player = new Rectangle2D.Double(pxcor, pycor, pheight, pwidth);
         for(int a = 0; a < 11; a++){
            newasteroid();
         }
      }
       public void moveasteroids() {
         for(int a = 0; a < asteroids.size(); a++){
            asteroids.get(a).xcor += asteroids.get(a).xvel;
            asteroids.get(a).ycor += asteroids.get(a).yvel;
         	
            if(asteroids.get(a).xcor <= 0){
               asteroids.get(a).xcor = 999;
            }
            if(asteroids.get(a).xcor >= 1000){
               asteroids.get(a).xcor = 1;
            }
            if(asteroids.get(a).ycor <= 0){
               asteroids.get(a).ycor = 699;
            }
            if(asteroids.get(a).ycor >= 700){
               asteroids.get(a).ycor = 1;
            }
            asteroids.get(a).asteroid = new Ellipse2D.Double(asteroids.get(a).xcor,asteroids.get(a).ycor, asteroids.get(a).width, asteroids.get(a).height);

				if(asteroids.get(a).asteroid.intersects(player))
				{
					health = health - 1;
					asteroids.get(a).angle = asteroids.get(a).angle * -1;
					pxcor = 500;
					pycor = 350;
				}
				
            if(health == 0)
         	{
         		bullets = new ArrayList <Bullets>();
         		asteroids = new ArrayList <Asteroid> ();
         		pxcor = 500;
         		pycor = 350;
        			pheight = 20;
         		pwidth = 20;
         		pangle = 0;
         		health = 2;
         		maxspeed = 4.5;
         		pxvel = 0;
      			pyvel = 0;
         		player = new Rectangle2D.Double(pxcor, pycor, pheight, pwidth);
         		for(int axb = 0; axb < 11; axb++){
            	newasteroid();
         
        		}
      	}
      	            
			}
     }

       
       public void movebullets() {
         for(int b = 0; b < bullets.size(); b++){
            bullets.get(b).bxcor += bullets.get(b).bxvel;
            bullets.get(b).bycor += bullets.get(b).byvel;
            bullets.get(b).bullet = new Rectangle2D.Double(bullets.get(b).bxcor,bullets.get(b).bycor,bullets.get(b).bwidth,bullets.get(b).bheight);
            
         	boolean shouldremove;
         	shouldremove = false;
            for(int a = 0; a < asteroids.size(); a++) {
            	boolean asteremove;
            	asteremove = false;
               if(asteroids.get(a).asteroid.intersects(bullets.get(b).bullet)){
                  if(asteroids.get(a).size == 1){
                     asteroids.remove(a);
                     asteremove = true;
                     
                  }
                  else if(asteroids.get(a).size == 2){
                     Asteroid a1 = new Asteroid(asteroids.get(a).xcor,asteroids.get(a).ycor,1);
                     Asteroid a2 = new Asteroid(asteroids.get(a).xcor,asteroids.get(a).ycor,1);		
                     asteroids.remove(a);
                     asteremove = true;
                     asteroids.add(a1);
                     asteroids.add(a2);
                  
                  }
                  else if(asteroids.get(a).size == 3){
                     Asteroid a1 = new Asteroid(asteroids.get(a).xcor,asteroids.get(a).ycor,2);
                     Asteroid a2 = new Asteroid(asteroids.get(a).xcor,asteroids.get(a).ycor,2);		
                     asteroids.remove(a);
                     asteremove = true;
                     asteroids.add(a1);
                     asteroids.add(a2);
                  
                  }
                  if(asteremove = true){
               	a = asteroids.size();
               	shouldremove = true;
               	
               	}
               	
               }
               
               
            }
            
            if(bullets.get(b).bxcor <= 0 || bullets.get(b).bxcor >= 1000 || bullets.get(b).bycor <= 0 || bullets.get(b).bycor >= 700 || shouldremove == true){
               bullets.remove(b);
               b--;	
            
            
            }
         }
         
         
      					
      // (...)____(O.O)___(...) RAWR!!!!!!
      //
      
      
      }
       public void moveplayer()
      {
         pxcor += pxvel;
         pycor += pyvel;
         if(pxcor <= 0){
            pxcor = 999;
         }
         if(pxcor >= 1000){
            pxcor = 1;
         }
         if(pycor <= 0){
            pycor = 699;
         }
         if(pycor >= 700){
            pycor = 1;
         }
         player = new Rectangle2D.Double(pxcor, pycor, pheight, pwidth);
      	
      }
       public void rotplayer(int key){
         if(key == 1){
            pangle += 1;
         }
         if(key == 3){
            pangle -= 1;
         }
      }
       public void upspeed() {
      	
         pxvel  -= .02 * Math.sin(Math.toRadians(pangle));
         pyvel += .02 * Math.cos(Math.toRadians(pangle));
         if(maxspeed < pxvel){
            pxvel = maxspeed;
         } 
         if(-1 * maxspeed > pxvel){
            pxvel = -1 * maxspeed;
         }    
         if(maxspeed < pyvel){
            pyvel = maxspeed;
         } 
         if(-1 * maxspeed > pyvel){
            pyvel = -1 * maxspeed;
         }   
      	
      	
      }
       public void downspeed() {
         pyvel -= .02 * Math.cos(Math.toRadians(pangle));
         pxvel += .02 * Math.sin(Math.toRadians(pangle));
         if(maxspeed < pxvel){
            pxvel = maxspeed;
         } 
         if(-1 * maxspeed > pxvel){
            pxvel = -1 * maxspeed;
         }    
         if(maxspeed < pyvel){
            pyvel = maxspeed;
         } 
         if(-1 * maxspeed > pyvel){
            pyvel = -1 * maxspeed;
         }  
      }
       public void firebullets() {
         Bullets bulletbill = new Bullets(pxcor,pycor,pangle);
         bullets.add(bulletbill);
      	 
      	
      }
   		
       public void newasteroid() 
      {
         double axcor;
         double aycor;
         do{
            axcor = Math.random() * 1000;
            aycor = Math.random() * 700;
         }
         while(Math.sqrt( (axcor - pxcor)*(axcor - pxcor) + (aycor - pycor)*(aycor - pycor))< 75);
         Asteroid newasteroid = new Asteroid(axcor,aycor,3);
         asteroids.add(newasteroid);
      
      }
      	
   	
   }		
		
