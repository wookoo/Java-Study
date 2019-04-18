class Circle{ //추상클래스 Circle 을 정의한다.
	private double radius; //double 필드로 radius 할당
	private String color; //String 필드로 color 할당
	

	public Circle() { //메소드 오버로딩을 통해 생성자의 매개변수가 다른 경우를 설정해준다
		//이 경우엔 매개변수가 없는 경우
		this.radius = 1.0; // radius 필드 를 1 로 만들고
		this.color = "red"; //color 필드를 red 로 만든다.
	}
	public Circle(double radius) {
		//매개변수가 radius 하나인 경우
		this.radius = radius; //radius 필드를 받아온 radius 로 설정해주고
		this.color = "red"; //color 필드를 red 로 만든다.
	}
	public Circle(double radius, String color) {
		//매개변수가 radius , color 인 경우
		this.radius = radius; //radius 필드로 받아온 radius 로 설정해주고
		this.color = color; //color 필드로 받아온 color 를 설정해준다
	}
	
	
	//-------------------getter setter 추가하는 부분----------------------------------
	public double getRadius() { 
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getArea() { //면적을 계산해서 반환해준다.
		return this.radius *this.radius * 3.14;
	}
	
	//------------------getter setter 추가하는 부분 끝------------------------------
	public String toString() { //circle 객체를 출력하는 메소드 > 한줄로 명확히 표기하는 메소드 
		
		return String.format("Circle[radius=%.3f,color=%s]", this.radius,this.color);
		
	}
		
}

class Pizza extends Circle{ //circle 이라는 클래스를 받아온다.
	//circle 클래스가 가진 모든 method 와 field 를 다 가져온다.
	private String type; //String type 필드 추가 생성
	private int price; //int price 필드 추가 생성
	public Pizza() { //매개 변수가 없는 경우
		 //아무것도 수행하지 않는다 > 자동으로 생성자가 type 은 null 로 만들고 price 는 0 으로 만든다.
		//super() 도 묵시적으로 호출되므로 radius = 1, color = red 가 된다.
	}
	public Pizza(String type,int price,double radius) { //매개변수로 반지름도 받아온 경우
		
		super(radius); //circle 클래스의 radius 만 들어가는 메소드 > double 형 변수 1개만 들어가는 경우다.  
		this.type = type; //pizza 클래스의 type/price 필드에 받아온 type/price 할당
		this.price = price;
	}
	
	public void print(){ //피자의 정보를 출력하는 메소드
		System.out.println(String.format("Price = %d$, Type = %s, Radius = %.2f, Area = %.2f", this.price,this.type,this.getRadius(),this.getArea()));
		//가격, 타입, 반지름, 면적을 출력
	}
	public String getType() {
		return this.type;
		//타입을 가져오는 getter 생성
	}
}


public class PizzaTest {
	
	public static void main(String[] args) {
		Pizza combination = new Pizza("콤비네이션",30,20); //combination 인스턴스에 Pizza("콤비네이션",30,20) 객체를 생성해서 할당
		Pizza potato = new Pizza("포테이토",10,5);//potato 인스턴스에 Pizza("포테이토",10,5) 객체를 생성해서 할당
		Pizza nonePizza = new Pizza(); //nonePizza 인스턴스에 아무것도 설정 안해주는 그냥 Pizza() 객체를 생성해서 할당
		combination.print(); //combination, potato, nonePizza 의 인스턴스가 가진 print 메소드 호출해서 정보를 출력
		potato.print();
		nonePizza.print();
		Pizza bigger = Bigger(combination,potato); //Bigger 메소드를 호출하여 combination potato 중 무슨 피자가 큰지 확인
		System.out.println(String.format("%s 피자가 더 큽니다. 반지름 : = %.2f", bigger.getType(), bigger.getRadius()));
		//무슨 피자가 더 큰지랑 반지름도 출력해준다.
	}
	
	public static  Pizza Bigger(Pizza p1, Pizza p2) { //무슨 피자가 더 큰지 확인하는 메소드. Pizza 객체 2개를 받고 Pizza 형으로 반환한다.
		return (p1.getRadius()> p2.getRadius() ? p1 : p2); //p1 의 반지름이 크면 p1 의 반지름이 작으면 p2 를 반환해준다.
		
	}
	
	
	

}
