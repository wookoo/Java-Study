public class Rectangle {
	int x,y,w,h; //x y w h �ʵ� ����
	void setX(int x) { //x �� ���ڷ� �޴´� �ʵ��� x �� ����
		this.x = x; //x �� ���ڷ� �޾ұ⿡ �ʵ� x ���� ���� x ���� �����ϱ����� this ���
	}
	void setY(int y) {//y �� ���ڷ� �޴´� �ʵ��� y �� ����
		this.y = y;//y �� ���ڷ� �޾ұ⿡ �ʵ� y ���� ���� y ���� �����ϱ����� this ���
	}
	void setW(int w) {//w �� ���ڷ� �޴´� �ʵ��� w �� ����
		this.w = w;//w �� ���ڷ� �޾ұ⿡ �ʵ� w ���� ���� w ���� �����ϱ����� this ���
	}
	void setH(int h) {//h �� ���ڷ� �޴´� �ʵ��� h �� ����
		this.h = h;//h �� ���ڷ� �޾ұ⿡ �ʵ� h ���� ���� h ���� �����ϱ����� this ���
	}
	int getArea() {//������ ���ϴ� �޼ҵ�
		return this.w*this.h; //�ʵ峻�� w �� h �� ���Ͽ� ��ȯ�Ѵ�.
	}
	void print() {//�簢���� ������ ����ϴ� �޼ҵ�
		System.out.println(String.format("���� ���� :%d\n���α��� : %d\n�ʺ� : %d", w,h,w*h)); 
		//Ŭ�������� w h �ʵ带 ����Ͽ� ���
		System.out.println(String.format("x��ǥ :%d\ny��ǥ : %d", x,y));
		//Ŭ���� ���� x y �ʵ� ���
	}
	public static void main(String[] args) {
		Rectangle rec = new Rectangle(); //Rectangle Ŭ������ rec ��ü�� �Ҵ�
		rec.setW(30); //rec ��ü�� setW �� ����Ͽ� w ����
		rec.setH(50);//rec ��ü�� setH�� ����Ͽ� h ����
		rec.setX(5); //rec ��ü�� setX�� ����Ͽ� x ����
		rec.setY(6); //rec ��ü�� setY�� ����Ͽ� y ����
		System.out.println(rec.getArea()); //rec ��ü�� getArea �޼ҵ�� ��ȯ�� �ǹǷ� �� �� ���
		rec.print();//rec ��ü�� ���� ������ ����ϴ� print �޼ҵ� ȣ��
	}
	
}
