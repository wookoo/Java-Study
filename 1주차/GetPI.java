public class GetPI {
	
	public static void main(String[] args) {
		
		double pi = 3.0; //ó���� 3 ���� �����ؾ� �Ѵ�
		double plus; //�Ҽ��� �ڸ��� ���� ���� ����

		for (int i = 1; i < 1000; i ++) { //1000ȸ �ݺ��Ѵ�
			
			
			// �и�� 2n * 2n + 1 * 2n + 2 �̴� 
			plus = ( (2*i) )*( (2*i) +1 )*( (2*i)+2 );
			
			//���ϴ� ���� 4 �� �� ���� ���� 2n * 2n +1 * 2n+2 �� ������ �Ѵ�.
			plus = 4 / plus;
			
			//i �� ¦����  ���� ���� ���� �ϹǷ� plus �� - �� ���δ�
			if ( i % 2  == 0) {
				plus = -plus;
			}

			pi += plus; //��� ������ ������ pi �� plus �� �����ش�

		}
		
		System.out.println("�������� : " + pi); //���� ���� ����Ѵ�.
		
		
	}

}
