
/* D1.2027. 대각선 출력하기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QFuZ6As0DFAUq&categoryId=AV5QFuZ6As0DFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */
public class Solution_D1_2027_대각선출력하기 {

	static void print(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					System.out.print("#");
				} else {
					System.out.print("+");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		print(5);
	}

}
