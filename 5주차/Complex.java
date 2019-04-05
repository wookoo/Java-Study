public class Complex {//Complex 클래스를 생성
	double real,imag; //double 타입의 정수부 real, 허수부 imag 필드를 생성한다.
	public Complex(double real,double imag) { //double 형의 real 과 imag 를 인자로 받는다, 
		//생성자이므로 호출 즉시 인자로 넣어야 된다.
		this.real = real; //인자로 받은 real 을 complex 클래스의 real 필드에 할당한다.
		this.imag = imag; //인자로 받은 imag 를 complex 클래스의 imag 필드에 할당한다.
	}
	public static void main(String[] args) {
		Complex C1 = new Complex(10,20); //complex 클래스를 가진 C1 객체를 생성한다. 
		//이 객체는 real 은 10 imag 는 20 이라는 값 (필드)를 갖는다.
		System.out.println(C1.real + "+" + C1.imag + "i");
		//C1 이 가진 real 과 imag 를 출력한다.
	}
}
