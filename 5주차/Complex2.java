public class Complex2 {//Complex 클래스를 생성
	double real,imag;//double 타입의 정수부 real, 허수부 imag 필드를 생성한다.
	public Complex2(double real,double imag) {//double 형의 real 과 imag 를 인자로 받는다, 
		//생성자이므로 호출 즉시 인자로 넣어야 된다.
		this.real = real; //인자로 받은 real 을 complex 클래스의 real 필드에 할당한다.
		this.imag = imag; //인자로 받은 imag 를 complex 클래스의 imag 필드에 할당한다.
	}
	public Complex2 add(Complex2 o1, Complex2 o2) { //Complex2 객체를 반환하는 add 메소드 생성
		//인자로는 Complex2 형의 o1, Complex2 형의 o2 를 받는다.
		Complex2 temp = new Complex2(o1.real+o2.real,o1.imag+o2.imag);
		//반환할 COmplex2 객체 temp 생성, 이 객체는 각각 o1 o2 가 가진 real, o1 o2가 가진 imag 를 더해서
		//1번쨰 2번째 인자로 넣어준다,
		return temp; //temp 객체가 생성되었으므로 반환을 해준다.
		
	}
	
	public static void main(String[] args) {
		Complex2 C1 = new Complex2(10,20); //complex 클래스를 가진 C1 객체를 생성한다. 
		//이 객체는 real 은 10 imag 는 20 이라는 값 (필드)를 갖는다

		Complex2 C2 = new Complex2(30,40);//complex 클래스를 가진 C2 객체를 생성한다. 
		//이 객체는 real 은 30 imag 는 40 이라는 값 (필드)를 갖는다
		
		Complex2 C3 = C1.add(C1, C2);//static 메소드가 아니기 때문에 이미 생성된
		//C1 객체를 사용하여 add 메소드를 호출한다.
		//그 후 출력을 하면 된다.
		System.out.print("("+C1.real + "+" + C1.imag + "i) 와"); //print 를 사용하여 개행을 하지 않는다
		System.out.print("("+C2.real + "+" + C2.imag + "i)를 더하면"); 
		System.out.println("(" + C3.real + "+" + C3.imag + "i) 가 됨");
	}
}
