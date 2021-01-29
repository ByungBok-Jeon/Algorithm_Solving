
/* D2.1284. 수도 요금 경쟁
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV189xUaI8UCFAZN&categoryId=AV189xUaI8UCFAZN&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=3
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D2_1284_수도요금경쟁 {
	static int T, P, Q, R, S, W;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			P = scan.nextInt();
			Q = scan.nextInt();
			R = scan.nextInt();
			S = scan.nextInt();
			W = scan.nextInt();

			int aPrice = P * W;
			int bPrice = 0;
			if (W <= R) {
				bPrice = Q;
			} else {
				bPrice = Q + S * (W - R);
			}
			System.out.printf("#%d %d\n", t, Math.min(aPrice, bPrice));

		}

	}

}
