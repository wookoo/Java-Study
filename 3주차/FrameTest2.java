import javax.swing.JFrame;

public class FrameTest2 {
	public static void main(String[] args) {
		JFrame frm1 = new JFrame("������ 1 ��"); //frm1 �� JFrame �� �Ҵ�, �����ڰ� �����Ӹ��� �ʿ��ϹǷ�
		//�����Ҷ� �����ڿ� ���� ���ڸ� �־��ش�.
		int x1,y1,x2,y2; //â�� �����̴µ� �ʿ��� x1 y1 x2 y2 ���� ����
		x1 = 30;//�⺻�� �����
		y1 = 20;
		x2 = 30;
		y2 = 280;
		
		frm1.setSize(300,200); //frm1 ��ü�� ũ�⸦ �����ְ�
		frm1.setLocation(x1,y1); //��ġ ���� �����ش�
		frm1.setVisible(true); //�� �� �������� �����Ѵ�.
		
		JFrame frm2 = new JFrame("������ 2��");//frm2 �� JFrame �� �Ҵ�, �����ڰ� �����Ӹ��� �ʿ��ϹǷ�
		//�����Ҷ� �����ڿ� ���� ���ڸ� �־��ش�.
		
		frm2.setSize(300,200); //frm1 �� �ٸ��Ƿ� setSize �޼ҵ带 ���� ũ�� ����
		frm2.setLocation(x2, y2); //��ġ�� �������ش�.
		frm2.setVisible(true); //�������� �����Ѵ�
		
		try { //thread �� sleep ���¿��� ������ ���� �����Ƿ� try catch �� �� ������ �濩�Ѵ�.
			while (x1 < 900 || x2 < 900) { //�� â�� ��ǥ 2���� 900�� ���� ���������� �ݺ��Ѵ�.
				x1 +=(int)(Math.random()*40) +1; //math��random �޼ҵ带 ����� *40 �� ���� 1 ������ 
				//1~41 ���� ������ �����Ѵ�. ���� math.random �� ��ȯ���� double �̹Ƿ� int �� ����ȯ�� ���ش�.
				x2 += (int)(Math.random()*40)+ 1;
				Thread.sleep(100);//0.1�� ����
				System.out.println(x1 +","+x2); //����׿� x1 x2 ��ǥ ���
				frm1.setLocation(x1, y1); //���� �ٲ�� frm1 �� ���� �ٲ۴�
				frm2.setLocation(x2,y2); //���������� frm2 �� x ���� �ٲ۴�.
			}
		//	frm1.setVisible(false);
		//	frm2.setVisible(false);
			//System.out.println(x1>x2);
			System.out.println((x1 > x2 ? "1�� ������" : "2�� ������") + "�¸�"); //while �� ������ ��� 3�� �����ڸ� ����Ͽ� ���ʿ��� �ҽ��� �����Ѵ�.
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
}
