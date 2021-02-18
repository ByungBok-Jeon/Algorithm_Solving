
/* D5.1247. 최적경로
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD&categoryId=AV15OZ4qAPICFAYD&categoryType=CODE&problemTitle=%EC%B5%9C%EC%A0%81&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D5_1247_최적경로 {
	static int T, N;
	static int[][] map;
	static int[] comp;
	static int[] home;
	static int[] num;
	static int ans;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			map = new int[N][2];
			comp = new int[2];
			home = new int[2];
			num = new int[N];
			comp[0] = scan.nextInt();
			comp[1] = scan.nextInt();
			home[0] = scan.nextInt();
			home[1] = scan.nextInt();
			for (int i = 0; i < N; i++) {
				map[i][0] = scan.nextInt();
				map[i][1] = scan.nextInt();
			}
			boolean[] v = new boolean[N];
			ans = Integer.MAX_VALUE;
			nPr(0, 0, v);
			System.out.println("#" + t + " " + ans);
		}
		scan.close();
	}

	static void nPr(int cnt, int dis, boolean[] v) {
		if (cnt == N) {
			ans = Math.min(ans, dis + calDis(map[num[cnt - 1]][0], map[num[cnt - 1]][1], home[0], home[1]));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i])
				continue;
			v[i] = true;
			num[cnt] = i;
			if (cnt == 0)
				nPr(cnt + 1, calDis(comp[0], comp[1], map[i][0], map[i][1]), v);
			else
				nPr(cnt + 1,
						dis + calDis(map[num[cnt]][0], map[num[cnt]][1], map[num[cnt - 1]][0], map[num[cnt - 1]][1]),
						v);
			v[i] = false;
		}
	}

	static int calDis(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
