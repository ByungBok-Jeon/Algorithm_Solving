
/* D4.1861. 정사각형 방
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc&categoryId=AV5LtJYKDzsDFAXc&categoryType=CODE&problemTitle=1861&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방 {
	static int T;
	static int N;
	static int[][] map;
	static int[][] cnt;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cnt = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt[i][j] = dfs(i, j, 1);
				}
			}
			int maxNum = map[0][0];
			int max = cnt[0][0];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cnt[i][j] > max) {
						max = cnt[i][j];
						maxNum = map[i][j];
					} else if (cnt[i][j] == max) {
						maxNum = Math.min(maxNum, map[i][j]);
					}
				}
			}

			System.out.printf("#%d %d %d\n", t, maxNum, max);
		}
	}

	static int dfs(int r, int c, int cnt) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr, nc)) {
				continue;
			}
			if (map[r][c] + 1 == map[nr][nc]) {
				int nextCnt = dfs(nr, nc, cnt + 1);
				if (nextCnt > cnt) {
					return nextCnt;
				}
			}
		}
		return cnt;

	}

	static boolean check(int i, int j) {
		if (i >= 0 && i < N && j >= 0 && j < N) {
			return true;
		}
		return false;
	}
}
