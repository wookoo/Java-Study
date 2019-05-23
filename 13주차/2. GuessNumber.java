package wookoo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessNumber extends JFrame{
	private JTextField InputTextField; //사용자에게 입력 받은 수, 다른 메소드에서 참조하기 위해 필드로 선언
	int Random; //생성된 난수, 다른 메소드에서 참조하기 위해 필드로 선언
	
	
	public GuessNumber() {
		super("숫자 게임"); //윈도우 창 이름을 숫자 게임으로 설정
		Random = (int)(Math.random() *100); //객체가 할당되자 마자 Random 값이 설정되야 하므로, 생성자에 Random 값 설정
		this.setLayout(new GridLayout(3,1)); //3개가 배치 되야 하므로 grid Layout 으로 3개가 배치 되게 설정한다.
		this.setSize(400,200); //창의 크기를 400,200 으로 설정한다.
		System.out.println(Random); //디버그용 Random 값 출력
		
		//첫번째 숫자를 추측하시오 및 입력 칸 설정하는 부분
		JPanel TextPanel = new JPanel(); //JFrame 이 grid Layout 이므로 라벨과 텍스트를 담기 위해 JPanel 객체 생성
		TextPanel.setLayout(new FlowLayout()); //배치 관리자는 FlowLayout 을 사용한다
		JLabel Stringlabel= new JLabel("숫자를 추측하시오 :"); //숫자를 추측하세요 의 텍스를 가진 라벨을 생성
		TextPanel.add(Stringlabel); //라벨이 먼저 추가 되야 하므로 생성된 라벨 추가
		InputTextField = new JTextField(10); //텍스트 필드에 JTextField 객체 생성 후 할당, 사용자에게 입력 받는 부분
		TextPanel.add(InputTextField); //TextPanel 에 JTextField 를 추가한다.
		
		this.add(TextPanel); //JFrame 에 TextPanel 가 제일 먼저 있으므로 추가.
		
		//첫번째 숫자를 추측하시오 및 입력 칸 설정하는 부분 끝
		
		
		//가운데 힌트 설정하는 부분 시작
		JLabel Hint = new JLabel("숫자를 맞춰보세요!"); //숫자를 맞춰보라는 라벨 설정
		Hint.setOpaque(true); //배경 색상을 바꿔야 하므로 Hint 인스턴스가 가진 setOpaque 메소드에 true를 매개 변수로 넣어준다. 
		JPanel HintPanel = new JPanel(); //가운데에 추가할 패널, 1개밖에 없으로 Hint 인스턴스를 그대로 Jframe 에 추가 해도 되지만
		//그렇게 되면, 가운데 JLabel 만 왼쪽으로 밀리게 된다.
		
		HintPanel.add(Hint); //JPanel 에 힌트 패널을 추가한다.
		this.add(HintPanel); //JFrame 에 HintPanel 을 추가한다
		//가운데 힌트 설정하는 부분 끝
		
		JPanel ButtonPanel = new JPanel(); //버튼을 저장할 Panel 생성 
		JButton NewGameButton = new JButton("새 게임"); //JButton 객체를 생성한다, 새 게임 버튼
		
		
		
		NewGameButton.addActionListener(new ActionListener() { //새 게임 버튼의 액션 리스너를 추가한다.
			//람다식이 아닌 익명 클래스로 해준다 > 혹시 모를 실수를 방지
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//새 게임을 눌렀을때 할 작업은, 힌트의 텍스트 초기화, 배경색 초기화, 랜덤 값 초기 화, 입력값 초기화를 해야 한다.
				Hint.setText("숫자를 맞춰보세요!"); //힌트의 텍스트 초기화
				Hint.setBackground(null); //배경색 초기화
				Random = (int)(Math.random() *100); //랜덤값 초기화
				System.out.println(Random); //디버그용 랜덤 출력
				InputTextField.setText(""); //입력값 초기화
			}
			
		});
		
		
		ButtonPanel.add(NewGameButton); //패널에 새게임 버튼을 추가한다.
		
		
		
		
		
		JButton ShutDownButton = new JButton("종료"); //JButton 객체 생성, 종료 버튼
		ShutDownButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//버튼이 눌렀을 경우엔, 프로그램을 꺼야 한다
				System.exit(0); //System 객체가 가진 exit 메소드를 호출하여 프로그램 종료
				
			}
			
		});
		
		
		
		ButtonPanel.add(ShutDownButton); //버튼 패널에 셧다운 버튼을 추가
		
		this.add(ButtonPanel); //JFrame 에 ButtonPanel 을 추가
		
		InputTextField.addKeyListener(new KeyListener() { //엔터키가 눌렸을때 결과를 띄워야 하므로 Key Listener 추가
			//HintText 를 설정해야 하므로, HintText 가 선언된 후에 추가하였음.
			//람다식이 지원이 안되므로 익명클래스로 할당
			
			//사용하지 않는 메소드들 , KeyListener 에 추상 메소드가 정의 되어 있으므로 일단은 구현하지만, 아무 작업 없음.
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			//사용하지 않는 메소드 끝

			
			//사용하는 메소드, 엔터키를 눌렀을때 할 작업
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int KeyCode = e.getKeyCode(); //매개 변수로 들어온 KetEvent 객체가 가진 getKeyCode 메소드를 호출하여 keyCode 에 할당
				
				if (KeyCode ==KeyEvent.VK_ENTER) { //엔터키를 눌렀을때만 작업을 해야됨.
					String HintText; //정답이건 아니건 모두 setText 작업을 해야 하므로 HintText 를 변수로 선언
					Color color = null; //마찬가지로 color 도 바뀌므로 color 을 변수로 선언
					switch(Compare()) {
						case 1: //Compare 의 반환값이 1 이면 정답을 입력한 경우
							HintText = "정답 입니다!"; //HintText 정답으로 선언
							color = new Color(0,255,0);  //Color 는 초록색
							break;
						case 2: //Compare 의 반환값이 2 면, 입력값이 높은 경우
							HintText = "너무 높습니다!"; //HintText 높습니다 선언
							color = Color.red;	//Color 는 red
							break;
						case 3: //Compare 의 반환값이 3이면, 입력값이 낮은 경우
							HintText = "너무 낮습니다!";//HintText 낮습니다 선언
							color = Color.red;//Color 는 red
							break;
						default: //Compare 의 반환값이 1 2 3 이 아니면, 입력에 숫자가 아닌 다른수가 온 경우
							HintText = "오류! 숫자를 입력학세요 !";  //HintText 오류 선언
							color = Color.yellow; //COlor 은 yellow
					
					}
					Hint.setText(HintText); //Hint JLabel 을 위에서 변경된 HintText 로 설정 
					Hint.setBackground(color); //배경도 마찬가지로 위에서 변경된 color 로 설정
					
				}
				
				
			}
			
		});
		

		InputTextField.setFocusable(true); //키 이벤트를 받아올수 있게 setFocusable 을 true 로 설정
		this.setVisible(true);
	}
	
	
	
	
	public int Compare() {
		
		try { //숫자가 아닌 다른 값이 InputTextField 에서 들어온 경우, Integer.parseInt 메소드에 오류가 난다.
			//그러므로 try 문 사용
			if (Integer.parseInt(this.InputTextField.getText()) == this.Random) {
				return 1; //둘이 같은 경우 1반환
			}
			else if (Integer.parseInt(this.InputTextField.getText()) > this.Random ) {
				return 2; //입력 수가 더 큰 경우 2 반환
			}
			else {
				return 3; //입력 수가 더 작은 경우 3 반환
			}
		}
		catch(Exception e) {
			return 0; //오류가 난 경우 예를들어 woo123 을 Int 형으로 형변환을 시도한경우 0 반환
		}
		
	}
	
	
	
	
	
	public static void main(String[] args){
		new GuessNumber(); //생성된 객체에 할 작업이 없으므로, 익명 클래스로 생성하여 JFrame 을 보여준다.
	}

}
