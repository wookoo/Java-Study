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
		Random = (int)(Math.random() *100);
		this.setLayout(new GridLayout(3,1));
		this.setSize(400,200);
		System.out.println(Random);
		
		//첫번째 숫자를 추측하시오 및 입력 칸 설정하는 부분
		JPanel TextPanel = new JPanel();
		TextPanel.setLayout(new FlowLayout());
		JLabel Stringlabel= new JLabel("숫자를 추측하시오 :");
		TextPanel.add(Stringlabel);
		InputTextField = new JTextField(10);
		TextPanel.add(InputTextField);
		
		
		
		
		
		this.add(TextPanel);
		//첫번째 숫자를 추측하시오 및 입력 칸 설정하는 부분 끝
		
		
		//가운데 힌트 설정하는 부분 시작
		JLabel Hint = new JLabel("숫자를 맞춰보세요!");
		Hint.setOpaque(true);
		JPanel HintPanel = new JPanel();
		HintPanel.add(Hint);
		this.add(HintPanel);
		//가운데 힌트 설정하는 부분 끝
		
		JPanel ButtonPanel = new JPanel();
		JButton NewGameButton = new JButton("새 게임");
		
		
		
		NewGameButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Hint.setText("숫자를 맞춰보세요!");
				Hint.setBackground(null);
				Random = (int)(Math.random() *100);
				System.out.println(Random);
				InputTextField.setText("");
			}
			
		});
		
		
		ButtonPanel.add(NewGameButton);
		
		
		
		
		
		JButton ShutDownButton = new JButton("종료");
		ShutDownButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		
		
		
		ButtonPanel.add(ShutDownButton);
		
		this.add(ButtonPanel);
		
		InputTextField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int KeyCode = e.getKeyCode();
				if (KeyCode ==KeyEvent.VK_ENTER) {
					if (Compare() == 1) {
						Hint.setText("정답 입니다!");
						Hint.setBackground(new Color(0,255,0));
					}
					else if(Compare() == 2) {
						Hint.setText("너무 높습니다!");
						Hint.setBackground(Color.red);
					}
					else if(Compare() == 3) {
						Hint.setText("너무 낮습니다!");
						Hint.setBackground(Color.red);
					}
					else {
						Hint.setText("오류 !숫자를 입력하세요 !");
						Hint.setBackground(Color.yellow);
					}
				}
				
				
			}
			
		});
		
		
	
		InputTextField.setFocusable(true);
		this.setVisible(true);
	}
	
	
	
	
	public int Compare() {
		
		try {
			if (Integer.parseInt(this.InputTextField.getText()) == this.Random) {
				return 1; //둘이 같은 경우
			}
			else if (Integer.parseInt(this.InputTextField.getText()) > this.Random ) {
				return 2; //입력 수가 더 큰 경우
			}
			else {
				return 3; //입력 수가 더 작은 경우
			}
		}
		catch(Exception e) {
			
		}
		return 0; //오류가 난 경우
		
	}
	
	
	
	
	
	public static void main(String[] args){
		new GuessNumber(); //생성된 객체에 할 작업이 없으므로, 익명 클래스로 생성하여 JFrame 을 보여준다.
	}

}
