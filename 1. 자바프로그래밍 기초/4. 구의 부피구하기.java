

/* 문제
 * 구의 반지름을 입력받아서 부피를 계산해보자.
 */

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double r;
		System.out.print("구의 반지름 : ");
		r = sc.nextDouble();
		System.out.println("구의 부피 : "+ (r*r*r*4/3));
	}
}
