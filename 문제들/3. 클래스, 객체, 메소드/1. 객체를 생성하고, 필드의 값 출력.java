/*
 * 문제
 *
 * 클래스의 객체를 생성하고 필드를 10과 1.2345 로 초기화 후, 출력하기
 */

class NumberBox{
	public int ivalue;
	public float fvalue;
}

public class Main {
	public static void main(String[] args) {
		NumberBox numbox = new NumberBox();
		numbox.ivalue = 10;
		numbox.fvalue = 1.2345F;
		System.out.println("ivalue : " + numbox.ivalue);
		System.out.println("fvalie : " + numbox.fvalue);
	}

}
