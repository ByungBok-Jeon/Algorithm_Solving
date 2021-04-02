
/* D3.6913. 동철이의프로그래밍대회
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWicMVWKTuMDFAUL&categoryId=AWicMVWKTuMDFAUL&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=3
 * SW Expert Acadamy 문제
 */

import java.util.Scanner;

public class Solution_D3_6913_동철이의프로그래밍대회 {
	static int T;
	static int n,m;
	static int[][] map;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			n = scan.nextInt();
			m = scan.nextInt();
			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			int max = 0;
			int maxPeople = 0;
			for (int i = 0; i < n; i++) {
				int cnt = 0;
				for (int j = 0; j < m; j++) {
					if(map[i][j] == 1) {
						cnt++;
					}
				}
				if(max<cnt) {
					max = cnt;
					maxPeople = 1;
				}else if(max==cnt) {
					maxPeople++;
				}
			}
			System.out.println("#"+t+ " " +maxPeople+" " + max);
		}
		scan.close();
	}

}
