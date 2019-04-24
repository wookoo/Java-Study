

/* 문제
 * 1 부터 100사이의 정수에서 3또는 4의 배수의 합을 계산해보자
 */


public class Main {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i <= 100; i ++) {
			if(i %3 ==0) {
				sum += i;
			}
			if (i % 4==0 && i%3 !=0) {
				sum +=i;
			}
		}
		System.out.println("3또는 4 배수의 합 : "+sum);
	}
}
