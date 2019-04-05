public class Rectangle {
	int x,y,w,h; //x y w h 필드 생성
	void setX(int x) { //x 를 인자로 받는다 필드의 x 값 설정
		this.x = x; //x 를 인자로 받았기에 필드 x 인지 인자 x 인지 구분하기위해 this 사용
	}
	void setY(int y) {//y 를 인자로 받는다 필드의 y 값 설정
		this.y = y;//y 를 인자로 받았기에 필드 y 인지 인자 y 인지 구분하기위해 this 사용
	}
	void setW(int w) {//w 를 인자로 받는다 필드의 w 값 설정
		this.w = w;//w 를 인자로 받았기에 필드 w 인지 인자 w 인지 구분하기위해 this 사용
	}
	void setH(int h) {//h 를 인자로 받는다 필드의 h 값 설정
		this.h = h;//h 를 인자로 받았기에 필드 h 인지 인자 h 인지 구분하기위해 this 사용
	}
	int getArea() {//면적을 구하는 메소드
		return this.w*this.h; //필드내의 w 와 h 를 곱하여 반환한다.
	}
	void print() {//사각형의 정보를 출력하는 메소드
		System.out.println(String.format("가로 길이 :%d\n세로길이 : %d\n너비 : %d", w,h,w*h)); 
		//클래스내의 w h 필드를 사용하여 출력
		System.out.println(String.format("x좌표 :%d\ny좌표 : %d", x,y));
		//클래스 내의 x y 필드 출력
	}
	public static void main(String[] args) {
		Rectangle rec = new Rectangle(); //Rectangle 클래스를 rec 객체에 할당
		rec.setW(30); //rec 객체에 setW 를 사용하여 w 설정
		rec.setH(50);//rec 객체에 setH를 사용하여 h 설정
		rec.setX(5); //rec 객체에 setX를 사용하여 x 설정
		rec.setY(6); //rec 객체에 setY를 사용하여 y 설정
		System.out.println(rec.getArea()); //rec 객체에 getArea 메소드는 반환만 되므로 그 값 출력
		rec.print();//rec 객체가 가진 정보를 출력하는 print 메소드 호출
	}
	
}
