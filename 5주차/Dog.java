public class Dog { //���� Ŭ���� ����
	String Name; //String �� Name Field ����
	int Age; //int �� Age Field ����
	String Color; //String �� Color Field ����
	static int count = 0; //int �� count Field ����, �������� �����Ѵ�.
	//�������� �����ϸ� ���� �Ѱ��� �����Ѵ�.

	public Dog(String Name,int Age,String Color) { //������ ���� �ʰ� �����ڷ� ���� �޴´�.
		this.Name = Name; //���ڷ� ���� Name �� Name �ʵ忡 ����
		this.Age = Age; //���ڷ� ���� Age �� Age �ʵ忡 ����
		this.Color = Color; //���ڷ� ���� Color �� Color �ʵ忡 ���� 
		count ++; //�������� count �� 1 ������Ų��.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog puppy1 = new Dog("Molly",10,"Brown"); //Molly 10 Brown �� ���� Dog ��ü puppy1 �� �����Ѵ�.
		Dog puppy2 = new Dog("Daisy",6,"Black"); //"Daisy",6,"Black" �� ���� Dog ��ü puppy2 �� �����Ѵ�.
		Dog puppy3 = new Dog("Bella",7,"White"); //"Bella",7,"White" �� ���� DOg ��ü puppy3 �� �����Ѵ�.
		System.out.println("������� ������ ������ �� = " + Dog.count);
		//�����ڰ� ȣ�� �Ǹ� ��, ��ü�� �����Ǹ� Dog ��ü�� ���� Count ������ ���� ������ �����ϰ� �ǹǷ� 3�� ��µȴ�.
		
	}
}