import java.util.Scanner;

abstract class Sprite{ //추상클래스 Sprite 를 정의한다.
	int x = 3; //추상클래스의 x 좌표 y 좌표를 설정한다.
	int y = 3;	//오버로딩을 하면, x 값 y 값은 그대로 3이다.
	abstract void move(char c); //Sprite 추상 클래스는 move 라는 메소드는 가지고 있다를 의미한다.
}

class Main extends Sprite{	//추상클래스 Sprite 를 상속받아온다

	@Override
	void move(char c) {	//추상클래스
		if (c == 'a') --y;
		else if ( c== 's') ++x;
		else if ( c== 'd') ++y;
		else if (c =='w')--x;
		x = x == 9 ? 8 : x ;
		x = x == -1 ? 0 : x;
		y = y == 9 ? 8 : y;
		y = y == -1 ? 0 : y;
		
	}
}
class Monster extends Sprite{


	public Monster() {
		x = y = 7;
	}
	@Override
	void move(char c) {
		// TODO Auto-generated method stub
		x += (Math.random()-0.5 > 0 ) ? 1 : -1;
		y += (Math.random()-0.5 > 0 ) ? 1 : -1;
		x = x == 9 ? 8 : x ;
		x = x == -1 ? 0 : x;
		y = y == 9 ? 8 : y;
		y = y == -1 ? 0 : y;
	}
	
}

public class Testing {
	public static void main(String[] args) {
		
		char[][] GameBoard = new char[9][9];
		int GoldX = 5;
		int GoldY = 4;
		
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		Monster monster = new Monster();
		while(true) {
			for (int i = 0; i< 9; i ++) {
				for (int j = 0; j < 9; j ++) {
					GameBoard[i][j] = ' ';
				}
			}
				GameBoard[GoldX][GoldY] = 'G';
				GameBoard[main.x][main.y] = '@';
				GameBoard[monster.x][monster.y] = 'M';

		
			System.out.println("####################");
			for (int i = 0; i< 9; i ++) {
				System.out.print("#");
				for (int j = 0; j < 9; j ++) {
					System.out.print(GameBoard[i][j]+ " ");
				}
				System.out.println("#");
			}
			System.out.println("####################");
			if (main.x == monster.x && main.y == monster.y) {
				System.out.println("몬스터에 먹혀 게임에 패배하였습니다!");
				break;
			}
			if (main.x == GoldX && main.y == GoldY) {
				System.out.println("보물에 도착하여 게임에 승리하였습니다!");
				break;
			}
			
			System.out.print("위(W) 아래 (S) 오른쪽 (D) 왼쪽 (A) : ");
			char k = sc.next().charAt(0);
			main.move(k);
			monster.move(k);
			
		}
		
		
	}
}
