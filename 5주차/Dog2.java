import java.util.ArrayList;

class Witch{
	public static void younger(Dog2 obj) { //static �޼ҵ�� ����Ͽ� new �������
		//witch.younger �� ����Ҽ� �ְ� �����.
		obj.Age -= 5; //obj �� ��ü�̹Ƿ� ��ü�� �Լ��� �޾������� call by reference �̹Ƿ�
		//���� Age �� �����ȴ�.
	}
}

public class Dog2 {
	String Name; //String �� Name Field ����
	int Age; //int �� Age Field ����
	String Color; //String �� Color Field ����
	static int count = 0; //int �� count Field ����, �������� �����Ѵ�.
	//�������� �����ϸ� ���� �Ѱ��� �����Ѵ�.

	public Dog2(String Name,int Age,String Color) {//������ ���� �ʰ� �����ڷ� ���� �޴´�.
		this.Name = Name; //���ڷ� ���� Name �� Name �ʵ忡 ����
		this.Age = Age; //���ڷ� ���� Age �� Age �ʵ忡 ����
		this.Color = Color; //���ڷ� ���� Color �� Color �ʵ忡 ���� 
		count ++; //�������� count �� 1 ������Ų��.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog2 puppy1 = new Dog2("Molly",10,"Brown"); //Molly 10 Brown �� ���� Dog2 ��ü puppy1 �� �����Ѵ�.
		Dog2 puppy2 = new Dog2("Daisy",6,"Black"); //"Daisy",6,"Black" �� ���� Dog2 ��ü puppy2 �� �����Ѵ�.
		Dog2 puppy3 = new Dog2("Bella",7,"White"); //"Bella",7,"White" �� ���� DOg2 ��ü puppy3 �� �����Ѵ�.


		ArrayList<Dog2> DogLists = new ArrayList<Dog2>(); //3�� �ݺ��Ͽ� ���/witch ����� ���� Dog2 �� ��� �迭 ���� 
		DogLists.add(puppy1); //DogLists �� puppy 1 2 3 �� �߰��Ѵ�.
		DogLists.add(puppy2);
		DogLists.add(puppy3);
		
		for (Dog2 Dogs:DogLists) { //for each ���� ����Ͽ� DogLists ��� �ϳ��ϳ��� Dogs �� �Ҵ��Ѵ�. 
			Witch.younger(Dogs); //������ Dogs �� witch Ŭ������ younger �޼ҵ带 ����Ͽ�
			//���� Age �� �����Ѵ�.
		}
		for (Dog2 Dogs:DogLists) { //for each ���� ����Ͽ� Doglists ��� �ϳ��ϳ��� Dogs �� �Ҵ��Ѵ�.
			//�Ҵ��� Dogs �� ���� Name Age Color �ʵ带 ����Ѵ�.
			System.out.println(Dogs.Name +" , " + Dogs.Age +" , "+ Dogs.Color);
		}
		
	}

}
