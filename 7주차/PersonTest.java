class Person{
	String name;
	int id;
	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}
	void printInfo() {
		System.out.print(String.format("name = %s, id = %d,", this.name,this.id));
	}
	int getId() {
		return this.id;
	}
	String getName() {
		return this.name;
	}
}

class Student extends Person{
	double gpa;
	int credits;
	public Student(String name,int id, double gpa, int credits) {
		super(name,id);
		this.gpa = gpa;
		this.credits = credits;
	}
	
	@Override
	void printInfo() {
		super.printInfo();
		System.out.println(String.format(" gpa = %.1f, credits = %d", this.gpa,this.credits ));
	}
}

class Employee extends Person{
	int salary;
	int years;
	public Employee(String name, int id, int salary, int years) {
		super(name,id);
		this.salary = salary;
		this.years = years;
	}
	@Override
	void printInfo() {
		super.printInfo();
		System.out.println(String.format(" salary = %d, years = %d", this.salary,this.years ));
	}
}

public class PersonTest {

	public static void main(String[] args) {
		Student student1 = new Student("steve jobs",1,3.9,30);
		Employee employee1 = new Employee("Jeff Bezos",2,10000,10);
		Employee employee2 = new Employee("Bill Gates",3,20000,15);
		Employee employee3 = new Employee("steve jobs",4,30000,20);
		Person[] obj = {student1, employee1, employee2, employee3};
		String SearchName = "steve jobs";
		for (Person instance : obj) {
			if (SearchName.equals(instance.getName())) {
				instance.printInfo();
			}
		}
	
	}
}
