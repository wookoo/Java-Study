public class Counter { //카운터 클래스 생성
	int counter; //카운터 필드 생성
	void up() { 
		counter ++; //counter 클래스 내의 counter 필드 값 증가
	}
	int getCount() {
		return counter; //counter 클래스 내의 counter 필드 반환하는 메소드
	}
	
	public static void main(String[] args) {
		Counter cn = new Counter(); //cn 객체에 새로운 counter 클래스를 할당
		cn.up(); //counter 클래스의 up 메소드 사용 값은 1이됨, 초기화는 기본 0
		cn.up(); //counter 클래스의 up 메소드 사용 값은 2가 된다
		System.out.println(cn.getCount()); //cn객체가 가진 getCount 메소드를 사용하여 그 값 출력
	}
}
