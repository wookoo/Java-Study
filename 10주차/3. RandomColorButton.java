package master;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

class Temp extends JFrame{
	public Temp(String FrameName) {
		super(FrameName); //부모클래스의 생성자를 호출하여 받아온 프레임으로 이름을 설정한다.
		this.setSize(500,200);

		this.setLayout(new GridLayout(4,5));
		ArrayList<JButton> temp = new ArrayList<JButton>();
		for (int i =0; i< 20; i++) {
			temp.add(new JButton(String.valueOf(i)));
			JButton tempButton = temp.get(i);
			this.add(tempButton);
			int R = (int)(Math.random()*256);
			int G = (int)(Math.random()*256);
			int B = (int)(Math.random()*256);
			Color color = new Color(R,G,B);
			tempButton.setBackground(color);
			tempButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int R = (int)(Math.random()*256);
					int G = (int)(Math.random()*256);
					int B = (int)(Math.random()*256);
					Color color = new Color(R,G,B);
					tempButton.setBackground(color);
					System.out.println("누른 버튼 : " + tempButton.getText());
					
				}
				
			});
		}
		this.setVisible(true); 
	}
}


public class RandomColorButton {
	public static void main(String[] args) {
		Temp t = new Temp("버튼 테스트");
	}
}
