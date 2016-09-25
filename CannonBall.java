package cannonBall;

import apcs.*;

public class CannonBall {
	
	static int x = 25;
	static int y = 950;
	static int dy = -25;
	static int dx = 25;
	
	static int angle = -45;
	
	static int power = 20;

	public static void main(String[] args) {
		Window.size(1000, 1000);
		
		while(true)
		{
			Window.frame();
			
			Window.out.background("orange");
			
			draw();
			move();
			cannon();
			changeCannon();
			fireCannon();
			changePower();
			
		}
	}
	
	public static void draw()
	{
		Window.out.color("black");
		Window.out.circle(x, y, 20);
	}
	
	public static void move()
	{
		
		
//		if (Window.key.pressed("w"))
//		{
//			y -= 10;
//		}
//		if (Window.key.pressed("s"))
//		{
//			y += 10;
//		}
//		if (Window.key.pressed("a"))
//		{
//			x -= 10;
//		}
//		if (Window.key.pressed("d"))
//		{
//			x += 10;
//		}
		if (!(Window.key.pressed("w") || Window.key.pressed("s") || Window.key.pressed("a") || Window.key.pressed("d")))
		{
			x += dx;
			y += dy;
			dy++;
		}
	}
	
	public static void cannon()
	{
		Window.out.color("black");
		Window.out.rectangle(0, 1000, 200, 70, angle);
	}
	
	public static void changeCannon()
	{
		if (Window.key.pressed("q"))
		{
			angle--;
		}
		if (Window.key.pressed("e"))
		{
			angle++;
		}
	}
	
	public static void fireCannon()
	{
		if (Window.key.pressed("space") && (y > Window.height() || x > Window.width()))
		{
			x = 25;
			y = 975;
			dx = (int) (power * Math.cos(Math.toRadians(angle)));
			dy = (int) (power * Math.sin(Math.toRadians(angle)));
			
		}
	}
	
	public static void changePower()
	{
		if (Window.key.pressed("up"))
		{
			power++;
		}
		if (Window.key.pressed("down"))
		{
			power--;
		}
		if (power < 0)
		{
			power = 0;
		}
		if (power > 45)
		{
			power = 45;
		}
			
		Window.out.print("Power: " + power, 100, 100);
	}

}
