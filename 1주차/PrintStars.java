public class PrintStars { //자바는 클래스에서 작동되므로 클래스 선언
	
	public static void main(String arg[]) { //c 언어에서 main 함수와 같은 역할을 하는 main 메소드 생성
		System.out.println("     *"); //println 하면 자동으로 개행된다
		System.out.print("    ***\n"); // print 를 하면 자동으로 개행되지 않으므로 개행문자를 넣어준다.
		System.out.println("   ***"
				+ "**"); // + 연산자를 사용하여 String 이 길 경우 짤라서 사용도 가능하다
		System.out.print("  ***"
				+ "****\n"); //print 메소드도 마찬가지로 + 연산자를 사용하여 나눠쓸수 있다.
		System.out.println("   *****");
		System.out.println("    ***");
		System.out.println("     *");
	}

}
