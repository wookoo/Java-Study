package master;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DragSquare extends JFrame{
	int XPos = 500; //기본 x 좌표 
	int YPos = 300; //기본 y 좌표 설정, MyComponent 라는 inner class 참조를 위해 필드로 선언
	
	private class MyComponent extends JComponent{ //JPanel 이 아닌 JComponent 로 설정해야
		//드래그 시 겹쳐그려지지 않음
		public void paintComponent(Graphics g) {
			//repaint 또는 생성시
			g.setColor(Color.red);
			//색상은 빨간색으로 설정
			
			g.fillRect(XPos-25, YPos-25, 50, 50);//위치에 맞게 사각형을 그림
		}
	}
	
	public DragSquare() {
		this.setSize(1000,600);
		this.add(new MyComponent()); //익명클래스로 MyComponet 할당받아 추가
		
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getX(); //MouseEvent 객체의 e 라는 인스턴스가 가진 getX 메소드 호출하여 X 좌표
				int y = e.getY(); //y 좌표를 구한다
				
				if (XPos -50 < x && x < XPos + 50  && YPos - 50 < y && y < YPos + 50  ) {
					XPos = x; //만약 x 좌표 y 좌표가 범위 내에 있는 경우 XPos YPos 변경
					YPos = y;
				}
				repaint(); //다시 칠하는 메소드 호출
			}

			@Override //사용하지 않은 메소드
			public void mouseMoved(MouseEvent e) {
				
			}
			
		});
		
		this.setVisible(true); //윈도우 창이 보여지게 설정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //윈도우 창이 닫히면 자동으로 꺼지게 설정
		
	}

	public static void main(String[] args) {
		new DragSquare(); //인스턴스를 생성하지 않고 바로 객체 할당

	}

}
