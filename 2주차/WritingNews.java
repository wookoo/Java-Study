import java.util.Scanner;

public class WritingNews { //������ �ۼ��ϴ� Ŭ����
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); //Scanner Class �� �����ͼ� scan ��ü ����
		System.out.print("������� ����Դϱ� ? : ");
		String Ground = scan.nextLine(); //scan ��ü�� nextLine �޼ҵ带 ����Ͽ� ����(String)�� �Է¹޴´�.
		//�� ���� Ground �� �����Ѵ�

		System.out.print("�̱����� ����Դϱ� ? : ");
		String Winner = scan.nextLine();//scan ��ü�� nextLine �޼ҵ带 ����Ͽ� ����(String)�� �Է¹޴´�.
		//�� ���� Winner �� �����Ѵ�.

		System.out.print("�� ���� ����Դϱ� ? : ");
		String Loser = scan.nextLine(); //scan ��ü�� nextLine �޼ҵ带 ����Ͽ� ����(String)�� �Է¹޴´�.
		//�� ���� Loser �� �����Ѵ�.

		System.out.print("��������� �����Դϱ� ? : ");
		String MVP = scan.nextLine();//scan ��ü�� nextLine �޼ҵ带 ����Ͽ� ����(String)�� �Է¹޴´�.
		//�� ���� MVP �� �����Ѵ�.

		System.out.print("���ھ�� ���� �Դϱ�? : ");
		String Score = scan.nextLine(); //scan ��ü�� nextLine �޼ҵ带 ����Ͽ� ����(String)�� �Է¹޴´�.
		//�� ���� Score �� �����Ѵ�.

		System.out.println("===============================");
		System.out.println(String.format("���� %s ���� �߱� ��Ⱑ ���Ƚ��ϴ�", Ground)); //���ڿ� �������� ����Ͽ� ��� ���
		System.out.println(String.format("%s �� %s �� ġ���� �������� ���ƽ��ϴ�.", Winner, Loser)); //���ڿ� �������� ����Ͽ� ���� ���� ���
		System.out.println(String.format("%s �� ��Ȱ���� �Ͽ����ϴ�", MVP)); //���ڿ� �������� ����Ͽ� MVP ��� 
		System.out.println(String.format("�ᱹ %s �� %s �� %s �� �̰���ϴ�.", Winner, Loser, Score)); //���ڿ� �������� ����Ͽ� ���� ���� ���ھ� ���
		System.out.print("===============================");

	}

}
