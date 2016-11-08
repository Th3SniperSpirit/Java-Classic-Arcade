import java.util.*;

public class Stuff
{
	public static void main (String[] args)
	{
		/*System.out.println("fdshff");
		int health = 100;
		System.out.println("Your health is, " + health);
		int addition = health + 20;
		System.out.println("Your health is now, " + addition);
		int division = health / 9001;
		System.out.println("Your health is now, " + division);
		double decimal = health;
		System.out.println("Your health is now, " + decimal);
		String words = "lsgffkg;lksfjglj;lsjkfksdjf;lasj!!!!1111one!!eleven";
		System.out.println(words);
		boolean B00L = true;
		boolean B00L1 = false;
		System.out.println(B00L + "," + B00L1);
		
		
		if(health == 100)
		{
			System.out.println("Yo mama is so fat I took a picture of her last Christmas and it's still printing");
		}		
		
		if(health == 200)
		{
		}
		else if(health > 9000)
		{System.out.println("no u");
		}*/
		int list [] = new int [10];
		list [5] = 10;
		list [4] = 4;
		list [3] = 7;
		System.out.println(list [5]);
		int i = 0;
		while(i < 10)
		{
			list [i] = 9001;
			System.out.println(list [i]);
			i = i + 1;
			}
		for(int jason = 0; jason < 10; jason = jason + 1)
		{System.out.println(list [jason]);
		}
		int array [] = new int [100];
		for(int freddy = 0; freddy < 100; freddy = freddy + 1)
		{
			array [freddy] = freddy;
			System.out.println(array [freddy]);
			}
		
		ArrayList <Double> FistBump = new ArrayList <Double> ();
		FistBump.add(23.0);
		FistBump.add(76.0);
		FistBump.add(55.0);
		FistBump.add(33.0);
		for(int t = 0; t < FistBump.size (); t = t + 1)
		{
		System.out.println(FistBump.get(t));
		}
}	}