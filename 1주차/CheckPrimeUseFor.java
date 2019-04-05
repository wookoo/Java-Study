public class CheckPrimeUseFor {
	
	public static void main(String args[]) { //c 언어에서 main 함수와 같은 역할을 하는 main 메소드 생성
		
		int num = 29; //소수인지 아닌지 판별할 수 
		Boolean isPrime = true; //is Prime 
		

		for (int i = 2 ; i < num ; i ++) { //2~자기 자신 - 1 까지 했을때 나누어 떨어지는지 안떨어지는지 판별해야 함
			if (num%i == 0) { //num 을 i 로 나눴을때 나눠 떨어지면 그건 소수가 아니다 
				isPrime = false; //그러므로 isPrime 을 거짓으로 바꾼다
				break; //더이상 할 가치가 없으므로 break 를 걸어 for 루프 탈출
			}
		}
		System.out.println("숫자 " + num +" 은  "+ (isPrime ? "소수 입니다": "소수가 아닙니다") ); 
		//3항 연산자를 사용하여 isPrime 이 참이면 "소수입니다" 출력 거짓이면 "소수가 아닙니다" 출력
	}

}
