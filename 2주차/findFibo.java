import java.util.Scanner;

public class findFibo { //피보나치 수열을 찾는 클래스

	public static void main(String[] args) {

		int term; //항의 갯수를 저장할 변수 선언
		Scanner scan = new Scanner(System.in); //Scanner 클래스를 가져와서 scan 객체를 생성한다.

		do {
			System.out.print("출력할 항의 갯수 :");
			term = scan.nextInt(); //scan 객체의 nextInt 메소드를 사용하여 정수를 term 에 저장한다.
		} while (term <= 0); //출력할 항의 갯수가 0미만이면 알고리즘이 작동하지 않으므로 0보다 큰 값 입력하도록 do while 사용

		int first, tail, result; //피보나치 수열에 사용될 변수 3개 선언

		first = 0; //첫항, 첫항의 값은 0 이다 (마지막 항)
		result = 0; //출력할 변수, 첫항은 0이므로 0으로 설정
		tail = 1; //두번째 항(다음 항)

		for (int i = 0; i < term; i++) { //term 이 항의 갯수이므로 항의 갯수만큼 반복

			System.out.print(result + " "); //피보나치 수열의 i 번째 항 출력
			result = tail; //출력할 값은 현재항 + 이전항 될것이고,
			tail += first; //마지막항에 이전항을 더해주는것이 다음 항이다.
			first = result; //출력할 항은 이제 첫항으로 바뀐다.

		}//for (int i = 0; i < term; i ++)



	}
}
