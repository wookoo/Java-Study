package master;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Translator extends JFrame{
	
	public Translator() {
		super("English Translator"); //타이틀을 English Translator 로설정
		this.setLayout(new FlowLayout()); //Flow Layout 을 배치 관리자로 설정
		this.setSize(900,300); //윈도우 창 크기 설정
		JPanel EnglishPanel = new JPanel(); //영문 입력이랑 번역 버튼을 담는 JPanel 생성
		EnglishPanel.setLayout(new BorderLayout()); //영어 입력창은 위, 번역버튼을 오른쪽 아래에 있으므로 Border Layout 사용
		JTextArea EnglishInput = new JTextArea(10,30); //세로로 긴 입력착을 만들어야 하므로 JTextArea 사용
		EnglishPanel.add(EnglishInput,BorderLayout.NORTH); //입력창은  BorderLayout 기준 north 에 있으므로 North 로 설정
		JButton TranslateButton = new JButton("번역"); //번역 버튼 생성
		EnglishPanel.add(TranslateButton,BorderLayout.EAST); //번역 창은 BorderLayout 기준, East 에 있으므로 East 로 설정
		
		
		JPanel KoreanPanel = new JPanel();//번역된 결과랑 취소 버튼을 담는 JPanel 생성
		KoreanPanel.setLayout(new BorderLayout()); //번역된 결과 위, 취소버튼을 왼쪽 아래에 있으므로 Border Layout 사용
		JTextArea KoreanResult = new JTextArea(10,30); //세로로 긴 입력착을 만들어야 하므로 JTextArea 사용
		KoreanPanel.add(KoreanResult,BorderLayout.NORTH); //입력창은  BorderLayout 기준 north 에 있으므로 North 로 설정
		JButton CancelButton = new JButton("취소"); //번역 버튼 생성
		KoreanPanel.add(CancelButton,BorderLayout.WEST); //번역 창은 BorderLayout 기준, East 에 있으므로 East 로 설정
		
		
		
		
		
		this.add(EnglishPanel);//EnglishPanel 을 JFrame 에 추가한다.
		
		this.add(KoreanPanel);//EnglishPanel 을 JFrame 에 추가한다.
		
		
		
		
		this.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Translator();
	}

}
