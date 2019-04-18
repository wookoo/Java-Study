class Person{ //추상클래스 Person 을 정의한다
	String name; //String 필드로 name 할당
	int id; //int 필드로 id 할당
	public Person(String name, int id) { //생성자를 정의한다. name 과 id 를 매개변수로 받는다.
		this.name = name;  //받은 name 과 id 를 필드에 할당한다.
		this.id = id;
	}
	void printInfo() { //name 과 id 를 출력하는 메소드를 정의한다,
		System.out.print(String.format("name = %s, id = %d,", this.name,this.id));
	}
	int getId() { //id 를 가져오는 getter 생성
		return this.id;
	}
	String getName() { //name 을 가져오는 getter 생성
		return this.name;
	}
}

class Student extends Person{ //student 클래스를 정의한다. person 을 상속받아온다.
	//person 을 받아왔기에 name id 와 같은 필드 메소드 모두 포함한다.
	double gpa; //학점 필드를 추가로 생성.
	int credits; //이수학점 필드를 추가로 생성
	public Student(String name,int id, double gpa, int credits) {
		super(name,id); //부모 클래스의 생성자를 호출하여 name 과 id 필드에 값을 넣어준다.
		this.gpa = gpa;
		this.credits = credits;
	}
	
	@Override
	void printInfo() { //부모클래스에서 정의한 printInfo 메소드의 내용을 오버라이딩 하여 수정한다.
		super.printInfo(); //부모클래스인 person 에서 만든 printInfo 를 수행하고
		System.out.println(String.format(" gpa = %.1f, credits = %d", this.gpa,this.credits ));
		//성적, 이수학점등도 추가해서 출력해준다.
	}
}

class Employee extends Person{ //Employee 클래스를 정의한다. person 을 상속받아온다.
	//person 을 받아왔기에 name id 와 같은 필드 메소드 모두 포함한다.
	int salary; //영업이익 필드를 추가로 생성
	int years; //근무년수 필드를 추가로 생성한다.
	public Employee(String name, int id, int salary, int years) {
		super(name,id); //부모 클래스의 생성자를 호출하여 name 과 id 필드에 값을 넣어준다.
		this.salary = salary; //Employee 클래스에서 정의한 salary 와 year 필드에 매개변수로 받은 salary year 할당.
		this.years = years;
	}
	@Override
	void printInfo() {//부모클래스에서 정의한 printInfo 메소드의 내용을 오버라이딩 하여 수정한다.
		super.printInfo();//부모클래스인 person 에서 만든 printInfo 를 수행하고
		System.out.println(String.format(" salary = %d, years = %d", this.salary,this.years ));
		//영업이익, 근무년수 등을 추가로 출력해준다.
	}
}

public class PersonTest {

	public static void main(String[] args) {
		Student student1 = new Student("steve jobs",1,3.9,30); //Student 인스턴스 student 1 을 생성하고 Student 객체를 생성한다.
		Employee employee1 = new Employee("Jeff Bezos",2,10000,10); //Employee 인스턴스 employeeN 을 생성하고 Employee 객체를생성한다. 
		Employee employee2 = new Employee("Bill Gates",3,20000,15);
		Employee employee3 = new Employee("steve jobs",4,30000,20);
		Person[] obj = {student1, employee1, employee2, employee3}; //Person 이 부모클래스이므로 Person 클래스를 담는 obj 리스트 생성한다.
		String SearchName = "steve jobs"; //찾을려는 이름
		for (Person instance : obj) { //for each 문을 사용하여 for 문이 돌때마다 obj 요소 하나하나가 instance 가 된다.
			if (SearchName.equals(instance.getName())) { //만약 찾을려는 이름과, instance 의 name 이 일치할경우
				instance.printInfo(); //출력해준다.
			}
		}
	
	}
}
