import java.util.Scanner;

public class SortedNum { //���ڸ� �����ϴ� Ŭ����

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);//Scanner Class �� �����ͼ� scan ��ü ����

		int first, second, third; //�Է¹��� ���� ���� ����

		System.out.print("������ �Է��ϼ��� : ");
		first = scan.nextInt(); //scan ��ü�� nextInt �޼ҵ� ����Ͽ� ������ first �� ����
		System.out.print("������ �Է��ϼ��� : ");
		second = scan.nextInt(); //scan ��ü�� nextInt �޼ҵ� ����Ͽ� ������ second �� ����
		System.out.print("������ �Է��ϼ��� : ");
		third = scan.nextInt(); //scan ��ü�� nextInt �޼ҵ� ����Ͽ� ������ third �� ����

		if (first >= second && second >= third) { //1 �� 2 �� 3 ��° ���ڷ� ū ���
			System.out.println(String.format("���ĵ� ���� : %d %d %d", first, second, third));
			//���ڿ� ������ ����Ͽ� ���

		}
		else if (first >= third && third >= second) { //1�� 3 �� 2 ��° ���ڷ� ū ���
			System.out.println(String.format("���ĵ� ���� : %d %d %d", first, third, second));
			//���ڿ� ������ ����Ͽ� ���

		}

		else if (second >= first && first >= third) { //2�� 1�� 3 ��° ���ڷ� ū ���
			System.out.println(String.format("���ĵ� ���� : %d %d %d", second, first, third));
			//���ڿ� ������ ����Ͽ� ���
		}
		else if (second >= third && third >= first) { //2��° 3��° 1��° ���ڷ� ū ���
			System.out.println(String.format("���ĵ� ���� : %d %d %d", second, first, third));
			//���ڿ� ������ ����Ͽ� ���
		}
		else if (third >= first && first >= second) { //3��° 1��° 2��° ���ڷ� ū ��� 
			System.out.println(String.format("���ĵ� ���� : %d %d %d", third, first, second));
			//���ڿ� ������ ����Ͽ� ���
		}
		else { //�� ���� 3 ��° 2��° 1��°�� ū ���
			System.out.println(String.format("���ĵ� ���� : %d %d %d", third, second, first));
			//���ڿ� ������ ����Ͽ� ���
		}
	}

}
