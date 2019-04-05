public class FindSolution { //방정식의 해를 찾는 클래스

	public static void main(String[] args) {

		for (int x = 0; x <= 10; x++) { //x 의 값을 찾기위한 for 문

			for (int y = 0; y <= 10; y++) { //y 값도 있으므로 2중 for 문을 사용한다

				if ((3 * x) + (10 * y) == 100) { // 3x + 10y 가 100 이면 
					System.out.println(String.format("( %d , %d )", x, y)); //x y 값을 출력한다

				}

			}//for (int y = 0; y <= 10; y++)

		}//for (int x = 0 ; x <= 10 ; x++)

	}

}
