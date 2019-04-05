public class Date {
	int year,month,day; //클래스의 필드 year month day 생성
	void setYear(int year) { //year 를 인자로 받는다 필드의 year 값 설정
		this.year = year; //필드의 year , 인자의 year 을 구분위해 this 명시
	}
	void setMonth(int month) {//month 를 인자로 받는다 필드의 month 값 설정
		this.month = month;//필드의 month , 인자의 month 을 구분위해 this 명시
	}
	void setDay(int day) {//day 를 인자로 받는다 필드의 day 값 설정
		this.day = day;//필드의 day, 인자의 day 구분을 위해 this 명시
	}
	
	void print1() {
		System.out.println(this.year + "." + this.month + "." + this.day);
		//Date 클래스의 year month day 필드 출력
	}
	
	void print2() {
		String MonthEng = null; //switch Case 문에서 출력을 바꾸기 위한 String 변수 선언
		switch (this.month) { //switch 문에서 month 필드를 가지고 판별한다.
		case 1:
			MonthEng = "January"; //1월이면 montheng 변경
			break;
	
		case 2:
			MonthEng = "February "; //2월이면 montheng 변경, 마찬가지로 12월이면 까지 진행
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
		System.out.println(MonthEng + " " +this.day +","+ this.year); //switch 문이 끝났으면
		//monthEng 변수와 day 필드 year 필드 출력
	}
	

	
	public static void main(String[] args) {
		Date dt= new Date(); //dt 객체에 Date 클래스 할당
		dt.setDay(12); //dt 객체가 가진 setDay 메소드 사용하여 day 필드를 12 로 변경
		dt.setMonth(12);//dt 객체가 가진 setMonth 메소드 사용하여 month 필드를 12 로 변경
		dt.setYear(2019);//dt 객체가 가진 setYear 메소드 사용하여 year 필드를 22019 로 변경
		dt.print1();//dt 객체가 가진 print1 메소드 호출
		dt.print2();//dt 객체가 가진 print2 메소드 호출
	}
}
