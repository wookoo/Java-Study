import java.util.Scanner;

abstract class Sprite{ //추상클래스 Sprite 를 정의한다.
	int x = 3; //추상클래스의 x 좌표 y 좌표를 설정한다.
	int y = 3;	//오버로딩을 하면, x 값 y 값은 그대로 3이다.
	abstract void move(char c); //Sprite 추상 클래스는 move 라는 메소드는 가지고 있다를 의미한다.
}

class Main extends Sprite{	//추상클래스 Sprite 를 상속받아서 Main 클래스를 정의한다.

	@Override
	void move(char c) {	//추상클래스 sprite 를 상속받았기에, 정의되지 않은 move 메소드를 재정의 해준다.
		if (c == 'a') --y; //a 를 누르면 y 좌표를 감소시켜 왼쪽으로 이동한다.
		else if ( c== 's') ++x; //s 를 누르면 x 좌표를 증가시켜 아래로 이동한다.
		else if ( c== 'd') ++y; //d 를 누르면 y 좌표를 증가시켜 오른쪽으로 이동한다.
		else if (c =='w')--x; //w 를 누르면 x 좌표를 감소시켜 위로 이동한다.
		//배열의 index 값을 넘지 않게 하는 부분이다.
		x = x == 9 ? 8 : x ;  //x 가 9면 9번쨰 인덱스는 없으므로 8 로 한다.
		x = x == -1 ? 0 : x;  //x 가 -1이면 -1 인덱스는 없으므로 0으로 한다.
		y = y == 9 ? 8 : y; //y 가 9면 9번째 인덱스는 없으므로 8로 한다.
		y = y == -1 ? 0 : y; //y 가 -1 이면 -1 인덱스는 없으므로 0으로 한다.
		
	}
}
class Monster extends Sprite{//추상클래스 Sprite 를 상속받아서 Monster 클래스를 정의한다.


	public Monster() { //x 좌표 y 좌표는 Main 과 달라야 하기 떄문에 생성자로 x y 좌표를 바꿔준다,
		x = y = 7;
	}
	@Override
	void move(char c) { //추상클래스 sprite 를 상속받았기에, 정의되지 않은 move 메소드를 재정의 해준다.
		//추상클래스에서 인자는 항상 값을 받으므로 move 에 char c 를 넣어준다. 이 메서드에서는 필요 없음에도 불구하고 말이다. 
		// TODO Auto-generated method stub
		x += (Math.random()-0.5 > 0 ) ? 1 : -1;  //x 좌표는 50 % 확률로 1을 더해주거나 뺀다.
		y += (Math.random()-0.5 > 0 ) ? 1 : -1;  //y 좌표도 마찬가지로 50% 확률로 1을 더해주거나 뺸다.
		x = x == 9 ? 8 : x ;  //x 가 9면 9번쨰 인덱스는 없으므로 8 로 한다.
		x = x == -1 ? 0 : x;  //x 가 -1이면 -1 인덱스는 없으므로 0으로 한다.
		y = y == 9 ? 8 : y; //y 가 9면 9번째 인덱스는 없으므로 8로 한다.
		y = y == -1 ? 0 : y; //y 가 -1 이면 -1 인덱스는 없으므로 0으로 한다.
	}
	
}

public class MonsterGame {
	public static void main(String[] args) {
		
		char[][] GameBoard = new char[9][9]; //최대 index 가 8 8 인 2차월 배열 GameBoard 선언
		int GoldX = 5; //금의 좌표를 설정해준다.
		int GoldY = 4;
		
		Scanner sc = new Scanner(System.in); //스캐너 클래스를 사용하여 sc 객체를 생성한다.
		Main main = new Main(); //Main 클래스를 사용하여 main 객체를 생성한다.
		Monster monster = new Monster(); //Monster 클래스를 사용하여 monster 객체를 생성한다.
		while(true) { //종료 지점을 모르므로 무한반복을 해준다.
			for (int i = 0; i< 9; i ++) {
				for (int j = 0; j < 9; j ++) {
					GameBoard[i][j] = ' '; 
				}//게임판을 모두 ' ' 로 만들어준다. > 게임판을 클리어
			}
			
				GameBoard[GoldX][GoldY] = 'G'; //금의 x 좌표 y 좌표는 G 로 만들어준다.
				GameBoard[main.x][main.y] = '@'; //main 객체가 가진 x 좌표 y 좌표에는 유저모양 @를 만들어준다.
				GameBoard[monster.x][monster.y] = 'M'; //monster 객체가 가진 x 좌표 y 좌표에는 몬스터 M 을 만들어준다.
				
				//그림은 각각 금, 유저, 몬스터 순으로 할당을 해줘야 하는데, 유저가 G 위로 가면 G 가 아니라 @ 가 보여야 하기 때문이다
				//마찬가지로 몬스터가 @ 위로 가면 몬스터만 남았으므로 M 은 맨 마지막에 해준다.
				
				

			//게임 판을 출력하는 부분
			System.out.println("####################");
			for (int i = 0; i< 9; i ++) {
				System.out.print("#");
				for (int j = 0; j < 9; j ++) {
					System.out.print(GameBoard[i][j]+ " ");
				}
				System.out.println("#");
			}
			System.out.println("####################");
			
			//만약 main 객체의 x y 좌표가 monster 객체의 x y 랑 같은경우, 몬스터에게 잡힌것 이다.
			if (main.x == monster.x && main.y == monster.y) {
				System.out.println("몬스터에 먹혀 게임에 패배하였습니다!");
				break;
			}
			
			//만약 main 객체의 x y 좌표가 gold 의 x y 랑 같은 경우, 보물을 찾은 경우이다.
			if (main.x == GoldX && main.y == GoldY) {
				System.out.println("보물에 도착하여 게임에 승리하였습니다!");
				break;
			}
			
			System.out.print("위(W) 아래 (S) 오른쪽 (D) 왼쪽 (A) : ");
			//string 으로 반환된 next 의 0번째 index 는 char 이고 그는 곧 k 이다.
			char k = sc.next().charAt(0);
			//main 과 monster 의 move 메소드를 호출한다.
			main.move(k);
			monster.move(k);
			
		}
		
		
	}
}
