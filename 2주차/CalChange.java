import java.util.Scanner;

public class CalChange { //���Ǳ⸦ ����� Ŭ����


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); //Scanner Class �� �����ͼ� scan ��ü ����
		int InputMoney, Price, change; //�Է¹�����, ����, �Ž������� ����


		do {

			System.out.print("������ �� : ");
			InputMoney = scan.nextInt(); //scan ��ü�� nextInt �޼ҵ带 ����Ͽ� ���������� �޾ƿ´�.

		} while (InputMoney <= 0); //InputMoney �� 0���� Ŭ������ �ݺ��Ͽ� ������ ������ ���ϰ� �Ѵ�.

		do {

			System.out.print("���ǰ� : ");
			Price = scan.nextInt();//scan ��ü�� nextInt �޼ҵ带 ����Ͽ� ������ ���� �޾ƿ´�.

		} while (InputMoney - Price <= 0);  //�Է��� �� ���� ���ǰ��� �� ũ�� �������� ���ϵ��� �ݺ��Ѵ�.

		change = InputMoney - Price; //�Ž������� ���Աݾ� - �Ž������̴�.
		System.out.println("�Ž����� : " + change); //�Ž�������ϴ� �Ž������� ����Ѵ�.
		System.out.println("500 �� ¥�� ������ ���� : " + change / 500); //500�� ������ �Ž������� 500������ ���� ���̴�
		change %= 500; //500���� �Ž��������Ƿ� ���� �ܾ��� 500������ ���� �������̴�.
		System.out.println("100 �� ¥�� ������ ���� : " + change / 100); //�������� 100���� ������ش�.
	}
}
