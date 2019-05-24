package master;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToe extends JFrame{
	
	ArrayList<JButton> WellButtons;
	String turn = "X";
	int UserLastPostion = 0;
	int ComputerLastPostion = 0; //뒤로가기 버튼을 만들기 위한 버튼 Postion 생성
	public TicTacToe() {
		super("틱택토 게임"); //틱텍토 게임이라고 윈도우 창 이름 설정
		
		WellButtons = new ArrayList<JButton>(); //버튼을 담는 ArrayList 생성
		
		
		this.setSize(300,350);
		this.setLayout(new BorderLayout()); //배치를 위한 BorderLayout 생성 
		JPanel functionPanel = new JPanel(); //특수 기능 버튼을 담는 패널 생성
		JButton NewGame = new JButton("새 게임"); //새 게임을 하는 버튼 생성
		JButton Undo = new JButton("←"); //착수를 다시 하는 버튼 생성
		JButton Exit = new JButton("종료"); //종료를 하는 버튼 생성
		
		functionPanel.add(NewGame);
		functionPanel.add(Undo);
		functionPanel.add(Exit);
		
		
		
		JPanel GamePanel = new JPanel(); //게임을 위한 버튼 9개를 담는 패널
		GamePanel.setLayout(new GridLayout(3,1));
		for (int i =0; i < 9; i++) { //for 문으로 버튼 생성및 추가
			WellButtons.add(new JButton());
			GamePanel.add(WellButtons.get(i));
		}
		
		for (int i = 0; i < WellButtons.size();i++) { //버튼에 대한 동작 설정
			final int k = i;
			JButton TempButton = WellButtons.get(k);
			TempButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					TempButton.setText(turn);
					turn = turn.equals("X") ? "O" : "X";
					UserLastPostion = k;
					
					
				}
				
			});
		}
		
		NewGame.addActionListener(new ActionListener() { //새 게임을 하면 판이 초기화되야 한다.

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (JButton b: WellButtons) { //for each 문을 사용하여 버튼의 글자 초기화
					b.setText(" ");
				}
				
			}
			
		});
		
		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		
		
		this.add(functionPanel,BorderLayout.NORTH);
		this.add(GamePanel, BorderLayout.CENTER);
		
		this.setVisible(true); 
	}
	
	public static void main(String[] args) {
		new TicTacToe();
	}

}
