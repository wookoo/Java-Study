package master;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

class TempFrame extends JFrame{
	public TempFrame(String Framename) {
		super(Framename); //부모클래스의 생성자를 호출하여 받아온 프레임으로 이름을 설정한다.
		this.setSize(500,200);
		
		this.setLayout(new BorderLayout()); //레이아웃 관리자를 FlowLayout 객체로 설정해준다.
		
		JTextField filed1 = new JTextField();
	
		filed1.setBackground(Color.white);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		JPanel p2 = new JPanel();
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				filed1.setText(" ");
			}
			
		});
		p1.add(clear,"East");
		p1.add(p2,"Center");
		p2.setLayout(new GridLayout(5,3));
		
		
		ArrayList<JButton> Buttons = new ArrayList<JButton>();
		
		
		for(int i =1; i<=9; i++) {
			Buttons.add(new JButton(String.valueOf(i)));
		}
		Buttons.add(new JButton("*"));
		Buttons.add(new JButton("0"));
		Buttons.add(new JButton("#"));
		
		for(JButton b: Buttons) {
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					filed1.setText(filed1.getText()+b.getText());
				}
				
			});
		}
		
		Buttons.add(new JButton("send"));
		Buttons.add(new JButton(" "));
		Buttons.add(new JButton("end"));
		
		for(JButton b: Buttons) {
			p2.add(b);
		}
		
		this.add(filed1,"North");
		this.add(p1,"Center");
		this.setVisible(true); 
	}
}

public class PhoneTyping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TempFrame myFrame = new TempFrame("전화번호부 테스트");

	}

}
