package master;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RocketFrame extends JFrame{
	
	int XPostion; //이미지의 X 좌표, 익명클래스에서 참조해야 하므로 필드로 선언
	int YPostion; //이미지의 Y 좌표, 익명클래스에서 참조해야 하므로 필드로 선언
	JLabel ImageBox; //이미지를 담는 JLabel, 익명클래스에서 참조해야 하므로 필드로 선언 
	
	
	Timer timer; //스스로 타이머를 종료 해야되므로 필드로 선언
	public RocketFrame() {
		
		super("Animation"); //JFrame 의 생성자를 호출, 프로그램명이 Animation 이 된다.
		this.XPostion = 0; //x 좌표는 0 
		this.YPostion = 200; //Y좌표는 600 으로 초기 값 설정
		this.setSize(1000,300); //프레임의 크기 500*600 설정
		JPanel panel = new JPanel(); //이미지를 저장할 JPanel객체 생성
		panel.setBackground(Color.black); //생성된 객체의 배경은 검정색으로 하고
		panel.setLayout(null); //레이아웃 관리자는 null 로 하여 절대 위치 수정하게 함
		
		ImageIcon Image = new ImageIcon("D:/rocket.png"); //이미지를 불러온다
		ImageBox = new JLabel(Image); //이미지를 담는 JLabel 생성
		ImageBox.setSize(150,150); //배치관리자가 null 이므로 크기 설정을 해줘야됨.
		ImageBox.setLocation(XPostion,YPostion);
		
		panel.add(ImageBox); //패널에 이미지를 추가 해야됨
		this.add(panel); //JFrame 에 패널을 닫는다
		this.setVisible(true); //JFrame 을 보여지게 설정
		
		timer = new Timer(20, new ActionListener() { //타이머 객체 생성, 익명클래스로 타이머 리스너 추가

			@Override
			public void actionPerformed(ActionEvent e) {
				XPostion += 10; //타이머가 작동되는 동안 RocketFrame 의 XPostion 은 10증가
				YPostion -= 3;//타이머가 작동되는 동안 RocketFrame 의 YPostion 은 3감소
				ImageBox.setLocation(XPostion, YPostion);
				if (XPostion > 800) { //프로그램이 켜진상태면 계속 수행되므로 자원낭비다.
					//그렇기 떄문에 x 좌표가 800 이 넘어가면
					System.out.println("타이머 종료");
					timer.stop(); //타이머를 종료한다.
				}
			}
			
		});
		timer.start();  //생성된 타이머 객체 시작
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //윈도우 창이 닫히면 자동으로 꺼지게 설정
		
	}
	
	
	
	
	public static void main(String[] args) {
		new RocketFrame();
	}

}
