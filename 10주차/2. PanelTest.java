package master;

import javax.swing.*;

class MyFrame extends JFrame{
	public MyFrame(String FrameName) {
		super(FrameName); //부모클래스의 생성자를 호출하여 받아온 프레임으로 이름을 설정한다.
		this.setSize(500,200);
		JPanel p1 = new JPanel(); //패널을 생성한다.
		p1.add(new JLabel("자바 호텔에 오신것을 환영합니다. 숙박 일수를 입력하세요"));
		//생성된 패널에 라벨을 추가한다.
		JPanel p2 = new JPanel(); //패널을 또 생성한다
		//for 문을 사용하여, 1~5일 까지 버튼을 생성하고 p2 에 추가한다.
		for (int i = 1; i <=5; i ++) {
			p2.add(new JButton(i+"일"));
		}
		JPanel p3 = new JPanel(); //패널을 한번 더 생성한다
		p3.add(p1); //생성된 패널에 앞전에 생성한 p1 p2 를 넣어준다.
		p3.add(p2);
		this.add(p3); //p3 를 프레임에 넣어준다
		this.setVisible(true);//화면에 볼 수 있게 true 로 설정해준다.
	}
}

public class PanelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new MyFrame("생성");//어차피 참조변수로 할 작업이 없기에 그냥 객체를 생성한다.
	}

}
