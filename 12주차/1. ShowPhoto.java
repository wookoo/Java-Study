package wookoo;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowPhoto extends JFrame{
	
	public ShowPhoto() {
		super("사진 테스트"); //윈도우 창 
		this.setSize(700,300); //가로 700 세로 300 으로 크기 설정

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1,3));
		
		//이미지를 띄우기 위해서는 ImageIcon 클래스를 할당받아서 이미지를 선택 한 후
		//JLabel 클래스에 생성자로 생성된 ImageIcon 객체를 parameter 로 넘겨준다.
		//그러나 이 생성된 JLabel과 ImageIcon은 다른 작업이 없으므로, 이 두개를 익명 클래스로 사용하여 p1 에 추가한다
		p1.add(new JLabel(new ImageIcon("E:/arduino.jpg"))); //JLabel 과 ImageIcon 을 익명 클래스로 사용하여 p1 에 추가한다.
		p1.add(new JLabel(new ImageIcon("E:/python.jpg"))); //JLabel 과 ImageIcon 을 익명 클래스로 사용하여 p1 에 추가한다.
		p1.add(new JLabel(new ImageIcon("E:/java.jpg")));//JLabel 과 ImageIcon 을 익명 클래스로 사용하여 p1 에 추가한다.
    //위 3개의 ImageIcon 객체의 파라메터는, 이미지의 절대 또는 상대 경로이다.
		
		
		this.add(p1); //생성된 p1 을, JFrame 에 추가한다.
		this.setVisible(true); //그후, 현재 JFrame 을 보여준다.
	}
	
	
	
	public static void main(String[] args){
		new ShowPhoto(); //생성된 객체에 할 작업이 없으므로, 익명 클래스로 생성하여 JFrame 을 보여준다.
	}

}
