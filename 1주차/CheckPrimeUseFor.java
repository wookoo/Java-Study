public class CheckPrimeUseFor {
	
	public static void main(String args[]) { //c ���� main �Լ��� ���� ������ �ϴ� main �޼ҵ� ����
		
		int num = 29; //�Ҽ����� �ƴ��� �Ǻ��� �� 
		Boolean isPrime = true; //is Prime 
		

		for (int i = 2 ; i < num ; i ++) { //2~�ڱ� �ڽ� - 1 ���� ������ ������ ���������� �ȶ��������� �Ǻ��ؾ� ��
			if (num%i == 0) { //num �� i �� �������� ���� �������� �װ� �Ҽ��� �ƴϴ� 
				isPrime = false; //�׷��Ƿ� isPrime �� �������� �ٲ۴�
				break; //���̻� �� ��ġ�� �����Ƿ� break �� �ɾ� for ���� Ż��
			}
		}
		System.out.println("���� " + num +" ��  "+ (isPrime ? "�Ҽ� �Դϴ�": "�Ҽ��� �ƴմϴ�") ); 
		//3�� �����ڸ� ����Ͽ� isPrime �� ���̸� "�Ҽ��Դϴ�" ��� �����̸� "�Ҽ��� �ƴմϴ�" ���
	}

}
