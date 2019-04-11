import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

class Vehicle extends JFrame{
	public Vehicle() {
		super();
		setSize(200,120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(50,20,100,50);
	}
}

class Bus extends Vehicle{
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawArc(90+30, 60, 20, 20, 0, 360);
		g.drawArc(30+30, 60, 20, 20, 0, 360);
		g.drawRect(20+30+80,30,20,20);
		g.drawRect(60+30,40,20,30);
		g.drawRect(60+30,40,10,30);
		g.drawString("BUS !", 50+30, 100);
	}
}

class Car extends Vehicle{
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(150, 45, 25, 25);
		g.drawRect(25, 45, 25, 25);
	
		g.drawArc(60, 60, 20, 20, 0, 360);
		g.drawArc(122, 60, 20, 20, 0, 360);
		g.drawString("CAR !", 50+30, 100);
		
	}
}

class Truck extends Vehicle{
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(120+30, 70, 145+30, 70);
		g.drawLine(145+30,70, 145+30, 50);
		g.drawLine(145+30, 50,120+30,40);
		g.drawArc(40+30, 60, 20, 20, 0, 360);
		g.drawArc(122+30, 60, 20, 20, 0, 360);
		g.drawString("Truck !", 50+30, 100);
		g.drawString("Express", 50+30, 50);

		
	}
}


public class FrameTest {

	public static void main(String[] args) {

		Vehicle truck = new Truck();
		Vehicle car = new Car();
		Vehicle Bus = new Bus();
	
		Vehicle[] list = {truck,car,Bus};
		
		
		int y = 50;
		
		for(Vehicle V : list) {
			V.setLocation(50,y);
			y += 150;
		}
		
		
		try {
			boolean Start = true;
			while (Start) {
				Thread.sleep(100);
				for(Vehicle V : list) {
					int Random = (int)(Math.random()*50) + 1;
					V.setLocation(V.getLocation().x + Random, V.getLocation().y);
					if (V.getLocation().x > 1500) {
						Start = false;
						break;
					}
				}
				
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
