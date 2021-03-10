
/* D3.1217. 거듭제곱
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV14dUIaAAUCFAYD&categoryId=AV14dUIaAAUCFAYD&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_1217_거듭제곱 {
	static int T = 10;
	static int N, M, ans;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			scan.nextInt();
			N = scan.nextInt();
			M = scan.nextInt();
			ans = 0;
			pow(N, M, 1);
			System.out.println("#" + t + " " + ans);
		}
		scan.close();
	}

	static void pow(int n, int m, int result) {
		if (m == 0) {
			ans = result;
			return;
		}
		pow(n, m - 1, result * n);
	}
}
