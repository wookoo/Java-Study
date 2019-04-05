import java.util.Scanner;

public class SortedNum { //숫자를 정렬하는 클래스

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);//Scanner Class 를 가져와서 scan 객체 생성

		int first, second, third; //입력받을 변수 세개 선언

		System.out.print("정수를 입력하세요 : ");
		first = scan.nextInt(); //scan 객체의 nextInt 메소들 사용하여 정수를 first 에 저장
		System.out.print("정수를 입력하세요 : ");
		second = scan.nextInt(); //scan 객체의 nextInt 메소들 사용하여 정수를 second 에 저장
		System.out.print("정수를 입력하세요 : ");
		third = scan.nextInt(); //scan 객체의 nextInt 메소들 사용하여 정수를 third 에 저장

		if (first >= second && second >= third) { //1 번 2 번 3 번째 숫자로 큰 경우
			System.out.println(String.format("정렬된 숫자 : %d %d %d", first, second, third));
			//문자열 포맷팅 사용하여 출력

		}
		else if (first >= third && third >= second) { //1번 3 번 2 번째 숫자로 큰 경우
			System.out.println(String.format("정렬된 숫자 : %d %d %d", first, third, second));
			//문자열 포맷팅 사용하여 출력

		}

		else if (second >= first && first >= third) { //2번 1번 3 번째 숫자로 큰 경우
			System.out.println(String.format("정렬된 숫자 : %d %d %d", second, first, third));
			//문자열 포맷팅 사용하여 출력
		}
		else if (second >= third && third >= first) { //2번째 3번째 1번째 숫자로 큰 경우
			System.out.println(String.format("정렬된 숫자 : %d %d %d", second, first, third));
			//문자열 포맷팅 사용하여 출력
		}
		else if (third >= first && first >= second) { //3번째 1번째 2번째 숫자로 큰 경우 
			System.out.println(String.format("정렬된 숫자 : %d %d %d", third, first, second));
			//문자열 포맷팅 사용하여 출력
		}
		else { //그 외인 3 번째 2번째 1번째로 큰 경우
			System.out.println(String.format("정렬된 숫자 : %d %d %d", third, second, first));
			//문자열 포맷팅 사용하여 출력
		}
	}

}
