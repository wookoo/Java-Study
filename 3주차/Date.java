public class Date {
	int year,month,day; //Ŭ������ �ʵ� year month day ����
	void setYear(int year) { //year �� ���ڷ� �޴´� �ʵ��� year �� ����
		this.year = year; //�ʵ��� year , ������ year �� �������� this ���
	}
	void setMonth(int month) {//month �� ���ڷ� �޴´� �ʵ��� month �� ����
		this.month = month;//�ʵ��� month , ������ month �� �������� this ���
	}
	void setDay(int day) {//day �� ���ڷ� �޴´� �ʵ��� day �� ����
		this.day = day;//�ʵ��� day, ������ day ������ ���� this ���
	}
	
	void print1() {
		System.out.println(this.year + "." + this.month + "." + this.day);
		//Date Ŭ������ year month day �ʵ� ���
	}
	
	void print2() {
		String MonthEng = null; //switch Case ������ ����� �ٲٱ� ���� String ���� ����
		switch (this.month) { //switch ������ month �ʵ带 ������ �Ǻ��Ѵ�.
		case 1:
			MonthEng = "January"; //1���̸� montheng ����
			break;
	
		case 2:
			MonthEng = "February "; //2���̸� montheng ����, ���������� 12���̸� ���� ����
			break;
		case 3:
			MonthEng = "March";
			break;
		case 4:
			MonthEng = "April";
			break;
		case 5:
			MonthEng = "May";
			break;
		case 6:
			MonthEng = "June";
			break;
		case 7:
			MonthEng = "July";
			break;
		case 8:
			MonthEng = "August";
			break;
		case 9:
			MonthEng = "September";
			break;
		case 10:
			MonthEng = "October";
			break;
		case 11: 
			MonthEng = "November";
			break;
		case 12:
			MonthEng = "December";
			break;
		
		}
		System.out.println(MonthEng + " " +this.day +","+ this.year); //switch ���� ��������
		//monthEng ������ day �ʵ� year �ʵ� ���
	}
	

	
	public static void main(String[] args) {
		Date dt= new Date(); //dt ��ü�� Date Ŭ���� �Ҵ�
		dt.setDay(12); //dt ��ü�� ���� setDay �޼ҵ� ����Ͽ� day �ʵ带 12 �� ����
		dt.setMonth(12);//dt ��ü�� ���� setMonth �޼ҵ� ����Ͽ� month �ʵ带 12 �� ����
		dt.setYear(2019);//dt ��ü�� ���� setYear �޼ҵ� ����Ͽ� year �ʵ带 22019 �� ����
		dt.print1();//dt ��ü�� ���� print1 �޼ҵ� ȣ��
		dt.print2();//dt ��ü�� ���� print2 �޼ҵ� ȣ��
	}
}
