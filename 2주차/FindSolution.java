public class FindSolution { //�������� �ظ� ã�� Ŭ����

	public static void main(String[] args) {

		for (int x = 0; x <= 10; x++) { //x �� ���� ã������ for ��

			for (int y = 0; y <= 10; y++) { //y ���� �����Ƿ� 2�� for ���� ����Ѵ�

				if ((3 * x) + (10 * y) == 100) { // 3x + 10y �� 100 �̸� 
					System.out.println(String.format("( %d , %d )", x, y)); //x y ���� ����Ѵ�

				}

			}//for (int y = 0; y <= 10; y++)

		}//for (int x = 0 ; x <= 10 ; x++)

	}

}
