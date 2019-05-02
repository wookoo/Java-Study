class Author {
	private String name; //문제에서 요구한 String 타입의 name 필드 생성, private 로 작성하라 했으므로 private
	private String email;//문제에서 요구한 String 타입의 email 필드 생성, private 로 작성하라 했으므로 private
	private char gender;//문제에서 요구한 char 타입의 gender 필드 생성, private 로 작성하라 했으므로 private
	public Author(String name, String email, char gender) {
		//힌트 예제코드에서 new 키워드를 통해  Author에 값이 들어가므로, 그에 맞는 생성자 생성
		this.name = name; //받아온 name 을 name 필드에 할당
		this.email = email; //받아온 email 을 email 필드에 할당
		this.gender = gender; //받아온 gender 을  gender 필드에 할당
	}
	
	//---------------getter setter 선언부---------------
	public String getName() { //public 메소드여야 다른 클래스에서 접근이 가능하다.
		return this.name; //private 로 선언된 필드이므로 getter 를 통해 다른 클래스에서 접근하도록 설정
	}
	public String getEmail() {//public 메소드여야 다른 클래스에서 접근이 가능하다.
		return email;//private 로 선언된 필드이므로 getter 를 통해 다른 클래스에서 접근하도록 설정
	}
	public char getGender() {//public 메소드여야 다른 클래스에서 접근이 가능하다.
		return gender;//private 로 선언된 필드이므로 getter 를 통해 다른 클래스에서 접근하도록 설정
	}
	//---------------getter setter 선언부 끝----------------
	
}

class Book{
	private String name; //문제에서 요구한 String 타입의 name 필드 생성, private 로 작성하라 했으므로 private
	private Author[] authors;//문제에서 요구한 Author배열의 authors 필드 생성, private 로 작성하라 했으므로 private
	private double price;
	private int qty = 0;
	
	public Book(String name,Author[] authors,double price) {
		//qty 가 들어오지 않을 경우의 생성자 이다.
		this.name = name; //받아온  name 을 name 필드에 할당
		this.authors = authors; //받아온 authors 을 authors 필드에 할당
		this.price = price; //받아온 price 을 price 필드에 할당.
	}
	public Book(String name,Author[] authors,double price,int qty) {
		//qty 도 들어오는 경우의 생성자, 메소드 오버로딩임.
		this.name = name;//받아온  name 을 name 필드에 할당
		this.authors = authors; //받아온 authors 을 authors 필드에 할당
		this.price = price; //받아온 price 을 price 필드에 할당.
		this.qty = qty; //받아온 qty 을 qty 필드에 할당
	}
	//--------getter setter 선언부, getter 는 모두 public 자료형, setter 는 모두 public void-----------
	public String getName() {
		return name;
	}
	public Author[] getAuthors() {
		return authors;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	//---------getter setter 선언부 ---------
	
	//System.out.println(new Book(...)); 을 실행하면
	//System.out.println(new Book(...).toString()); 을 호출한것과 같다.
	public String toString() {
		String temp = "Book[name=" + this.getName() + ",authors={Author";; //반환할 String의 기초자료생성
	
		for (int i = 0; i < authors.length; i++) {
			//authors 의 마지막인 경우가 아니면 , 로 author 정보를 더 보여줘야된다.
			if (i != authors.length-1) {
				temp += "[name="+authors[i].getName()+",email="+authors[i].getEmail()
						+",gender=" + authors[i].getGender()+"],";
			}
			//authors 의 마지막인 경우면  ,를 붙이지 않고 author 의 마지막 정보임을 보여줘야 한다.
			else {
				temp += "[name="+authors[i].getName()+",email="+authors[i].getEmail()
						+",gender=" + authors[i].getGender()+"]";
			}
		}
		//for 문이 정상적으로 수행됬으면, Author 에 대한 정보가 temp 에 저장된다.
		
		//문제에서 요구한 price 와 qty 등을 설정한다.
		//getter 을 사용한다! > 실수로 데이터 수정을 하는 경우를 막을수 있다.
		temp += "},price=" + this.getPrice() + ",qty="+this.getQty()+"]";
		return temp;
				
	}
	
	public String getAuthorNames() {
		String temp = "";//반환할 String 선언
		for(int i =0; i <authors.length; i ++) {
			if (i != authors.length-1) {
				//authors 에 마지막 경우가 아니면 , 를 추가하여 정보를 추가 기술
				temp += authors[i].getName() + ",";
			}
			else {
				//마지막 경우면 ,가 더이상 필요 없음
				temp += authors[i].getName();
			}
		}
		return temp;
	}
	
}

public class Main {
	public static void main(String[] args) {
		Author[] authors = new Author[2];
		authors[0] = new Author("Tan An Teck","AhTeck@somewhere.com",'m');
		authors[1] = new Author("Paul Tan","Paul@nowhere.com",'m');
		//public Book(String name,Author[] authors,double price,int qty) 생성자 호출 
		Book javaDummy = new Book("Java for Dummy",authors,19.99,99);
		
		System.out.println(javaDummy+"\n"); //자동으로 toString 메소드가 호출된다.
		
		Author[] myAuthor = {new Author("바나나맨","banana@bana.na",'m'),new Author("사과맨","apple@app.le",'m'),new Author("포도우먼","Grape@po.do",'F')};
		//public Book(String name,Author[] authors,double price) 생성자 호출
		Book myBook = new Book("새로운 책!",myAuthor,19); //
		System.out.println(myBook);
		System.out.println("저자들 = "+myBook.getAuthorNames()); //저자들의 정보를 출력
		myBook.setQty(10); //10으로 qty 를 설정해본다.
		System.out.println("qty는 "+myBook.getQty()+"으로 설정되었음!");
		
		System.out.print("price는 "+myBook.getPrice()+"에서 ");
		myBook.setPrice(8); //19로 설정된 price 를 8로 설정해본다.
		System.out.println(myBook.getPrice()+"으로 설정되었음!");
		System.out.println(myBook);
		
		System.out.println("\n20184071 김도현");
	}

}
