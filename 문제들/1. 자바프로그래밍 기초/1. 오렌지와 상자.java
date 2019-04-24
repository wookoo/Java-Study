


/* 문제
 *
 * 하나의 상자에 오렌지를 10개씩 담을수 있다고 하자.
 * 오렌지가 n개 있다면, 상자 몇개가 필요할까?
 * 또, 상자 몇개가 남을까?
 */

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("오렌지의 갯수를 입력하세요 : ");
		n = sc.nextInt();
		int boxes = n/10;
		int remainer = n%10;
		System.out.println(String.format("%d박스가 필요하고 %d개가 남습니다.", boxes,remainer));
	}
}
