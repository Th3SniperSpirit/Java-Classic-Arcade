import java.awt.*;
import java.util.*;
public class Tron{
	double speed;
	int direction;
	int angle;
	Color troncolor1;
	Color troncolor2;
	double tx;
	double ty;
	double theight;
	double twidth;
	public Tron(double txcor, double tycor)
	{
		tx = txcor;
		ty = tycor;
		theight = 25;
		twidth = 25;
		speed = 3;
		troncolor1 = Color.red;
		troncolor2 = Color.blue;
		
		if(direction == 1)
		{
			angle = 0;
		}	
		else if(direction == 2)
		{
			angle = 90;
		}
		else if(direction == 3)
		{
			angle = 180;
		}
		else if(direction == 4)
		{
			angle = 270;
		
		}
	
	}  
}

