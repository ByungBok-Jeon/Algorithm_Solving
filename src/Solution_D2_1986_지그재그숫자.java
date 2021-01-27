
/* D2.1986. 지그재그 숫자
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PxmBqAe8DFAUq&categoryId=AV5PxmBqAe8DFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D2_1986_지그재그숫자 {

	static int T, N;

	static boolean isEven(int n) {
		if (n % 2 == 1) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if (!isEven(i)) {
					sum += i;
				} else {
					sum -= i;
				}
			}
			System.out.printf("#%d %d\n", t, sum);

		}
	}

}
