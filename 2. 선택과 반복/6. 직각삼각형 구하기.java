

/* 문제
 * 각 변의 길이가 100보다 작은 삼각형 중에서, 직각삼각형을 찾아라!
 */

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		for (int a = 1; a <= 100; a++) {
			for(int b = 1; b<= 100; b++) {
				for(int c = 1; c<=100; c++) {
					if(a*a + b*b == c*c) {
						System.out.println(a +" " + b +" "+c);
						break; //a b c 순서쌍은 1개만 있으므로 break 를 해준다.
					}
				}
			}
		}

	}
}
