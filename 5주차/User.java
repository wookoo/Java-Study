import java.util.ArrayList;
import java.util.Scanner;

public class User {
	String userid,password; //User 클래스는 각각 userid 와 password 라는 필드를 갖는다.
	static int count; //모든 user 클래스가 공유하는 static 변수 count 를 생성한다.

	public User(String userid,String password) { //String 형의 userid, String 형의 password 를
		//생성자의 인자로 받는다.
		this.userid = userid; //인자로 받은 userid 를 필드 userid 에 할당한다.
		this.password = password; //인자로 받은 password 를 필드 password 에 할당한다.
		count ++; //생성자가 호출될때 마다 static int count 는 1이 증가한다.
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0; //do while 문 실행과 종료를 위한 input 변수 생성
		Scanner sc = new Scanner(System.in); //while 문이 돌때마다  값을 받아야 하므로 while 문밖에 scanner 객체를 생성한다
		//while 문안에 있으면 계속 객체되는데 while 문 밖에 있으면 1회만 생성된다.
		ArrayList<User> Users = new ArrayList<User>(); //계정정보를 담아야 하므로
		//User 객체를 담는 Users 이름의 ArrayList 객체 생성.
		
		do {
			System.out.println("=====================");
			System.out.println("1.Sing UP");
			System.out.println("2.Login");
			System.out.println("3.Print All Users");
			System.out.println("4.Exit");
			System.out.println("=====================");
			System.out.print("번호를 입력하시오 : ");
			input = sc.nextInt(); //사용자에게서부터 int 형 값을 입력받는다.
			
			if (input == 1) { //입력 값이 1이라면
				String id,password; //id 와 password 변수를 생성하고
				System.out.print("id : ");
				id = sc.next(); //id 값을 입력받고
				System.out.print("Password : ");
				password = sc.next();//password 값을 입력반는다.
				Users.add(new User(id,password)); //그후 새로운 User 객체를 생성하여 Users ArrayLists 에 넣는다.
				//Users 안에 user 객체가 들어있으므로 인스턴스를 (User us = new ..)를 할 필요가 없다.
				//ArrayLists 에 넣음으로써 id 조회를 할 수 있다.
				
			}
			else if(input == 2) { //입력값이 2 로그인이라면
				String id,password; //id 와 password 변수를 생성하고
				System.out.print("id : ");
				id = sc.next(); //id 값을 입력받고
				System.out.print("Password : ");
				password = sc.next(); //password 값을 입력받는다.
				boolean isLogin = false; //로그인 유무를 하기 위해 3항연산자 사용을 위해 Bollean 타입의 isLogin을 생성한다
				//로그인이 되었으면 true 고 아니면 false 이다.
				for (User user : Users) { //for each 문을 사용하여 Users 배열의 각각 값을 for 문이 돌때마다
					//user 에 할당한다.
					 if((user.userid).equals(id) && (user.password).equals(password)) {
						 //로그인의 조건 id 와 비밀번호가 일치할 경우
						 isLogin = true; //로그인은 성공으로 바꾸고
						 break; //해당 루프는 더 할 필요 없이 종료시킨다.
					 }
				}
				System.out.println((isLogin) ? "로그인 되었습니다." : "로그인에 실패했습니다 .");
				//isLogin 이 true 면 로그인이 된것이므로 로그인이 되었습니다 를 출력한다.
				//아니면 로그인에 실패하였습니다 를 출력한다.
			}
			else if(input == 3) { //입력값이 3이라면
				for (User user : Users) { //for each 문을 통해 Users 배열의 각각 값을 for 문이 돌때마다 user 에 할당한다.
					//user 객체가 가진 userid 와 password 를 출력한다.
					System.out.println("{ " + user.userid + " , " + user.password + "}");
				}
			}
			
			//do while 문 조건중에 4 가 있으므로 else if input==4 then break 는 만들 필요 없다.
			
		}while (input != 4); //해당 do while 문은 input 이 4일때 종료된다.

	}

}
