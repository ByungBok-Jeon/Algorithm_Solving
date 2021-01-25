
/* D1.1545. 거꾸로 출력해 보아요
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2gbY0qAAQBBAS0&categoryId=AV2gbY0qAAQBBAS0&categoryType=CODE
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D1_1545_거꾸로출력해보아요 {
	static int n;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		for (int i = n; i >= 0; i--) {
			System.out.printf("%d ", i);
		}

	}

}
