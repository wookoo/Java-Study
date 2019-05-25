package master;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe extends JFrame{
	
	ArrayList<JButton> WellButtons = new ArrayList<JButton>(); //버튼을 담는 ArrayList 생성
	String turn = "X";
	
	ArrayList<Integer> UserLastPostion = new ArrayList<Integer>(); //사용자의 마지막 위치를 담는 버튼 생성
	ArrayList<Integer> ComputerLastPostion = new ArrayList<Integer>(); //컴퓨터의 마지막 위치를 담는 버튼 생성

	String[][] Board = { //착수 위치를 저장하기 위한 판, 게임 승리 알고리즘 검사할때 활용
			{"","",""},
			{"","",""},
			{"","",""}
	};
	public TicTacToe() {
		super("틱택토 게임"); //틱텍토 게임이라고 윈도우 창 이름 설정
		
		
		ImageIcon ReferenceX = new ImageIcon("D:/X.png");  //임시 이미지 파일 2개 가져오기
		ImageIcon ReferenceO = new ImageIcon("D:/O.png");
		Image TempImageX = ReferenceX.getImage();
		Image TempImageO = ReferenceO.getImage();
		ImageIcon X_ICON = new ImageIcon(TempImageX.getScaledInstance(98-15, 85-15, java.awt.Image.SCALE_SMOOTH)); //가져온 이미지 2개 크기 조절
		ImageIcon O_ICON = new ImageIcon(TempImageO.getScaledInstance(98-15, 85-15, java.awt.Image.SCALE_SMOOTH)); 
		
		
		
		this.setSize(300,350);
		this.setLayout(new BorderLayout()); //배치를 위한 BorderLayout 생성 
		JPanel functionPanel = new JPanel(); //특수 기능 버튼을 담는 패널 생성
		JButton NewGame = new JButton("새 게임"); //새 게임을 하는 버튼 생성
		JButton Undo = new JButton("←"); //착수를 다시 하는 버튼 생성
		JButton Exit = new JButton("종료"); //종료를 하는 버튼 생성
		

		
		functionPanel.add(NewGame);
		functionPanel.add(Undo);
		functionPanel.add(Exit);
		
		JLabel ResultLabel = new JLabel("Player 1 의 차례");
		JPanel ResultPanel = new JPanel();
		ResultPanel.add(ResultLabel);
		
		
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
					
					int BoardX = k/3;
					int BoardY = k%3;
					
					if(Board[BoardX][BoardY] == "" && WinCheck().equals("")) { //착수 위치가 비어있고 게임이 안끝난경우
						//TempButton.setText(turn);
						TempButton.setBackground(Color.yellow); //마지막 착수 위치 표기
						TempButton.setIcon(turn.equals("X") ? X_ICON : O_ICON);
						
						Board[BoardX][BoardY] = turn;
						
						ResultLabel.setText(turn.equals("O") ? "Player 1 의 차례" : "Player 2 의 차례");
						turn = turn.equals("X") ? "O" : "X";
						if(WinCheck().equals("O")|| WinCheck().equals("X")) {
							ResultLabel.setText(WinCheck().equals("X") ? "Player 1 의 승리!" : "Player 2 의 승리!"); //승리 검사
						}else if(WinCheck().equals("DRAW")) {
							ResultLabel.setText("무승부!");
						}
						
						//마지막 착수 위치 표기 해야됨.
						try {
							JButton b = WellButtons.get(UserLastPostion.get(UserLastPostion.size()-1));
							b.setBackground(null);
							
						}
						catch(Exception Error) {
							
						}
						finally {
							UserLastPostion.add(k);
						}
						
						
					}
					
				}
				
			});
		}
		
		NewGame.addActionListener(new ActionListener() { //새 게임을 하면 판이 초기화되야 한다.

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (JButton b: WellButtons) { //for each 문을 사용하여 버튼의 글자 초기화
					b.setBackground(null);
					b.setIcon(null);
					ResultLabel.setText("Player 1 의 차례");
					turn = "X"; //차례도 초기화 해줘야됨
					for (int i =0; i < 3; i++) {    //게임판 초기화
						for (int j=0; j<3; j++) {
							Board[i][j] = "";
						}
					}
					
				}
				
			}
			
		});
		
		Undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
				try {
					
					if (WinCheck().equals("")) { //게임이 끝난상태가 아니라면
						int LastPostion = UserLastPostion.get(UserLastPostion.size()-1);
						UserLastPostion.remove(UserLastPostion.size()-1); //마지막 인덱스 삭제 , 마지막 착수 위치 저장된값 지우기
						
						System.out.println(LastPostion);//유저가 마지막 착수한 부분을 출력
						
						JButton TempButtons = WellButtons.get(LastPostion); //마지막 착수 위치 버튼을 가져오고
						TempButtons.setIcon(null); //버튼 글자 초기화
						TempButtons.setBackground(null);
						int BoardX = LastPostion/3; //착수 위치를 가지고 X Y 위치를 설정한다
						int BoardY = LastPostion%3;
						Board[BoardX][BoardY] = ""; //해당 착수위치의 보드를 "" 로 만든다. > 해당 부분 지우기
						turn = turn.equals("X") ? "O" : "X";
						ResultLabel.setText(turn.equals("X") ? "Player 1 의 차례" : "Player 2 의 차례");
						
						
						
						int LastBeforePostion = UserLastPostion.get(UserLastPostion.size()-1); //마지막 전에 버튼을 가져와서
						JButton TempButton = WellButtons.get(LastBeforePostion);
						TempButton.setBackground(Color.yellow); //마지막 전 버튼이 마지막에 눌렸으므로 테두리 표기
						
						
						
						
					}
					
				}
				catch(Exception error){
					//error.printStackTrace();
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
		
		
		this.add(ResultPanel,BorderLayout.SOUTH);
		this.setResizable(false); //크기를 조절하지 못하게 수정한다.
		this.setVisible(true); 
	}
	
	private String WinCheck() {
		
		
		 for(int i=0; i<3; i++){ 
			 if( Board[0][i].equals(Board[1][i]) && Board[1][i].equals(Board[2][i])) {
				 return Board[0][i];
			 }
			 
		 } 
		 for(int i=0; i<3; i++){
			 if( Board[i][0].equals(Board[i][1]) && Board[i][1].equals(Board[i][2])) {
				 return Board[i][0];
			 }
	
		 } 

			 
		 if( Board[0][0].equals(Board[1][1]) && Board[1][1].equals(Board[2][2])) {
			return Board[0][0];
				
		}
		 if( Board[2][0].equals(Board[1][1]) && Board[1][1].equals(Board[2][0])) {
				return Board[2][0];
					
			}
		for (int i=0; i<3;i++) {
			for (int j=0; j<3; j++) {
				if (Board[i][j].equals("")) {
					return ""; //보드가 꽉차지 않은 경우
				}
			}
		}
		return "DRAW"; //보드가 꽉찬 경우 무승부
		
		
	}

	
	
	public static void main(String[] args) {
		new TicTacToe();
	}

}
