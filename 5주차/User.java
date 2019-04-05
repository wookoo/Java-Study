import java.util.ArrayList;
import java.util.Scanner;

public class User {
	String userid,password; //User Ŭ������ ���� userid �� password ��� �ʵ带 ���´�.
	static int count; //��� user Ŭ������ �����ϴ� static ���� count �� �����Ѵ�.

	public User(String userid,String password) { //String ���� userid, String ���� password ��
		//�������� ���ڷ� �޴´�.
		this.userid = userid; //���ڷ� ���� userid �� �ʵ� userid �� �Ҵ��Ѵ�.
		this.password = password; //���ڷ� ���� password �� �ʵ� password �� �Ҵ��Ѵ�.
		count ++; //�����ڰ� ȣ��ɶ� ���� static int count �� 1�� �����Ѵ�.
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0; //do while �� ����� ���Ḧ ���� input ���� ����
		Scanner sc = new Scanner(System.in); //while ���� ��������  ���� �޾ƾ� �ϹǷ� while ���ۿ� scanner ��ü�� �����Ѵ�
		//while ���ȿ� ������ ��� ��ü�Ǵµ� while �� �ۿ� ������ 1ȸ�� �����ȴ�.
		ArrayList<User> Users = new ArrayList<User>(); //���������� ��ƾ� �ϹǷ�
		//User ��ü�� ��� Users �̸��� ArrayList ��ü ����.
		
		do {
			System.out.println("=====================");
			System.out.println("1.Sing UP");
			System.out.println("2.Login");
			System.out.println("3.Print All Users");
			System.out.println("4.Exit");
			System.out.println("=====================");
			System.out.print("��ȣ�� �Է��Ͻÿ� : ");
			input = sc.nextInt(); //����ڿ��Լ����� int �� ���� �Է¹޴´�.
			
			if (input == 1) { //�Է� ���� 1�̶��
				String id,password; //id �� password ������ �����ϰ�
				System.out.print("id : ");
				id = sc.next(); //id ���� �Է¹ް�
				System.out.print("Password : ");
				password = sc.next();//password ���� �Է¹ݴ´�.
				Users.add(new User(id,password)); //���� ���ο� User ��ü�� �����Ͽ� Users ArrayLists �� �ִ´�.
				//Users �ȿ� user ��ü�� ��������Ƿ� �ν��Ͻ��� (User us = new ..)�� �� �ʿ䰡 ����.
				//ArrayLists �� �������ν� id ��ȸ�� �� �� �ִ�.
				
			}
			else if(input == 2) { //�Է°��� 2 �α����̶��
				String id,password; //id �� password ������ �����ϰ�
				System.out.print("id : ");
				id = sc.next(); //id ���� �Է¹ް�
				System.out.print("Password : ");
				password = sc.next(); //password ���� �Է¹޴´�.
				boolean isLogin = false; //�α��� ������ �ϱ� ���� 3�׿����� ����� ���� Bollean Ÿ���� isLogin�� �����Ѵ�
				//�α����� �Ǿ����� true �� �ƴϸ� false �̴�.
				for (User user : Users) { //for each ���� ����Ͽ� Users �迭�� ���� ���� for ���� ��������
					//user �� �Ҵ��Ѵ�.
					 if((user.userid).equals(id) && (user.password).equals(password)) {
						 //�α����� ���� id �� ��й�ȣ�� ��ġ�� ���
						 isLogin = true; //�α����� �������� �ٲٰ�
						 break; //�ش� ������ �� �� �ʿ� ���� �����Ų��.
					 }
				}
				System.out.println((isLogin) ? "�α��� �Ǿ����ϴ�." : "�α��ο� �����߽��ϴ� .");
				//isLogin �� true �� �α����� �Ȱ��̹Ƿ� �α����� �Ǿ����ϴ� �� ����Ѵ�.
				//�ƴϸ� �α��ο� �����Ͽ����ϴ� �� ����Ѵ�.
			}
			else if(input == 3) { //�Է°��� 3�̶��
				for (User user : Users) { //for each ���� ���� Users �迭�� ���� ���� for ���� �������� user �� �Ҵ��Ѵ�.
					//user ��ü�� ���� userid �� password �� ����Ѵ�.
					System.out.println("{ " + user.userid + " , " + user.password + "}");
				}
			}
			
			//do while �� �����߿� 4 �� �����Ƿ� else if input==4 then break �� ���� �ʿ� ����.
			
		}while (input != 4); //�ش� do while ���� input �� 4�϶� ����ȴ�.

	}

}
