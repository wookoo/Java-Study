import java.util.Scanner;

public class findFibo { //�Ǻ���ġ ������ ã�� Ŭ����

	public static void main(String[] args) {

		int term; //���� ������ ������ ���� ����
		Scanner scan = new Scanner(System.in); //Scanner Ŭ������ �����ͼ� scan ��ü�� �����Ѵ�.

		do {
			System.out.print("����� ���� ���� :");
			term = scan.nextInt(); //scan ��ü�� nextInt �޼ҵ带 ����Ͽ� ������ term �� �����Ѵ�.
		} while (term <= 0); //����� ���� ������ 0�̸��̸� �˰����� �۵����� �����Ƿ� 0���� ū �� �Է��ϵ��� do while ���

		int first, tail, result; //�Ǻ���ġ ������ ���� ���� 3�� ����

		first = 0; //ù��, ù���� ���� 0 �̴� (������ ��)
		result = 0; //����� ����, ù���� 0�̹Ƿ� 0���� ����
		tail = 1; //�ι�° ��(���� ��)

		for (int i = 0; i < term; i++) { //term �� ���� �����̹Ƿ� ���� ������ŭ �ݺ�

			System.out.print(result + " "); //�Ǻ���ġ ������ i ��° �� ���
			result = tail; //����� ���� ������ + ������ �ɰ��̰�,
			tail += first; //�������׿� �������� �����ִ°��� ���� ���̴�.
			first = result; //����� ���� ���� ù������ �ٲ��.

		}//for (int i = 0; i < term; i ++)



	}
}
