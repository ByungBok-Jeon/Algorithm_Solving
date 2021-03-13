
/* D3.1215. 회문1
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV14QpAaAAwCFAYi&categoryId=AV14QpAaAAwCFAYi&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1 
 * SW Expert Acadamy 문제
 */

import java.util.Scanner;

public class Solution_D3_1215_회문1 {
	static int T = 10;
	static char[][] map;
	static int n;
	static int ans;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			n = scan.nextInt();
			ans = 0;
			map = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String s = scan.next();
				for (int j = 0; j < 8; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			palindrome();
			System.out.println("#" + t + " " + ans);
		}
		scan.close();
	}
	static void palindrome() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (check(i, j + n - 1)) {
					boolean checkC = true;
					for (int k = 0; k < n / 2; k++) {
						if (map[i][j + k] != map[i][j + n - 1 - k]) {
							checkC = false;
							break;
						}
					}
					if (checkC) {
						ans++;
					}
				}
				if (check(i + n - 1, j)) {
					boolean checkR = true;
					for (int k = 0; k < n / 2; k++) {
						if (map[i + k][j] != map[i + n - 1 - k][j]) {
							checkR = false;
							break;
						}
					}
					if (checkR) {
						ans++;
					}
				}
			}
		}
	}
	static boolean check(int r, int c) {
		return r < 8 && c < 8;
	}
}
