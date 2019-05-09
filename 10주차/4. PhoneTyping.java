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
		
		this.setLayout(new BorderLayout()); //레이아웃 관리자를 BorderLayout 객체로 설정해준다.
		
		JTextField filed1 = new JTextField(); //버튼을 눌렀을때 그러니까 0~9 버튼을 눌렀을때 출력되는 JTextField 생성
	

		
		JPanel p1 = new JPanel(); //중간크기의 패널 생성
		p1.setLayout(new BorderLayout()); //중간크기의 패널은 borderLayout 을 배치 관리자로 가진다.
		JPanel p2 = new JPanel(); //숫자 버튼을 담는 JPanel  생성
		p2.setLayout(new GridLayout(5,3)); //숫자 버튼을 담는 패널은 GridLayout 을 배치 관리자로 가진다.
		
		JButton clear = new JButton("Clear"); //clear 버튼 생성
		
		clear.addActionListener(new ActionListener() { //clear 버튼에 대한 리스너 생성

			@Override
			//clear 버튼을 누르면 하는 일
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				
				//clear 버튼을 누르면 filed1 의 글자를 지워야하기 때문에 setText 메소드를 사용
				filed1.setText(" ");
			}
			
		});
		
		p1.add(clear,"East"); //중간크기의 페널에 clear 버튼을 EAST 옵션으로 오른쪽에 추가하고 
		p1.add(p2,"Center"); //숫자 버튼을 담는 패널에 Center 옵션을 줘서 clear 버튼 옆에 생성한다.
		
		
		ArrayList<JButton> Buttons = new ArrayList<JButton>();
		//버튼을 담을 배열 생성
		
		
		//1~9 까지 버튼을 for 문으로 생성해서 Buttons 배열에 넣고
		for(int i =1; i<=9; i++) {
			Buttons.add(new JButton(String.valueOf(i)));
		}
		Buttons.add(new JButton("*")); //* 0 # 은 하드코딩으로 Buttons 배열에 넣어준다.
		Buttons.add(new JButton("0"));
		Buttons.add(new JButton("#"));
		
		for(JButton b: Buttons) { //1~9 * 0 #이 버튼 배열에 들어가있고, 하는일이 다 같기에 for 문으로 설정
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					filed1.setText(filed1.getText()+b.getText()); //filed1 의 글자는 현재글자 + 버튼의 글자이므로
					//setText 와 getText 메소드를 적절히 활용하여 설정
				}
				
			});
		}
		
		Buttons.add(new JButton("send")); //send " " end 버튼은 아무일도 하지 않으므로 그냥 Buttons 배열에 추가
		Buttons.add(new JButton(" "));
		Buttons.add(new JButton("end"));
		
		for(JButton b: Buttons) { //Buttons 배열엔 모든 버튼(1~9 0 * #.. 등이 들어있으므로 for 문을 돌린다
			p2.add(b); //p2 패널에 for 문이 돌면서 버튼이 추가된다
		}
		
		this.add(filed1,"North"); //filed 1은 North 옵션으로 주고
		this.add(p1,"Center"); //가장 큰 패널인 p1 은 Center 옵션으로 준다.
		this.setVisible(true); 
	}
}

public class PhoneTyping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TempFrame myFrame = new TempFrame("전화번호부 테스트");

	}

}
