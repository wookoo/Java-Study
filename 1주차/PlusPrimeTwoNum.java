public class PlusPrimeTwoNum {
	
	public static void main(String[] args) {
		
		int num = 34 ;  //두 소수로 할지 말지 값 저장

		for (int i = 2; i < num; i ++) { //num - 1 까지 반복하여 그 범위 안에 있는 소수들을 구한다.
			if (CheckPrime(i)) { //checkPrime 함수를 사용하여 소수인지 구한다
				//반환값이 참 거짓 밖에 없다
				//i 가 소수면 아래 코드가 실행된다
				for (int j = 2; j < num ; j ++) { //j 가 2 ~ num -1 까지 반복하여 소수 구간을 한번 더 찾는다
					if (CheckPrime(j) && j + i == num) { //j 가 소수고 i 와 j 가 더한 값이 num 이면 
						System.out.println(num + " = " + i + " + " + j); //두개 더한 값을 출력
						//전 단계로 인해 i 는 무조건 소수
					}

				}//for (int j = 2; j < num ; j ++)
				
			}//if (CheckPrime(i))
		}
	}
	
	
	public static boolean CheckPrime(int num) { //소수인지 아닌지 판별할 메소드 생성, 2번 이상 사용하기 때문에 함수로 만든다.
		
		Boolean isPrime = true; //is Prime 

		for (int i = 2 ; i < num ; i ++) { //2~자기 자신 - 1 까지 했을때 나누어 떨어지는지 안떨어지는지 판별해야 함
			
			if (num%i == 0) { //num 을 i 로 나눴을때 나눠 떨어지면 그건 소수가 아니다 
				isPrime = false; //그러므로 isPrime 을 거짓으로 바꾼다
				break; //더이상 할 가치가 없으므로 break 를 걸어 for 루프 탈출
			}
			
		}
		return isPrime; //반환값이 boolean 이므로 참 거짓 반환을 해준다.
	}

}

