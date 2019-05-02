import java.awt.*;

import javax.swing.*;

class Smile extends JFrame{
	
	public Smile(String FrameName) {
		super(FrameName);
		this.setSize(500,600);
		this.setVisible(true);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.yellow);
		g.fillOval(60, 90, 200, 200);
		g.setColor(Color.black);
		g.drawArc(100,140,50,50,180,-180);
		g.drawArc(190, 140, 50, 50, 180, -180);
		g.drawArc(110,170,100,70,180,180);
		int x[] = {150,170,160};
		int y[] = {200,200,180};
		g.drawPolygon(x, y, 3);
		g.setColor(Color.gray);
		for(int i =-10; i <= 130; i++) {
			//g.drawLine(100+i, 0, 100+i, 120);
			g.drawLine(100+i, 120, 100+i, 60+(int)(Math.random()*30));
		}
		
		
	}
	
}
public class PaintSmile {

	public static void main(String[] args) {
		Smile s = new Smile("Hungry");
	}
}
