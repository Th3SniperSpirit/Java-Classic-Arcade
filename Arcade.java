   import java.util.*;
   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import java.awt.geom.*;
	import java.awt.GraphicsDevice;


    public class Arcade extends Applet implements KeyListener, MouseListener, MouseMotionListener, Runnable
   {
		
      double timer;
      Image ship;
      Rectangle2D.Double asteroidsplayer;
      AsteroidGame roid;
      boolean movebackward;
      boolean brotateleft;
      boolean brotateright;
      boolean moveforward;
      int tronscore1;
      int tronscore2;
      Paddle p1;	
      Paddle p2;
		Paddle baddle;
		Brall brall;
		ArrayList <Brick> brick;
      Ball b;
      Rectangle2D.Double shape1; 
      Rectangle2D.Double shape2;
      Ellipse2D.Double ball; 
      int screenwidth;
      int screenheight;
      int page;
      Image backbuffer;
      Graphics2D backg;
      Tron tron;
      double maxspeed;
      Thread t = null;
      boolean threadSuspended;
      int score1;
      int score2;
      boolean p1up;
      boolean p1down;
      boolean p2down;
      boolean p2up;
		boolean baddleup;
		boolean baddledown;
		
       public void init ()
      {	
      
         timer = 0;
         movebackward = false;
         moveforward = false;
         brotateleft = false;
         brotateright = false;
         tronscore1 = 0;
         tronscore2 = 0;
         maxspeed = 4.5;
         screenwidth = getSize().width;
         screenheight = getSize().height;
         roid = new AsteroidGame();
      	
         ship = getImage(getDocumentBase(), "ship.jpg");
      	
      	
         backbuffer = createImage(screenwidth*4,screenheight*4);
         backg = (Graphics2D)backbuffer.getGraphics();
      
         p1 = new Paddle (10,screenheight/2);
         p2 = new Paddle (970,screenheight/2);
         b = new Ball (screenwidth/2,screenheight/2);
         score1 = 0;
         score2 = 0;
         p1up = false;
         p1down = false;
         p2down = false;
         p2up = false;
         addKeyListener(this);
         addMouseListener(this);
         addMouseMotionListener(this);
         setEnabled(true);
         page = 1;
         shape1 = new Rectangle2D.Double(p1.x,p1.y,p1.width,p1.height);
                    
         shape2 = new Rectangle2D.Double(p2.x,p2.y,p2.width,p2.height);
            
         ball = new Ellipse2D.Double(b.bx,b.by,b.bwidth,b.bheight);
         asteroidsplayer = new Rectangle2D.Double(roid.pxcor,roid.pycor,roid.pwidth,roid.pheight);
         tron = new Tron(screenwidth / 4, screenheight/ 2, screenwidth / 4 * 3, screenheight / 2); 
			
			baddle = new Paddle(screenwidth / 2, screenheight);
			brall = new Brall(screenwidth / 2,screenheight / 2);
			brick = new ArrayList <Brick>();        
			baddleup = false;
			baddledown = false; 
			
			
      
      	
      }
       public void resetpong() {
       
         p1 = new Paddle (10,screenheight/2);
         p2 = new Paddle (970,screenheight/2);
         b = new Ball (screenwidth/2,screenheight/2);
         score1 = 0;
         score2 = 0;
         p1up = false;
         p1down = false;
         p2down = false;
         p2up = false;
         addKeyListener(this);
         setEnabled(true);
         screenwidth = getSize().width;
         screenheight = getSize().height;
      
         backbuffer = createImage(screenwidth*4,screenheight*4);
         backg = (Graphics2D)backbuffer.getGraphics();
      }
       public void resettron() {
         tron = new Tron(screenwidth / 4, screenheight/ 2, screenwidth / 4 * 3, screenheight / 2); 
         
         setEnabled(true);
         screenwidth = getSize().width;
         screenheight = getSize().height;
      
         backbuffer = createImage(screenwidth*4,screenheight*4);
         backg = (Graphics2D)backbuffer.getGraphics();
         backg.setColor(Color.black); 	//delete this line and the line below it for a white background
      	backg.fillRect(0,0,1000,700); 	
      }
       public void resetasteroids() {
          
         roid = new AsteroidGame();
         setEnabled(true);
         
      	
         backbuffer = createImage(screenwidth*4,screenheight*4);
         backg = (Graphics2D)backbuffer.getGraphics();
         
      	JOptionPane meh = new  JOptionPane();
          meh.showMessageDialog(null, "Good luck, not even the creators can beat this.");

      }
		
			
      
   	
   
   
   // Executed when the applet is destroyed.
       public void destroy() {
      }
   
   // Executed after the applet is created; and also whenever
   // the browser returns to the page containing the applet.
       public void start() {
         if ( t == null ) {
            t = new Thread( this );
            threadSuspended = false;
            t.start();
         }
         else {
            if ( threadSuspended ) {
               threadSuspended = false;
               synchronized( this ) {
                  notify();
               }
            }
         }
      }
   
   // Executed whenever the browser leaves the page containing the applet.
       public void stop() {
         threadSuspended = true;
      }
   
   // Executed within the thread that this applet created.
       public void run() {
         try {
            while (true) {
            // DO STUFF HERE
               if(page ==2 ){
                  b.bx = b.bx + b.speed * Math.cos(Math.toRadians(b.angle));
                  b.by = b.by + b.speed * Math.sin(Math.toRadians(b.angle));	
                  if(p1up == true)
                  {
                     p1.y = p1.y - p1.speed;
                  }				        
                  if(p1down == true)
                  {
                     p1.y = p1.y + p1.speed;
                  }
               
                  if(p2down == true)
                  {
                     p2.y = p2.y + p2.speed;
                  }
                  if(p2up == true)
                  {
                     p2.y = p2.y - p2.speed;
                  }
               
                  if(b.bx <= 0) 
                  {
                     b.speed = 2;
                     score2++;
                     b.bx = screenwidth/2;
                     b.by = screenheight/2;
                     int direction = (int)(Math.random() * 2);
                     if(direction == 0)
                     {
                        b.angle = Math.random() * 90 + 135;
                     }	
                     else
                     {
                        b.angle = Math.random() * 90 - 45;
                     
                     }
                  }
                  if(b.bx >= 1000) 
                  {
                     b.speed = 2;
                     score1++;
                     b.bx = screenwidth/2;
                     b.by = screenheight/2;
                     int direction = (int)(Math.random() * 2);
                     if(direction == 0)
                     {
                        b.angle = Math.random() * 90 + 135;
                     }	
                     else
                     {
                        b.angle = Math.random() * 90 - 45;
                     
                     }
                  
                  }
               
                  if(b.by <= 0)
                  {
                     b.speed += .1;
                     if(b.angle < 0)
                     {
                        b.angle = b.angle * -1;
                     }
                     
                     else if(b.angle > 0)
                     {
                        b.angle = b.angle - (2 * (b.angle - 180));
                     
                     }
                  
                  } 
                  if(b.by  >= 700 - b.bheight)
                  {
                     b.speed += .1;
                     if(b.angle < 90)
                     {
                        b.angle = b.angle * -1;
                     }
                     else if(b.angle > 90)
                     {
                        b.angle = b.angle + (2 * (180 - b.angle));
                     }
                  } 
                  if(ball.intersects(shape2)){
                     if(b.angle < 0)
                     {
                        b.angle = 180 + (b.angle * -1);
                     }
                     else if(b.angle > 0)
                     {
                        b.angle = b.angle + (90 - b.angle) * 2; 
                     }
                     b.bx = p2.x - b.bwidth - 4;
                     b.speed += .1;
                     b.bx = b.bx + b.speed * Math.cos(Math.toRadians(b.angle));
                     b.by = b.by + b.speed * Math.sin(Math.toRadians(b.angle));	
                  
                  }
                  if(ball.intersects(shape1)){
                     if(b.angle > 180)
                     {
                        b.angle = -1 * (b.angle  - 180);
                     }
                     else if(b.angle < 180)
                     {
                        b.angle = 180 - b.angle  ; 
                     }
                     b.bx = p1.x + p1.width + 4;
                     b.speed += .1;
                     b.bx = b.bx + b.speed * Math.cos(Math.toRadians(b.angle));
                     b.by = b.by + b.speed * Math.sin(Math.toRadians(b.angle));	
                  }
                  if(b.speed > maxspeed)
                  {
                     b.speed = maxspeed;
                  }
               }
               if(page == 3) {
                  tron.movetron();
                  if(tron.win == false) {
                     if(tron.whowon == 1)
                     {
                        tronscore1 = tronscore1 + 1;
                     }
                     if(tron.whowon == 2)
                     {
                        tronscore2 = tronscore2 + 1;
                     }
                  	
                     resettron();
                  }
               }
               if(page == 4){
                  roid.moveplayer();
                  roid.movebullets();
                  roid.moveasteroids();
                  if(moveforward == true) {
                     roid.downspeed();
                  }
                  if(movebackward == true) {
                     roid.upspeed();
                  }
                  if(brotateleft == true) {
                     roid.rotplayer(3);
                  }
                  if(brotateright == true) {
                     roid.rotplayer(1);
                  }
               }
					if(page == 5) {
						brall.brax = brall.brax + brall.brspeed * Math.cos(Math.toRadians(brall.brangle));
                  brall.bray = brall.bray + brall.brspeed * Math.sin(Math.toRadians(brall.brangle));
						if(baddleup == true)
                  {
                     baddle.y = baddle.y - baddle.speed;
                  }				        
                  if(baddledown == true)
                  {
                     baddle.y = baddle.y + baddle.speed;
                  }
						 if(brall.brax <= 0) 
                  {
                    if(brall.brangle > 180)
                     {
                        brall.brangle = -1 * (brall.brangle  - 180);
                     }
                     else if(brall.brangle < 180)
                     {
                        brall.brangle = 180 - brall.brangle  ; 
                     }
                     brall.brax = p1.x + p1.width + 4;
                     brall.brspeed += .1;
                     brall.brax = brall.brax + brall.brspeed * Math.cos(Math.toRadians(brall.brangle));
                     brall.bray = brall.bray + brall.brspeed * Math.sin(Math.toRadians(brall.brangle));	
                  }
                  }
                  if(brall.brax >= 1000) 
                  {
                      if(brall.brangle < 0)
                     {
                        brall.brangle = 180 + (brall.brangle * -1);
                     }
                     else if(brall.brangle > 0)
                     {
                        brall.brangle = brall.brangle + (90 - brall.brangle) * 2; 
                     }
                     brall.brax = p2.x - brall.brwidth - 4;
                     brall.brspeed += .1;
                     brall.brax = brall.brax + brall.brspeed * Math.cos(Math.toRadians(brall.brangle));
                     brall.bray = brall.bray + brall.brspeed * Math.sin(Math.toRadians(brall.brangle));	
                  
                  }
                  
                  
               
                  if(brall.bray <= 0)
                  {
                     brall.brspeed += .1;
                     if(brall.brangle < 0)
                     {
                        brall.brangle = brall.brangle * -1;
                     }
                     
                     else if(brall.brangle > 0)
                     {
                        brall.brangle = brall.brangle - (2 * (brall.brangle - 180));
                     
                     }
                  
                  } 



                  {
                     brall.brspeed += .1;
                     if(brall.brangle < 90)
                     {
                        brall.brangle = brall.brangle * -1;
                     }
                     else if(brall.brangle > 90)
                     {
                        brall.brangle = brall.brangle + (2 * (180 - brall.brangle));
                     }
                  } 
						if(brall.bray  >= 700 - brall.brheight){
						   brall.brspeed = 2;
                     brall.brax = screenwidth/2;
                     brall.bray = screenheight/2;
                     int brdirection = (int)(Math.random() * 2);
                     if(brdirection == 0)
                     {
                        brall.brangle = Math.random() * 180 + 180;
                     }	
                                       


						}	
					
            
            			
            // Now the thread checks to see if it should suspend itself
               if ( threadSuspended ) {
                  synchronized( this ) {
                     while ( threadSuspended ) {
                        wait();
                     }
                  }
               }
               repaint();
               t.sleep( 10 );  // interval given in milliseconds
               timer += timer + .01 ;
            }
         }
             catch (InterruptedException e) { }
         System.out.println("run(): end");
      }
   
       public void keyPressed(KeyEvent e)
      {	
         if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            tronscore1 = 0;
            tronscore2 = 0;
            page = 1;
            
         } 
      
         if(page ==2) {
            if(e.getKeyCode() == 38)
            {
               p2up = true;			
            }
            if(e.getKeyCode() == 40)
            {
               p2down = true;
            }
            if(e.getKeyCode() == 87)
            {
               p1up = true;
            }
            if(e.getKeyCode() == 83)
            {
               p1down = true;
            }
         }
         if(page ==3) {
         
            if(e.getKeyCode() == 38 && tron.direction2 != 3)
            {
               tron.direction2 = 1;			
            }
            if(e.getKeyCode() == 39 && tron.direction2 != 4)
            {
               tron.direction2 = 2;			
            }
            if(e.getKeyCode() == 40 && tron.direction2 != 1)
            {
               tron.direction2 = 3;
            }
            if(e.getKeyCode() == 37 && tron.direction2 != 2)
            {
               tron.direction2 = 4;			
            }
            if(e.getKeyCode() == 87 && tron.direction1 != 3)
            {
               tron.direction1 = 1;
            }//68
            if(e.getKeyCode() == 68 && tron.direction1 != 4) 
            {
               tron.direction1 = 2;
            }
            if(e.getKeyCode() == 83 && tron.direction1 != 1)
            {
               tron.direction1 = 3;
            }
            if(e.getKeyCode() == 65 && tron.direction1 != 2)
            {
               tron.direction1 = 4;
            }
         }
         if(page == 4) {
            if(e.getKeyCode() == 87)
            {
               moveforward = true;
               movebackward = false;
            }//68
            if(e.getKeyCode() == 68) 
            {
               brotateright = true;
               brotateleft = false;
            }
            if(e.getKeyCode() == 83)
            {
               movebackward = true;
               moveforward = false;
            }
            if(e.getKeyCode() == 65)
            {
               brotateright = false;
               brotateleft = true;
            }
            if(e.getKeyCode() == 32) {
               if(timer > 10){
                  roid.firebullets();
                  timer = 0;
               }
            	
            }
         
         }
      	
      
         repaint();
      }
       public void keyReleased(KeyEvent e)
      {
         if(page == 2){
            if(e.getKeyCode() == 87)
            {
               p1up = false;
            }
            if(e.getKeyCode() == 83)
            {
               p1down = false;
            }
            if(e.getKeyCode() == 40)
            {
               p2down = false;
            }
            if(e.getKeyCode() == 38)
            {
               p2up = false;
            }
         }
         if(page == 4){
            if(e.getKeyCode() == 87)
            {
               moveforward = false;
               
            }//68
            if(e.getKeyCode() == 68) 
            {
               brotateright = false;
              
            }
            if(e.getKeyCode() == 83)
            {
               movebackward = false;
            }
            if(e.getKeyCode() == 65)
            {
               
               brotateleft = false;
            }
         
         }
      
         
      }
       public void keyTyped(KeyEvent e)
      {
      }
       public void mouseEntered(MouseEvent e){
      }
       public void mouseExited(MouseEvent e){
      }
       public void mouseClicked(MouseEvent e){
      }
       public void mousePressed(MouseEvent e){
         if(page == 1) {
            if(e.getX() >= 50 && e.getX() <= 500  && e.getY() >= 250 && e.getY() <= 425) {
               page = 2;
               resetpong();
            	
            
            }
            if(e.getX() >= 550 && e.getX() <= 1000  && e.getY() >= 250 && e.getY() <= 425) {
               page = 3;
               resettron();
            	
            
            }
            if(e.getX() >= 50 && e.getX() <= 500  && e.getY() >= 450 && e.getY() <= 625) {
               page = 4;
               resetasteroids();
               
            	
            
            }
         }
         repaint();
          
      }
       public void mouseReleased(MouseEvent e){
         
      }
       public void mouseMoved( MouseEvent e ) {
           
                      	
        
      }	
       public void mouseDragged(MouseEvent e){
                  	
      }
      	
        
      
   
       public void paint(Graphics g)
      {
         update(g);
      }	
   
       public void update (Graphics g)
      {
         AffineTransform trans = new AffineTransform();
         if(page == 1) {
            backg.setColor(Color.white);
            backg.fillRect(0,0,screenwidth,screenheight);
            
            backg.setColor(Color.black);
            Rectangle2D.Double title = new Rectangle2D.Double(50, 50, 900, 175);
            backg.fill(title);
            
            backg.setColor(Color.black);
            Rectangle2D.Double pong = new Rectangle2D.Double(50, 250, 450, 175);  
            backg.fill(pong);
            
            backg.setColor(Color.black);
            Rectangle2D.Double tronbox = new Rectangle2D.Double(550, 250, 450, 175);
            backg.fill(tronbox);
            
            backg.setColor(Color.black);
            Rectangle2D.Double asteroidbox = new Rectangle2D.Double(50, 450, 450, 175);  
            backg.fill(asteroidbox);
				
				backg.setColor(Color.black);
            Rectangle2D.Double brickbreaker = new Rectangle2D.Double(550, 450, 450, 175);  
            backg.fill(brickbreaker);
				
         	
            Font words = new Font("Arial", Font.BOLD, 36);
            backg.setFont(words);
            backg.setColor(Color.white);
            backg.drawString("JAVARCADE", 50, 225);
            backg.setColor(Color.white);
            backg.drawString("PONG", 50, 425);
            backg.setColor(Color.white);
            backg.drawString("TRON", 550, 425);
            backg.drawString("ASTEROIDS",50,625);
				backg.drawString("BRICK BREAKER",550,625);
         }
         else if(page == 2) {
            backg.setColor(Color.black);
            backg.fillRect(0,0,screenwidth,screenheight);
         /*g.setColor(Color.pink);
         g.fillOval(0,0,500,500);
         g.setColor(Color.gray);
         g.drawLine(10,10,100,100);*/
         
            shape1 = new Rectangle2D.Double(p1.x,p1.y,p1.width,p1.height);
            backg.setColor(p1.colour);
            backg.fill(shape1);
         
            shape2 = new Rectangle2D.Double(p2.x,p2.y,p2.width,p2.height);
            backg.setColor(p2.colour);
            backg.fill(shape2);	
         
            ball = new Ellipse2D.Double(b.bx,b.by,b.bwidth,b.bheight);
            backg.setColor(b.colour1);
            backg.fill(ball);
         	backg.setColor(Color.green);
            backg.drawString("Score1:" + score1,screenwidth/2 - 50,screenheight / 75);
            backg.drawString("Score2:" + score2,screenwidth/2 + 50,screenheight / 75);
         	
            backg.setColor(Color.green);
            backg.drawString("Ball coords: " + b.bx + " , " + b.by , 10, 10);
            backg.drawString("Ball angle: " + b.angle, 10, 30);
         	//Take out above 2 lines if you don't want it
         }
         if(page == 3) {
            backg.setColor(Color.red);
            backg.fillRect((int)tron.tx,(int)tron.ty,1,1);
            backg.setColor(Color.blue);
            backg.fillRect((int)tron.tx1,(int)tron.ty1,1,1);
            backg.drawString("Score1:" + tronscore1,screenwidth/2 - 50,screenheight / 75);
            backg.drawString("Score2:" + tronscore2,screenwidth/2 + 50,screenheight / 75);
            
            
            
         }	
         if(page == 4)
         {
          
          
           	
         	
            backg.setColor(Color.black);
            backg.fillRect(0,0,1000,700);
            if(roid.health == 2)
            {
               backg.setColor(Color.green);
               backg.drawString("Your condition: Healthy " , 10, 70);
               backg.setColor(Color.white);
            }
            else if(roid.health == 1)
            {
            	
               backg.setColor(Color.green);
               backg.drawString("Your condition: Fatal " , 10, 70);
               backg.setColor(Color.red);
            }
         	
            
            //backg.fill(roid.player);
         	
            backg.setColor(Color.green);
            backg.drawString("Your coordinates are: " + roid.pxcor + " , " + roid.pycor, 10, 50);
         	
            
         
            backg.setColor(Color.green);
            backg.drawString("Direction: " + roid.pangle , 10, 90);
         	
            backg.setColor(Color.green);
            backg.drawString("Galactic velocity: " + roid.pxvel + " , " + roid.pyvel , 10, 110);			
         	
            trans.translate(0,0);
            trans.setToRotation(Math.toRadians(roid.pangle), roid.pxcor + roid.pwidth / 2, roid.pycor + roid.pheight / 2);
            trans.translate(roid.pxcor,roid.pycor);
            backg.drawImage(ship, trans, this);
         	
            for(int b = 0; b < roid.bullets.size(); b++) {
               backg.fill(roid.bullets.get(b).bullet);
            }
            backg.setColor(Color.white);
            for(int a = 0; a < roid.asteroids.size(); a++) {
               backg.draw(roid.asteroids.get(a).asteroid);
            }
			}
				/*else if(page == 5) {
            backg.setColor(Color.black);
            backg.fillRect(0,0,screenwidth,screenheight);
         g.setColor(Color.pink);
         g.fillOval(0,0,500,500);
         g.setColor(Color.gray);
         g.drawLine(10,10,100,100);       
            baddle = new Rectangle2D.Double(baddle.x,baddle.y,baddle.width,baddle.height);
            backg.setColor(baddle.colour);
            backg.fill(baddle);	
         
            brall = new Ellipse2D.Double(brall.brx,brall.bry,brall.brwidth,brall.brheight);
            backg.setColor(brall.brcolour1);
            backg.fill(brall);
         	backg.setColor(Color.green);
                     	
            backg.setColor(Color.green);
            backg.drawString("Ball coords: " + b.bx + " , " + b.by , 10, 10);
            backg.drawString("Ball angle: " + b.angle, 10, 30);
         	//Take out above 2 lines if you don't want it
         }*/

         
         	
         	
         	
         
      		
      		
         g.drawImage(backbuffer,0,0,this);
         }
      
   }