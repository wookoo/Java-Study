

/* 문제
 * 3x + 10y = 100 을 만족하는 모든 해를 구하자!
 * 여기서 x 와 y 는 정수고, x y 모두 0 보다 크고 10보다 작다.
 */

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		for(int x = 0; x <=10; x++) {
			for (int y = 0; y<=10; y++) {
				if(3*x + 10*y == 100) {
					System.out.println("("+x+","+y+")");
				}
			}
		}

	}
}
