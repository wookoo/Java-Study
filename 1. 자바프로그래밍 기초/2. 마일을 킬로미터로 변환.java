

/* 문제
 * 마일을 킬로미터로 변환하는 프로그램을 작성하라
 * 1마일은 1.609 킬로미터와 같다. 사용자로부터 마일의 값을 읽어드린다.
 */

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double miles;
		System.out.print("마일을 입력하세요 : ");
		miles = sc.nextDouble();
		System.out.println(String.format("%.2f 마일은 %.2f 킬로미터 입니다.", miles,miles*1.609));

	}
}
