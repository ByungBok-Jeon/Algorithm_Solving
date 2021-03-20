
/* D3.1206. View
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh&categoryId=AV134DPqAA8CFAYh&categoryType=CODE&problemTitle=1206&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1206_View {
	static int T = 10;
	static int N;
	static boolean[][] map;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new boolean[N][256];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int f = Integer.parseInt(st.nextToken());
				for (int j = 0; j < f; j++) {
					map[i][j] = true;
				}
			}
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 256; j++) {
					if (map[i][j] && !map[i - 1][j] && !map[i - 2][j] && !map[i + 1][j] && !map[i + 2][j]) {
						ans++;
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
