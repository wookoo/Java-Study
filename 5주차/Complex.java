public class Complex {//Complex Ŭ������ ����
	double real,imag; //double Ÿ���� ������ real, ����� imag �ʵ带 �����Ѵ�.
	public Complex(double real,double imag) { //double ���� real �� imag �� ���ڷ� �޴´�, 
		//�������̹Ƿ� ȣ�� ��� ���ڷ� �־�� �ȴ�.
		this.real = real; //���ڷ� ���� real �� complex Ŭ������ real �ʵ忡 �Ҵ��Ѵ�.
		this.imag = imag; //���ڷ� ���� imag �� complex Ŭ������ imag �ʵ忡 �Ҵ��Ѵ�.
	}
	public static void main(String[] args) {
		Complex C1 = new Complex(10,20); //complex Ŭ������ ���� C1 ��ü�� �����Ѵ�. 
		//�� ��ü�� real �� 10 imag �� 20 �̶�� �� (�ʵ�)�� ���´�.
		System.out.println(C1.real + "+" + C1.imag + "i");
		//C1 �� ���� real �� imag �� ����Ѵ�.
	}
}
