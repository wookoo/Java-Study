public class CheckPrimeUseWhile {
	
	public static void main(String args[]) { //c ���� main �Լ��� ���� ������ �ϴ� main �޼ҵ� ����
		
		int num = 29; //�Ҽ����� �ƴ��� �Ǻ��� �� 
		Boolean isPrime = true; //is Prime 
		
		if (num == 1) { //1�� �Ҽ��̹Ƿ� main �޼ҵ� ����
			System.out.println("���� " + num +" ��  �Ҽ� �Դϴ�"); 
			return;
		}
		
		int i = 2; //while ������ ������ ���� ���� ���� 
		while (i < num) { //2~�ڱ� �ڽ� - 1 ���� ������ ������ ���������� �ȶ��������� �Ǻ��ؾ� ��
			if (num%i == 0) { //num �� i �� �������� ���� �������� �װ� �Ҽ��� �ƴϴ� 
				isPrime = false; //�׷��Ƿ� isPrime �� �������� �ٲ۴�
				
				break; //���̻� �� ��ġ�� �����Ƿ� break �� �ɾ� while ���� Ż��
			}
			i++; //while ���� ������ �� i �� 1�� �����ش� 
		}
		System.out.println("���� " + num +" ��  "+ (isPrime ? "�Ҽ� �Դϴ�": "�Ҽ��� �ƴմϴ�") ); 
		//3�� �����ڸ� ����Ͽ� isPrime �� ���̸� "�Ҽ��Դϴ�" ��� �����̸� "�Ҽ��� �ƴմϴ�" ���
	}

}
