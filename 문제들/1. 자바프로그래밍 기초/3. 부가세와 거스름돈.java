


/* 문제
 * 영수증에는 10% 부가세와 잔돈 등이 인쇄되어있다.
 * 구입한 상품의 가격과 손님한테 받은 금액을 입력하면, 부가세와 잔돈을 출력해보자.
 */

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int getMoney,price,change;
		System.out.print("받은 돈 : ");
		getMoney = sc.nextInt();
		System.out.print("상품 가격 : ");
		//상품 가격이 받은 돈 보다 큰 경우는 배제한다.
		price = sc.nextInt();
		System.out.println("부가세 : " + price/10);
		System.out.println("잔돈 : " + (getMoney - price));
	}
}
