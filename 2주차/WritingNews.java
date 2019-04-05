import java.util.Scanner;

public class WritingNews { //뉴스를 작성하는 클래스
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); //Scanner Class 를 가져와서 scan 객체 생성
		System.out.print("경기장은 어디입니까 ? : ");
		String Ground = scan.nextLine(); //scan 객체의 nextLine 메소드를 사용하여 한줄(String)을 입력받는다.
		//그 값을 Ground 에 저장한다

		System.out.print("이긴팀은 어디입니까 ? : ");
		String Winner = scan.nextLine();//scan 객체의 nextLine 메소드를 사용하여 한줄(String)을 입력받는다.
		//그 값을 Winner 에 저장한다.

		System.out.print("진 팀은 어디입니까 ? : ");
		String Loser = scan.nextLine(); //scan 객체의 nextLine 메소드를 사용하여 한줄(String)을 입력받는다.
		//그 값을 Loser 에 저장한다.

		System.out.print("우수선수는 누구입니까 ? : ");
		String MVP = scan.nextLine();//scan 객체의 nextLine 메소드를 사용하여 한줄(String)을 입력받는다.
		//그 값을 MVP 에 저장한다.

		System.out.print("스코어는 몇대몇 입니까? : ");
		String Score = scan.nextLine(); //scan 객체의 nextLine 메소드를 사용하여 한줄(String)을 입력받는다.
		//그 값을 Score 에 저장한다.

		System.out.println("===============================");
		System.out.println(String.format("오늘 %s 에서 야구 경기가 열렸습니다", Ground)); //문자열 포맷팅을 사용하여 장소 출력
		System.out.println(String.format("%s 과 %s 은 치열한 공방전을 펼쳤습니다.", Winner, Loser)); //문자열 포맷팅을 사용하여 승자 패자 출력
		System.out.println(String.format("%s 이 맹활약을 하였습니다", MVP)); //문자열 포맷팅을 사용하여 MVP 출력 
		System.out.println(String.format("결국 %s 가 %s 를 %s 로 이겼습니다.", Winner, Loser, Score)); //문자열 포맷팅을 사용하여 승자 패자 스코어 출력
		System.out.print("===============================");

	}

}
