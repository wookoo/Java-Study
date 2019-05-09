package master;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

class My extends JFrame{
	public My(String FrameName) {
		super(FrameName); //부모클래스의 생성자를 호출하여 받아온 프레임으로 이름을 설정한다.
		this.setSize(500,200);
		
		this.setLayout(new FlowLayout()); //레이아웃 관리자를 FlowLayout 객체로 설정해준다.
		JLabel label = new JLabel("자바는 재미있나요?"); //라벨 추가를 위한 JLabel 객체 생성
		this.add(label); //생성된 label 인스턴스를 추가해준다.
		JButton b1 = new JButton("YES"); //버튼 추가를 위한 jButton 객체 생성
		JButton b2 = new JButton("NO"); //버튼 추가를 위한 JButoon 객체 생성
		this.add(b1); //생성된 b1 b2 인스턴스를 추가해준다.
		this.add(b2);
		this.setVisible(true); //화면에 볼 수 있게 true 로 설정해준다.
		this.getContentPane().setBackground(Color.green); //메인 프레임에서의 배경을 설정을 해주는 메소드
		ArrayList<JButton> buttons = new ArrayList<JButton>(); //버튼을 배열로 설정한다.
		buttons.add(b1); //버튼 1 2 를 for 문을 사용하여 ActionListener 를 구현하기 위해 ArrayLists 에 삽입한다.
		buttons.add(b2);
		for (int i=0; i<buttons.size();i++) { //버튼이 다른 버튼도 컨트롤 해야 하므로 button 배열의 크기만큼 반복한다
			final int t = i; //@Ovveride 했을때 참조를 못하므로 t 를 final 변수로 선언해준다.
			buttons.get(i).addActionListener(new ActionListener() {
				//buttons 배열의 i 번째 요소의 index 를 가져와서 ActionListenr 를 설정한다.
				@Override
				public void actionPerformed(ActionEvent e) { //버튼을 눌렀을때 작업
					System.out.println(buttons.get(t).getText()); //사용자가 누른 버튼이 무엇인지 출력
					if(buttons.get(t).getBackground()== Color.yellow) {
						//만약에 버튼의 현재 색상이 노란색이면, 하얀색으로 바꾼다.
						buttons.get(t).setBackground(Color.white);
					}
					else {
						//현재 버튼이 노란색이아니면, 노란색으로 바꾼다
						buttons.get(t).setBackground(Color.yellow);
						//Math 클래스의 abs 메소드를 사용하여 다른 버튼의 인덱스 즉, 다른 버튼을 흰색 (YES 면 NO 버튼, NO 면 Yes 버튼)으로 만든다.
						
						buttons.get(Math.abs(t-1)).setBackground(Color.white);
					}
				}
				
			});
		}
		
	}
}


public class isFunJavas {
	public static void main(String[] args) {
		new My("마이프레임"); //어차피 참조변수로 할 작업이 없기에 그냥 객체를 생성한다.
	}

}
