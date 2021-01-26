/* D2.1926. 간단한 369게임
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PTeo6AHUDFAUq&categoryId=AV5PTeo6AHUDFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */

import java.util.Scanner;

public class Solution_D2_1926_간단한369게임 {
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			String aa = Integer.toString(i);
			for (int j = 0; j < aa.length(); j++) {
				if (aa.charAt(j) == '3' || aa.charAt(j) == '6' || aa.charAt(j) == '9') {
					cnt++;
				}
			}
			if (cnt == 0) {
				System.out.print(i + " ");
			} else {
				String s = "";
				for (int j = 0; j < cnt; j++) {
					s += "-";
				}
				System.out.print(s + " ");
			}

		}
	}

}
