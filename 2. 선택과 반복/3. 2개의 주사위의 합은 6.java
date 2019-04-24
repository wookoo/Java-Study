

/* 문제
 * 두개의 주사위 눈이 합이 6이 되는 순서쌍을 출력하라!
 */

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		for(int i =1; i <=6; i++) {
			for (int j =1; j <=6; j++) {
				if(i + j == 6) {
					System.out.print("("+i+","+j+"),");
				}
			}
		}

	}
}
