import java.awt.FlowLayout;

import javax.swing.*;

class TempFrame extends JFrame{ //JFrame 을 상속받는 클래스 생성
	public TempFrame(String FrameName,int n) {  //생성자로 프레임 이름과 생성할 버튼 갯수를 설정.
		super(FrameName); //프레임의 이름을 설정한다.
		this.setSize(1000,500); //프레임의 크기를 설정한다.
		this.setLayout(null);
		
		for(int i = 1; i <=n; i ++) { //i 는 1부터 받아온 n 까지 반복한다.
			JButton temp = new JButton(String.valueOf(i)); //for 문을 돌면서 바뀌는 i 값을 버튼의 설명(?) 으로 해준다.
			temp.setSize(50,20); //생성된 버튼의 크기를 설정해준다.
			temp.setLocation((int)(Math.random()*900),(int)(Math.random()*400)); //버튼의 위치를 0~900,0~400 으로 설정한다.
			this.add(temp); //생성된 버튼을 추가한다.
		}
		this.setVisible(true); //프레임을 추가한다.
	}
}
public class RandomButton {

	public static void main(String[] args) {
		TempFrame m1 = new TempFrame("우아",30); //우아로 이름을 만들고 버튼을 30개 추가한다.
	}
}
