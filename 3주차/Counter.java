public class Counter { //ī���� Ŭ���� ����
	int counter; //ī���� �ʵ� ����
	void up() { 
		counter ++; //counter Ŭ���� ���� counter �ʵ� �� ����
	}
	int getCount() {
		return counter; //counter Ŭ���� ���� counter �ʵ� ��ȯ�ϴ� �޼ҵ�
	}
	
	public static void main(String[] args) {
		Counter cn = new Counter(); //cn ��ü�� ���ο� counter Ŭ������ �Ҵ�
		cn.up(); //counter Ŭ������ up �޼ҵ� ��� ���� 1�̵�, �ʱ�ȭ�� �⺻ 0
		cn.up(); //counter Ŭ������ up �޼ҵ� ��� ���� 2�� �ȴ�
		System.out.println(cn.getCount()); //cn��ü�� ���� getCount �޼ҵ带 ����Ͽ� �� �� ���
	}
}
