
/* D4.3234. 준환이의양팔저울
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw&categoryId=AWAe7XSKfUUDFAUw&categoryType=CODE&problemTitle=%EC%A4%80%ED%99%98&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D4_3234_준환이의양팔저울 {
	static int T, N;
	static int[] weights;
	static boolean[] v;
	static int ans;
	static int others;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			v = new boolean[N];
			weights = new int[N];
			ans = 0;
			others = 0;
			for (int i = 0; i < N; i++) {
				weights[i] = scan.nextInt();
				others += weights[i];
			}
			go(0, 0, 0);
			System.out.println("#" + t + " " + ans);
		}
		scan.close();
	}

	static void go(int cnt, int l, int r) {
		if (cnt == N) {
			ans++;
			return;
		}
		if (others <= 2 * l) {
			int multiple = 1;
			int factorial = 1;
			if (N - cnt == 0)
				factorial = 0;
			for (int i = 1; i <= N - cnt; i++) {
				multiple *= 2;
			}
			for (int i = 1; i <= N - cnt; i++) {
				factorial *= i;
			}
			ans += multiple * factorial;

			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i])
				continue;
			v[i] = true;
			int weight = weights[i];
			go(cnt + 1, l + weight, r);
			if (r + weight <= l)
				go(cnt + 1, l, r + weight);
			v[i] = false;
		}
	}
}
