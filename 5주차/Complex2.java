public class Complex2 {//Complex Ŭ������ ����
	double real,imag;//double Ÿ���� ������ real, ����� imag �ʵ带 �����Ѵ�.
	public Complex2(double real,double imag) {//double ���� real �� imag �� ���ڷ� �޴´�, 
		//�������̹Ƿ� ȣ�� ��� ���ڷ� �־�� �ȴ�.
		this.real = real; //���ڷ� ���� real �� complex Ŭ������ real �ʵ忡 �Ҵ��Ѵ�.
		this.imag = imag; //���ڷ� ���� imag �� complex Ŭ������ imag �ʵ忡 �Ҵ��Ѵ�.
	}
	public Complex2 add(Complex2 o1, Complex2 o2) { //Complex2 ��ü�� ��ȯ�ϴ� add �޼ҵ� ����
		//���ڷδ� Complex2 ���� o1, Complex2 ���� o2 �� �޴´�.
		Complex2 temp = new Complex2(o1.real+o2.real,o1.imag+o2.imag);
		//��ȯ�� COmplex2 ��ü temp ����, �� ��ü�� ���� o1 o2 �� ���� real, o1 o2�� ���� imag �� ���ؼ�
		//1���� 2��° ���ڷ� �־��ش�,
		return temp; //temp ��ü�� �����Ǿ����Ƿ� ��ȯ�� ���ش�.
		
	}
	
	public static void main(String[] args) {
		Complex2 C1 = new Complex2(10,20); //complex Ŭ������ ���� C1 ��ü�� �����Ѵ�. 
		//�� ��ü�� real �� 10 imag �� 20 �̶�� �� (�ʵ�)�� ���´�

		Complex2 C2 = new Complex2(30,40);//complex Ŭ������ ���� C2 ��ü�� �����Ѵ�. 
		//�� ��ü�� real �� 30 imag �� 40 �̶�� �� (�ʵ�)�� ���´�
		
		Complex2 C3 = C1.add(C1, C2);//static �޼ҵ尡 �ƴϱ� ������ �̹� ������
		//C1 ��ü�� ����Ͽ� add �޼ҵ带 ȣ���Ѵ�.
		//�� �� ����� �ϸ� �ȴ�.
		System.out.print("("+C1.real + "+" + C1.imag + "i) ��"); //print �� ����Ͽ� ������ ���� �ʴ´�
		System.out.print("("+C2.real + "+" + C2.imag + "i)�� ���ϸ�"); 
		System.out.println("(" + C3.real + "+" + C3.imag + "i) �� ��");
	}
}
