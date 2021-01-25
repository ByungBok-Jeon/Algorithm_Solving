
/* D1.2043. 서랍의 비밀번호
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QJ_8KAx8DFAUq&categoryId=AV5QJ_8KAx8DFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D1_2043_서랍의비밀번호 {
	static int P, K;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		P = scan.nextInt();
		K = scan.nextInt();

		if (P >= K) {
			System.out.println(P - K + 1);

		} else {
			System.out.println("failed");
		}

	}

}
