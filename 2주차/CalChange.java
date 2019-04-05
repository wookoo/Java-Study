import java.util.Scanner;

public class CalChange { //자판기를 만드는 클래스


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); //Scanner Class 를 가져와서 scan 객체 생성
		int InputMoney, Price, change; //입력받은돈, 가격, 거스름돈을 설정


		do {

			System.out.print("투입한 돈 : ");
			InputMoney = scan.nextInt(); //scan 객체의 nextInt 메소드를 사용하여 정수형값을 받아온다.

		} while (InputMoney <= 0); //InputMoney 가 0보다 클떄까지 반복하여 음수가 들어오지 못하게 한다.

		do {

			System.out.print("물건값 : ");
			Price = scan.nextInt();//scan 객체의 nextInt 메소드를 사용하여 정수형 값을 받아온다.

		} while (InputMoney - Price <= 0);  //입력한 돈 보다 물건값이 더 크게 설정하지 못하도록 반복한다.

		change = InputMoney - Price; //거스름돈은 투입금액 - 거스름돈이다.
		System.out.println("거스름돈 : " + change); //거슬러줘야하는 거스름돈을 출력한다.
		System.out.println("500 원 짜리 동전의 갯수 : " + change / 500); //500원 갯수는 거스름돈을 500원으로 나눈 몫이다
		change %= 500; //500원을 거슬러줬으므로 남은 잔액은 500원으로 나눈 나머지이다.
		System.out.println("100 원 짜리 동전의 갯수 : " + change / 100); //나머지를 100으로 출력해준다.
	}
}
