import java.util.ArrayList;

class Witch{
	public static void younger(Dog2 obj) { //static 메소드로 사용하여 new 연산없이
		//witch.younger 를 사용할수 있게 만든다.
		obj.Age -= 5; //obj 는 객체이므로 객체를 함수로 받았을때는 call by reference 이므로
		//원본 Age 가 수정된다.
	}
}

public class Dog2 {
	String Name; //String 형 Name Field 생성
	int Age; //int 형 Age Field 생성
	String Color; //String 형 Color Field 생성
	static int count = 0; //int 형 count Field 생성, 정적으로 선언한다.
	//정적으로 선언하면 변수 한개를 공유한다.

	public Dog2(String Name,int Age,String Color) {//오류가 나지 않게 생성자로 값을 받는다.
		this.Name = Name; //인자로 받은 Name 을 Name 필드에 저장
		this.Age = Age; //인자로 받은 Age 을 Age 필드에 저장
		this.Color = Color; //인자로 받은 Color 을 Color 필드에 저장 
		count ++; //정적변수 count 를 1 증가시킨다.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog2 puppy1 = new Dog2("Molly",10,"Brown"); //Molly 10 Brown 을 가진 Dog2 객체 puppy1 을 생성한다.
		Dog2 puppy2 = new Dog2("Daisy",6,"Black"); //"Daisy",6,"Black" 을 가진 Dog2 객체 puppy2 를 생성한다.
		Dog2 puppy3 = new Dog2("Bella",7,"White"); //"Bella",7,"White" 을 가진 DOg2 객체 puppy3 을 생성한다.


		ArrayList<Dog2> DogLists = new ArrayList<Dog2>(); //3개 반복하여 출력/witch 사용을 위한 Dog2 를 담는 배열 생성 
		DogLists.add(puppy1); //DogLists 에 puppy 1 2 3 를 추가한다.
		DogLists.add(puppy2);
		DogLists.add(puppy3);
		
		for (Dog2 Dogs:DogLists) { //for each 문을 사용하여 DogLists 요소 하나하나를 Dogs 에 할당한다. 
			Witch.younger(Dogs); //가져온 Dogs 를 witch 클래스의 younger 메소드를 사용하여
			//원본 Age 를 조절한다.
		}
		for (Dog2 Dogs:DogLists) { //for each 문을 사용하여 Doglists 요소 하나하나를 Dogs 에 할당한다.
			//할당한 Dogs 가 가진 Name Age Color 필드를 출력한다.
			System.out.println(Dogs.Name +" , " + Dogs.Age +" , "+ Dogs.Color);
		}
		
	}

}
