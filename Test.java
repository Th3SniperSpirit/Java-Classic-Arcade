public class Test
{
	public static void main (String[]args)
	{
		Ball ball = new Ball (7.1,6.5);
		System.out.println(ball.speed);
		
		Paddle p4ddl3 = new Paddle (10.2,11.5);
		System.out.println(p4ddl3.height);
		
		p4ddl3.x = 100;
		System.out.println(p4ddl3.x);
		
		p4ddl3.printpaddle ();
		
		System.out.println(p4ddl3.getx());
		
		p4ddl3.setx (10);
		System.out.println(p4ddl3.getx());
	}
}		