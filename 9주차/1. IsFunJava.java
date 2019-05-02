import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame extends JFrame{
	public MyFrame(String FrameName) { //스트링으로 프레임 네임을 가져온다.
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

		
	}
}

public class IsFunJava {

	public static void main(String[] args) {
		MyFrame m1 = new MyFrame("배고파");
	}
}
