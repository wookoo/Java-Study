public class PrintVariables {
	
	public static void main(String arg[]) {//c 언어에서 main 함수와 같은 역할을 하는 main 메소드 생성
		
		int myNum = 10; //int 형 변수 myNum 샌성
		float myFloatNum = 3.145f; //float 형 변수 myFloatNum 생성, 변수 뒤에 f 를 붙여야한다
		char myLetter = 'A'; // char 형 변수 myletter 생성 
		boolean myBool = true; //참 거짓을 판별하는 myBool 변수 생성
		String myString = "HelloWorld"; //문자열을 뜻하는 변수 String 형 myString 생성
		
		System.out.println("myNum = " + myNum); //int 형 변수 출력
		System.out.println("myFloatNum = " + myFloatNum); //float 형 변수 출력
		System.out.println("myLetter = " + myLetter); //char 형 변수 출력
		System.out.println("myBool = " + myBool); //boolean 형 변수 출력
		System.out.println("myString = " + myString); //String 형 변수 출력
		
	}
}
