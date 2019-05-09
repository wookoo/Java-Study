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
		ArrayList<JButton> temp = new ArrayList<JButton>(); //버튼들을 담을 ArrayList 생성
		for (int i =0; i< 20; i++) { //버튼을 0~19 까지 생성하기 위해 for 문으로 돌린다
			temp.add(new JButton(String.valueOf(i)));  //temp 배열에 JButton 객체를 생성한다. 
			//생성자의 인자로는 for 문 i 를 String 으로  변환한것.
			JButton tempButton = temp.get(i); //방금 넣은 버튼을 가져온다.
			this.add(tempButton); //temp 클래스에 방금 넣은 버튼을 추가한다
			int R = (int)(Math.random()*256); //RGB 를 랜덤을 돌려서 0~255 의 숫자를 생성한다.
			int G = (int)(Math.random()*256);
			int B = (int)(Math.random()*256);
			Color color = new Color(R,G,B); //생성된 RGB 를 가지고 color 객체를 만들고
			tempButton.setBackground(color); //생성한 버튼에 생성한 color 로 색상을 설정한다.
			tempButton.addActionListener(new ActionListener() {
				//생성한 버튼에 ActionListener 를 추가해준다. 람다식을 활용
				

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					//버튼이 눌리면 할 일 지정
					int R = (int)(Math.random()*256);//RGB 를 랜덤을 돌려서 0~255 의 숫자를 생성한다.
					int G = (int)(Math.random()*256);
					int B = (int)(Math.random()*256);
					Color color = new Color(R,G,B);
					tempButton.setBackground(color); //버튼에 대한 색상을 재설정
					System.out.println("누른 버튼 : " + tempButton.getText()); //무슨 버튼을 눌렀는지 콘솔에 출력한다.
					//버튼이 눌리면 할 일 지정 끝
					
				}
				
			});
		}
		this.setVisible(true); 
	}
}


public class RandomColorButton {
	public static void main(String[] args) {
		Temp t = new Temp("버튼 테스트"); //버튼 테스트 라는 이름을 가진 프레임 생성
	}
}
