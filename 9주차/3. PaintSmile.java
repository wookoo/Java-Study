import java.awt.*;

import javax.swing.*;

class Smile extends JFrame{//JFrame 을 상속받는 클래스 생성
	
	public Smile(String FrameName) {//생성자로 프레임 이름을 받아온다.
		super(FrameName); //프레임의 이름을 설정한다.
		this.setSize(500,600); //프레임의 크기를 설정한다.
		this.setVisible(true);
	}
	@Override
	public void paint(Graphics g) { //부모 클래스의 paint 메소드를 오버라이딩 한다.
		super.paint(g);
		g.setColor(Color.yellow); //그릴 색상은 노란색으로
		g.fillOval(60, 90, 200, 200); //색칠된 원을 그린다.
		g.setColor(Color.black); //노란색을 다 썼으므로 검정색으로 그린다.
		g.drawArc(100,140,50,50,180,-180); //반원 1
		g.drawArc(190, 140, 50, 50, 180, -180); //반원 2, 눈이 된다.
		g.drawArc(110,170,100,70,180,180); //반원 3, 입이 된다.
		int x[] = {150,170,160}; //다각형을 그릴 x 좌표
		int y[] = {200,200,180}; //다각형을 그릴 y 좌표
		g.drawPolygon(x, y, 3); //설정한 x y 좌표에 점을 그리고 그 점을 이어 다각형을 만든다. 코를 만드는 명령어다.
		g.setColor(Color.gray); //머리카락 색을 정하기 위한 gray
		for(int i =-10; i <= 130; i++) {
			//90~230 x 좌표 만큼 선을 그린다. 선의 높히는 Math.random() 을 호출하여 60~90 까지 설정해준다.
			g.drawLine(100+i, 120, 100+i, 60+(int)(Math.random()*30));
		}
		
		
	}
	
}
public class PaintSmile {

	public static void main(String[] args) {
		Smile s = new Smile("웃는사람");
	}
}
