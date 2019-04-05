import javax.swing.JFrame;

public class FrameTest2 {
	public static void main(String[] args) {
		JFrame frm1 = new JFrame("프레임 1 번"); //frm1 에 JFrame 값 할당, 생성자가 프레임명이 필요하므로
		//생성할때 생성자에 들어가는 인자를 넣어준다.
		int x1,y1,x2,y2; //창을 움직이는데 필요한 x1 y1 x2 y2 변수 선언
		x1 = 30;//기본값 선언부
		y1 = 20;
		x2 = 30;
		y2 = 280;
		
		frm1.setSize(300,200); //frm1 객체의 크기를 정해주고
		frm1.setLocation(x1,y1); //위치 또한 정해준다
		frm1.setVisible(true); //그 후 보여지게 설정한다.
		
		JFrame frm2 = new JFrame("프레임 2번");//frm2 에 JFrame 값 할당, 생성자가 프레임명이 필요하므로
		//생성할때 생성자에 들어가는 인자를 넣어준다.
		
		frm2.setSize(300,200); //frm1 과 다르므로 setSize 메소드를 통해 크기 설정
		frm2.setLocation(x2, y2); //위치도 설정해준다.
		frm2.setVisible(true); //보여지게 설정한다
		
		try { //thread 가 sleep 상태에서 오류가 날수 있으므로 try catch 문 로 오류를 방여한다.
			while (x1 < 900 || x2 < 900) { //각 창의 좌표 2개가 900이 넘지 않을때까지 반복한다.
				x1 +=(int)(Math.random()*40) +1; //math의random 메소드를 사용후 *40 을 한후 1 을더해 
				//1~41 까지 난수를 설정한다. 또한 math.random 의 반환값이 double 이므로 int 로 형변환을 해준다.
				x2 += (int)(Math.random()*40)+ 1;
				Thread.sleep(100);//0.1초 쉰다
				System.out.println(x1 +","+x2); //디버그용 x1 x2 좌표 출력
				frm1.setLocation(x1, y1); //값이 바뀌면 frm1 의 값을 바꾼다
				frm2.setLocation(x2,y2); //마찬자지로 frm2 의 x 값을 바꾼다.
			}
		//	frm1.setVisible(false);
		//	frm2.setVisible(false);
			//System.out.println(x1>x2);
			System.out.println((x1 > x2 ? "1번 프레임" : "2번 프레임") + "승리"); //while 이 끝나면 출력 3항 연산자를 사용하여 불필요한 소스를 제거한다.
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
}
