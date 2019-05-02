import java.awt.FlowLayout;

import javax.swing.*;

class TempFrame extends JFrame{
	public TempFrame(String FrameName,int n) {
		super(FrameName);
		this.setSize(1000,500);
		this.setLayout(null);
		
		for(int i = 1; i <=n; i ++) {
			JButton temp = new JButton(String.valueOf(i));
			temp.setSize(50,20);
			temp.setLocation((int)(Math.random()*900),(int)(Math.random()*400));
			this.add(temp);
		}
		this.setVisible(true);
	}
}
public class RandomButton {

	public static void main(String[] args) {
		TempFrame m1 = new TempFrame("우아",30);
	}
}
