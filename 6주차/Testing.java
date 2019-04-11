import java.util.Scanner;

abstract class Sprite{
	int x = 3;
	int y = 3;
	abstract void move(char c);
}

class Main extends Sprite{

	@Override
	void move(char c) {
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
