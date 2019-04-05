public class GetPI {
	
	public static void main(String[] args) {
		
		double pi = 3.0; //처음은 3 으로 시작해야 한다
		double plus; //소수점 자리를 구할 변수 선언

		for (int i = 1; i < 1000; i ++) { //1000회 반복한다
			
			
			// 분모는 2n * 2n + 1 * 2n + 2 이다 
			plus = ( (2*i) )*( (2*i) +1 )*( (2*i)+2 );
			
			//더하는 값은 4 를 그 전에 구한 2n * 2n +1 * 2n+2 로 나눠야 한다.
			plus = 4 / plus;
			
			//i 가 짝수면  구한 값을 빼야 하므로 plus 에 - 를 붙인다
			if ( i % 2  == 0) {
				plus = -plus;
			}

			pi += plus; //모든 연산이 끝나면 pi 에 plus 를 더해준다

		}
		
		System.out.println("원주율은 : " + pi); //구한 값을 출력한다.
		
		
	}

}
