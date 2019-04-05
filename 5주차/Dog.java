public class Dog { //도그 클래스 생성
	String Name; //String 형 Name Field 생성
	int Age; //int 형 Age Field 생성
	String Color; //String 형 Color Field 생성
	static int count = 0; //int 형 count Field 생성, 정적으로 선언한다.
	//정적으로 선언하면 변수 한개를 공유한다.

	public Dog(String Name,int Age,String Color) { //오류가 나지 않게 생성자로 값을 받는다.
		this.Name = Name; //인자로 받은 Name 을 Name 필드에 저장
		this.Age = Age; //인자로 받은 Age 을 Age 필드에 저장
		this.Color = Color; //인자로 받은 Color 을 Color 필드에 저장 
		count ++; //정적변수 count 를 1 증가시킨다.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog puppy1 = new Dog("Molly",10,"Brown"); //Molly 10 Brown 을 가진 Dog 객체 puppy1 을 생성한다.
		Dog puppy2 = new Dog("Daisy",6,"Black"); //"Daisy",6,"Black" 을 가진 Dog 객체 puppy2 를 생성한다.
		Dog puppy3 = new Dog("Bella",7,"White"); //"Bella",7,"White" 을 가진 DOg 객체 puppy3 을 생성한다.
		System.out.println("현재까지 생성된 강아지 수 = " + Dog.count);
		//생성자가 호출 되면 즉, 객체가 생성되면 Dog 객체가 가진 Count 변수는 정적 변수라 공유하게 되므로 3이 출력된다.
		
	}
}