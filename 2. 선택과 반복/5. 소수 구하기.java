

/* 문제
 * 2와 100사이에 있는 모든 소수를 출력하라!
 */

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		System.out.print("2에서 100까지 모든 소수 : ");
		for (int n = 2; n <=100; n++) {
			boolean isPrime = true;
			for(int j = 2; j <n; j++) {
				if(n%j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.print(n + " ");
			}
		}

	}
}
