
/* D3.11387. 몬스터 사냥
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXb6LR76vCcDFARR&categoryId=AXb6LR76vCcDFARR&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */

import java.util.Scanner;

public class Solution_D3_11387_몬스터사냥 {
	static int T;
	static int D, L, N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			D = scan.nextInt();
			L = scan.nextInt();
			N = scan.nextInt();
			int ans = 0;
			for (int i = 0; i < N; i++) {
				ans += D * (1.0 + L * i * 0.01);
			}
			System.out.println("#" + t + " " + ans);
		}
		scan.close();
	}
}
