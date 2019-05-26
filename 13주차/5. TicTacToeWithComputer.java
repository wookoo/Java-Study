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

public class TicTacToeWithComputer extends JFrame {

	ArrayList<JButton> WellButtons = new ArrayList<JButton>(); // 버튼을 담는 ArrayList 생성

	ArrayList<Integer> UserLastPostion = new ArrayList<Integer>(); // 사용자의 마지막 위치를 담는 어레이 리스트 생성
	ArrayList<Integer> ComputerLastPostion = new ArrayList<Integer>(); // 컴퓨터의 마지막 위치를 담는 어레이 리스트 생성

	ImageIcon X_ICON;
	ImageIcon O_ICON;
	JLabel ResultLabel;
	String[][] Board = { // 착수 위치를 저장하기 위한 판, 게임 승리 알고리즘 검사할때 활용
			{ "", "", "" }, { "", "", "" }, { "", "", "" } };

	public TicTacToeWithComputer() {
		super("틱택토 게임"); // 틱텍토 게임이라고 윈도우 창 이름 설정

		ImageIcon ReferenceX = new ImageIcon("D:/X.png"); // 임시 이미지 파일 2개 가져오기
		ImageIcon ReferenceO = new ImageIcon("D:/O.png");
		Image TempImageX = ReferenceX.getImage();
		Image TempImageO = ReferenceO.getImage();
		X_ICON = new ImageIcon(TempImageX.getScaledInstance(98 - 15, 85 - 15, java.awt.Image.SCALE_SMOOTH)); 
		O_ICON = new ImageIcon(TempImageO.getScaledInstance(98 - 15, 85 - 15, java.awt.Image.SCALE_SMOOTH));
		// 가져온 이미지 2개의 크기 조절
		
		this.setSize(300, 350);
		this.setLayout(new BorderLayout()); // 배치를 위한 BorderLayout 생성
		JPanel functionPanel = new JPanel(); // 특수 기능 버튼을 담는 패널 생성
		JButton NewGame = new JButton("새 게임"); // 새 게임을 하는 버튼 생성
		JButton Undo = new JButton("←"); // 착수를 다시 하는 버튼 생성
		JButton Exit = new JButton("종료"); // 종료를 하는 버튼 생성

		functionPanel.add(NewGame); // 기능 패널에 버튼 3개 추가
		functionPanel.add(Undo);
		functionPanel.add(Exit);

		ResultLabel = new JLabel("Player의 차례"); // 결과 라벨의 누구의 턴인지 알려준다.
		JPanel ResultPanel = new JPanel();
		ResultPanel.add(ResultLabel);

		JPanel GamePanel = new JPanel(); // 게임을 위한 버튼 9개를 담는 패널
		GamePanel.setLayout(new GridLayout(3, 1));
		for (int i = 0; i < 9; i++) { // for 문으로 버튼 생성및 추가
			WellButtons.add(new JButton());
			GamePanel.add(WellButtons.get(i));
		}

		for (int i = 0; i < WellButtons.size(); i++) { // 버튼에 대한 동작 설정
			final int k = i;
			JButton TempButton = WellButtons.get(k);
			TempButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					int BoardX = k / 3;
					int BoardY = k % 3;

					if (Board[BoardX][BoardY] == "" && WinCheck(Board).equals("")) { // 착수 위치가 비어있고 게임이 안끝난경우

						TempButton.setBackground(Color.yellow); // 마지막 착수 위치 버튼에서 표기 > 이미지 크기가 버튼 보다 작아서 테두리가 노란색으로 보이는
																// 효과가 됨
						TempButton.setIcon(X_ICON); // 기본 아이콘 설정

						Board[BoardX][BoardY] = "X"; // 해당 X 좌표 y 좌표에 X 로 칠한다.

						if (WinCheck(Board).equals("O") || WinCheck(Board).equals("X")) { // X 좌표 Y 좌표에 칠한 후 승리가 판별나면
							ResultLabel.setText(WinCheck(Board).equals("X") ? "Player 의 승리!" : "Computer 의 승리!"); // 승리자 확인 후 라벨 변경
																										
						} else if (WinCheck(Board).equals("DRAW")) { //무승부인 경우
							ResultLabel.setText("무승부!");
						} else { // 경기 결과가 안끝난 경우
							int i = findBestPostion();
	
							Board[i / 3][i % 3] = "O";
							JButton ComputerButton = WellButtons.get(i);
							ComputerButton.setBackground(Color.green); // 마지막 컴퓨터 착수 위치 표기 > 이미지 크기가 버튼보다 작아서 테두리가 초록색으로
																		// 보이는 효과가 됨
							ComputerButton.setIcon(O_ICON); // 버튼
							if (WinCheck(Board).equals("O") || WinCheck(Board).equals("X")) { //컴퓨터가 착수 한 후 게임이 끝났는지 검사
								ResultLabel.setText(WinCheck(Board).equals("X") ? "Player 의 승리!" : "Computer 의 승리!"); // 승리자 확인 후 라벨 변경
							} else if (WinCheck(Board).equals("DRAW")) {
								ResultLabel.setText("무승부!");
							}

							try { // 컴퓨터의 마지막 착수 위치만 초록색으로 표기 해야 하므로 착수하기 전 버튼의 배경을 바꿔야함
								JButton b = WellButtons.get(ComputerLastPostion.get(ComputerLastPostion.size() - 1));
								// 컴퓨터가 착수한게 맨 처음이면 get(ComputerLastPostion.size()-1) 에서 오류가 발생한다.
								// 그러므로 try catch 문 사용
								b.setBackground(null); // 배경 초기화
							} catch (Exception error) {
								// ArrayListIndexException 이 발생한 경우 아무작업도 하지 않는다.
							} finally {
								ComputerLastPostion.add(i); // 오류가 나던 안나던 ComputerLastPostion 엔 컴퓨터가 착수한 위치를 설정해야 한다.
							}

	
						}
						print_board(); //디버그용 보드 출력

						// 마지막 착수를 하면, 착수하기 전 버튼의 배경은 노란색이므로 null 로 만들어줘야한다.
						try {
							JButton b = WellButtons.get(UserLastPostion.get(UserLastPostion.size() - 1));
							// 맨 처음으로 착수한 경우면 ArrayListsIndexException 이 생길수 있다

							// 그러므로 try catch 문 사용
							b.setBackground(null); // 배경 초기화

						} catch (Exception Error) {
							// 오류가 발생하면 아무작업 하지 않음
						} finally {
							UserLastPostion.add(k); // finally 구문으로 오루가 나던 안나던 UserlastPostion 에 마지막 착수 위치를 업데이트 해야됨.
						}

					}

				}

			});
		}

		NewGame.addActionListener(new ActionListener() { // 새 게임을 하면 판이 초기화되야 한다.

			@Override
			public void actionPerformed(ActionEvent e) {

				ResultLabel.setText("Player의 차례"); // 라벨이 변경되어있을수 있으므로 초기화
				UserLastPostion.clear(); // 유저의 마지막 착수 위치를 갖는 ArrayList 초기화
				ComputerLastPostion.clear(); // 컴퓨터의 마지막 착수 위치를 갖는 ArrayList 초기화
				// TODO Auto-generated method stub
				for (JButton b : WellButtons) { // for each 문을 사용하여 버튼의 글자 초기화해야됨
					b.setBackground(null); // 버튼의 배경색 초기화
					b.setIcon(null); // 아이콘도 초기화

					for (int i = 0; i < 3; i++) { // 게임판 초기화
						for (int j = 0; j < 3; j++) {
							Board[i][j] = "";
						}
					}

				}

			}

		});

		Undo.addActionListener(new ActionListener() { // 무르기 버튼을 누르면 마지막 착수 부분을 지워야 한다.

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {// 사용자가 착수를 아예 안한 상태면 UserLastPostion.get(UserLastPostion.size()-1) 이 오류가 나므로
					// try catch 사용

					int UserLast = UserLastPostion.get(UserLastPostion.size() - 1); // 유저가 마지막 착수 한 부분을 가져온다.
					UserLastPostion.remove(UserLastPostion.size() - 1); // 마지막 인덱스 삭제 , 마지막 착수 위치 저장된값 지우기

					JButton UserButton = WellButtons.get(UserLast); // 마지막 착수 위치 버튼을 가져오고
					UserButton.setIcon(null); // 버튼 글자 초기화
					UserButton.setBackground(null); // 버튼 배경 색상 초기화
					int UserX = UserLast / 3; // 착수 위치를 가지고 X Y 위치를 설정한다
					int UserY = UserLast % 3;
					Board[UserX][UserY] = ""; // 해당 착수위치의 보드를 "" 로 만든다. > 해당 부분 지우기

					int ComputerLast = ComputerLastPostion.get(ComputerLastPostion.size() - 1); // 컴퓨터가 마지막 착수한 부분을
																								// 가져온다.
					ComputerLastPostion.remove(ComputerLastPostion.size() - 1); // 마지막 인덱스 삭제 , 마지막 착수 위치 저장된값 지우기

					JButton ComputerButton = WellButtons.get(ComputerLast); // 마지막 착수 위치 버튼을 가져오고
					ComputerButton.setIcon(null); // 버튼 글자 초기화
					ComputerButton.setBackground(null);// 버튼 색상 초기화
					int ComputerX = ComputerLast / 3; // 착수 위치를 가지고 X Y 위치를 설정한다
					int ComputerY = ComputerLast % 3;
					Board[ComputerX][ComputerY] = ""; // 컴퓨터가 착수한 착수위치의 보드를 "" 로 만든다. > 해당 부분 지우기

					int LastBeforePostion = UserLastPostion.get(UserLastPostion.size() - 1);
					// 마지막 전에 버튼을 가져온다 즉 2 번 3 번 버튼을 누른상태면 2번 버튼을 가져온다.
					UserButton = WellButtons.get(LastBeforePostion);
					UserButton.setBackground(Color.yellow); // 마지막 전 버튼이 마지막에 눌렸으므로 테두리 표기

					int ComputerLastBeforePostion = ComputerLastPostion.get(ComputerLastPostion.size() - 1);
					// 마지막 전에 버튼을 가져온다 즉 2 번 3 번 버튼을 누른상태면 2번 버튼을 가져온다.
					ComputerButton = WellButtons.get(ComputerLastBeforePostion);
					ComputerButton.setBackground(Color.green); // 마지막 전 버튼이 마지막에 눌렸으므로 테두리 표기

				} catch (Exception error) {
					// 사용자가 착수를 아예 안한 상태면 UserLastPostion.get(UserLastPostion.size()-1) 에서 ArrayListIndexException 이 발생한다.
					// 오류가 난 경우 아무작업 수행 안함
				}

			}

		});

		Exit.addActionListener(new ActionListener() { // 종료 버튼을 누르면

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);// 프로그램 종료
			}

		});

		this.add(functionPanel, BorderLayout.NORTH); // 패널을 JFrame 에 적절히 푸가
		this.add(GamePanel, BorderLayout.CENTER);

		this.add(ResultPanel, BorderLayout.SOUTH);
		this.setResizable(false); // 크기를 조절하지 못하게 수정한다.
		this.setVisible(true);
	}

	private String WinCheck(String[][] Board) { // 승리를 체크하는 알고리즘

		for (int i = 0; i < 3; i++) {
			if (Board[0][i].equals(Board[1][i]) && Board[1][i].equals(Board[2][i])) { // 가로줄 검사
				return Board[0][i];
			}

		}
		for (int i = 0; i < 3; i++) {
			if (Board[i][0].equals(Board[i][1]) && Board[i][1].equals(Board[i][2])) { // 세로줄 검사
				return Board[i][0];
			}

		}

		if (Board[0][0].equals(Board[1][1]) && Board[1][1].equals(Board[2][2])) { // 대각선 검사 ( ↘ 대각선 검사)
			return Board[0][0];

		}
		if (Board[2][0].equals(Board[1][1]) && Board[1][1].equals(Board[0][2])) { // 대각선 검사 (↗ 대각선 검사)
			return Board[2][0];

		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (Board[i][j].equals("")) {
					return ""; // 보드가 꽉차지 않은 경우 위의 return 이 수행 안되므로 승자가 없음을 반환
				}
			}
		}
		return "DRAW"; // 보드가 꽉찬 경우 무승부

	}

	private int findBestPostion() { // 컴퓨터가 베스트 케이스를 찾는 경우
		/*
		 * 베스트 케이스의 가중치는 다음과 같다 
		 * 1. 컴퓨터가 이기는 경우엔 이길수 있는 수 착수
		 * 2. 사용자가 이기는 경우엔 사용자가 이길수 있는 수 착수 
		 * 3. 가운데가 비어있는 경우 가운데 착수 > 다른곳에 착수 하면 컴퓨터가 질 가능성이 높아짐
		 * 4. 그 외의 랜덤이 비어있는 경우 착수
		 */

		String[][] TempBoard = new String[3][3];

		for (int k = 0; k < 9; k++) {
			for (int i = 0; i < 3; i++) { // 보드 초기화
				for (int j = 0; j < 3; j++) {
					TempBoard[i][j] = Board[i][j];
				}
			}

			// 검사 우선은 컴퓨터가 착수한 부분이 먼저 O 가 된 경우
			if (TempBoard[k / 3][k % 3].equals("")) {
				TempBoard[k / 3][k % 3] = "O";
				if (!WinCheck(TempBoard).equals("")) {
					return k; // 컴퓨터가 이긴 경우엔 그 자리를 컴퓨터가 착수
				}

			}

			for (int i = 0; i < 3; i++) { // 보드 초기화
				for (int j = 0; j < 3; j++) {
					TempBoard[i][j] = Board[i][j];
				}
			}
			// 컴퓨터가 이길수 없고 사용자가 이길수 있는 경우 검사
			if (TempBoard[k / 3][k % 3].equals("")) {
				TempBoard[k / 3][k % 3] = "X";
				if (!WinCheck(TempBoard).equals("")) {
					return k; // 사용자가 이긴 경우
				}

			}
			if (TempBoard[1][1].equals("")) {
				return 4; // 컴퓨터는 가운데가 비어있으면 무조건 착수를 진행
			}

		}
		for (int i = 0; i < 3; i++) { // 보드 초기화
			for (int j = 0; j < 3; j++) {
				TempBoard[i][j] = Board[i][j];
			}
		}
		// 위에서 리턴이 수행이 안된 경우 랜덤 포지션 반환
		do {
			int first;
			int second;
			first = (int) (Math.random() * 3);
			second = (int) (Math.random() * 3);
			if (TempBoard[first][second].equals("")) {
				return first * 3 + second;
			}
		} while (true); //무조건 랜덤 포지션이 반환될수 있게 수정
	}

	private void print_board() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(Board[i][j] + "\t|");

			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new TicTacToeWithComputer();
	}

}
