public class PlusPrimeTwoNum {
	
	public static void main(String[] args) {
		
		int num = 34 ;  //�� �Ҽ��� ���� ���� �� ����

		for (int i = 2; i < num; i ++) { //num - 1 ���� �ݺ��Ͽ� �� ���� �ȿ� �ִ� �Ҽ����� ���Ѵ�.
			if (CheckPrime(i)) { //checkPrime �Լ��� ����Ͽ� �Ҽ����� ���Ѵ�
				//��ȯ���� �� ���� �ۿ� ����
				//i �� �Ҽ��� �Ʒ� �ڵ尡 ����ȴ�
				for (int j = 2; j < num ; j ++) { //j �� 2 ~ num -1 ���� �ݺ��Ͽ� �Ҽ� ������ �ѹ� �� ã�´�
					if (CheckPrime(j) && j + i == num) { //j �� �Ҽ��� i �� j �� ���� ���� num �̸� 
						System.out.println(num + " = " + i + " + " + j); //�ΰ� ���� ���� ���
						//�� �ܰ�� ���� i �� ������ �Ҽ�
					}

				}//for (int j = 2; j < num ; j ++)
				
			}//if (CheckPrime(i))
		}
	}
	
	
	public static boolean CheckPrime(int num) { //�Ҽ����� �ƴ��� �Ǻ��� �޼ҵ� ����, 2�� �̻� ����ϱ� ������ �Լ��� �����.
		
		Boolean isPrime = true; //is Prime 

		for (int i = 2 ; i < num ; i ++) { //2~�ڱ� �ڽ� - 1 ���� ������ ������ ���������� �ȶ��������� �Ǻ��ؾ� ��
			
			if (num%i == 0) { //num �� i �� �������� ���� �������� �װ� �Ҽ��� �ƴϴ� 
				isPrime = false; //�׷��Ƿ� isPrime �� �������� �ٲ۴�
				break; //���̻� �� ��ġ�� �����Ƿ� break �� �ɾ� for ���� Ż��
			}
			
		}
		return isPrime; //��ȯ���� boolean �̹Ƿ� �� ���� ��ȯ�� ���ش�.
	}

}

