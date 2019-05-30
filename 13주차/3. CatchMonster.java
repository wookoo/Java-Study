package master;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class CatchMonster extends JFrame{
	
	Timer timer; //익명클래스에서 참조하기 워해 필드로 선언
	Image img; //이미지 정보를 Monster 클래스에서 참조하기 위해 필드로 선언
	
	ArrayList<Monster> Monsters = new ArrayList<Monster>(); //몬스터들의 정보를 담는 어레이 리스트생성
	//익명 클래스에서 참조하기 위해 필드로 선언
	
	class Monster{ //몬스터 클래스 선언, Inner Class
		int x, y; //x 좌표 y 좌표를 필드로 선언
		Image icon = img; //이미지 아이콘은  Outter Class 에서 값을 가져온다
		boolean XSign = false; //랜덤으로 이동시키기 위한 부호 , 프레임 안에 있어야 하기 때문에 x 에 더할 값의 부호 결정
		boolean YSign = false; //마찬가지로 y 에 더할 값의 부호 설정
		
		public Monster(int x, int y) { //생성자로, 외부에서 x 와 y 값을 받아와서 x 좌표 y 좌표를 수정한다.
			this.x = x;
			this.y = y;
		}
		//Getter 설정
		public int getX() {
			return this.x;
		}
		public int getY() {
			return this.y;
		}
		public Image getIcon() {
			return this.icon;
		}
	}
	
	class MyComponent extends JComponent{ //JComponent 를 상속받는 MyComponent 생성
		public void paintComponent(Graphics g) {
			//repaint 또는 생성시 
			//Monsters ArrayList 에 x 좌표 y 좌표 아이콘을 가져와서 그림을 그린다.
			for (Monster m : Monsters ) { //for 문을 사용하여 반복
				g.drawImage(m.getIcon(),m.getX(),m.getY(),50,50,null);
			}
		}
	}
	
	
	public CatchMonster() {
		super("Monster Catch Game"); //윈도우 이름 설정
		this.setSize(1000,300);
		ImageIcon icon = new ImageIcon ("D://pack.jpg"); //이미지 설정
		img = icon.getImage(); //img 필드에 icon 이 가진 Image 를 가져와서 할당
		int units = (int)(Math.random() * 30) +5; //몬스터의 갯수 최소 5개 최대 35개
		for (int i = 0; i < units; i ++) { //생성된 몬스터의 갯수 만큼 반복한다
			int RandomX = (int)(Math.random() * 900) + 100; //몬스터의 x 좌표
			int RandomY = (int)(Math.random() * 200) ; //y 좌표를 랜덤으로 설정
			Monsters.add(new Monster(RandomX,RandomY)); //Monsters 배열에 Monster 객체를 할당받는다
			//30 이 생성되었으면, for 문이 30번 반복하므로 몬스터 30 개 가 생성된다
		}
		this.add(new MyComponent()); //JFrame 에 JComponent를 상속받는 MyComponet 추가
		this.setVisible(true); //현재 JFrame 을 보이게 설정
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int x = arg0.getX();  //사용자가 누른 x 좌표
				int y = arg0.getY(); //사용자가 누른 y 좌표
				for (int i  = 0; i < Monsters.size(); i ++) {
					//for 문을 돌려 Monsters 배열의 크기만큼 반복
					int MonsPosX = Monsters.get(i).getX(); //Monster 의 i 번쨰 인덱스의 객체에서 x 좌표와
					int MonsPosY = Monsters.get(i).getY(); //y 좌표를 받아온다
					if ( MonsPosX -50 < x && x < MonsPosX + 50 && MonsPosY-50  < y && y < MonsPosY + 50) {
						Monsters.remove(i); //사용자가 누른 x 좌표 y 좌표가 몬스터면 몬스터 배열의 i 번째 인덱스 제거
						break; //그 후, 여러개가 삭제되면 안되므로 break > 1번에 1개만 
					}
				}
				repaint(); //마우스를 누르면 repaint 를 호출하여 다시 그린다.
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		timer = new Timer(100, new ActionListener() { //타이머 객체 생성, 익명클래스로 타이머 리스너 추가

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Monsters.size(); i ++) { //몬스터 배열의 길이만큼 반복
					int MoveX = (int)(Math.random()*10); //이동할 x 좌표 y 좌표를 랜덤으로 설정
					int MoveY = (int)(Math.random()*10);
					
					
					//Monsters 배열의 i 번째 인덱스의 부호를 보고, 더할 수를 수정한다.
					
					//XSign YSign 이 false 면 더하고, true 면 뺀다
					MoveX = Monsters.get(i).XSign ? -MoveX : MoveX;
					MoveY = Monsters.get(i).YSign ? -MoveY : MoveY;
					
					Monsters.get(i).x += MoveX;
					Monsters.get(i).y += MoveY;
					
					if (Monsters.get(i).x > 1000-100) {//x 좌표가 900을 넘어가면 
						Monsters.get(i).XSign = true; //빼야 하므로 XSign 을 true 로 설정
					}
					else if(Monsters.get(i).x < 0){ //x 좌표가 0보다 작으면
						Monsters.get(i).XSign = false; //더해야 하므로 XSign 을 false 로 설정
					}
					
					if (Monsters.get(i).y > 300-100) { //y 좌표도 마찬가지
						Monsters.get(i).YSign = true;
					}
					else if(Monsters.get(i).y < 0){
						Monsters.get(i).YSign = false;
					}
				
					
					
				}
				
				repaint();
				if(Monsters.size() == 0) {
					timer.stop(); //몬스터가 배열에 남아있지 않으면, timer 객체를 중지시킨다.
				}
			}
			
			
		});
		timer.start();  //생성된 타이머 객체 시작
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //윈도우 창이 닫히면 자동으로 꺼지게 설정
		
		
	}
	
	
	
	public static void main(String[] args) {
		new CatchMonster();
	}
}
