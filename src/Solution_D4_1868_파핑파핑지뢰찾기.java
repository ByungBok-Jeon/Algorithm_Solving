
/* D4.1868. 파핑파핑지뢰찾기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LwsHaD1MDFAXc&categoryId=AV5LwsHaD1MDFAXc&categoryType=CODE&problemTitle=1868&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1868_파핑파핑지뢰찾기 {
	static int T;
	static int N;
	static char[][] map;
	static int[][] newMap;
	static boolean[][] v;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static Queue<int[]> que;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			v = new boolean[N][N];
			newMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			que = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '*') {
						v[i][j] = true;
						newMap[i][j] = -1;
						continue;
					}
					int count = 0;
					for (int d = 0; d < 8; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (isIn(nr, nc) && map[nr][nc] == '*') {
							count++;
						}
					}
					newMap[i][j] = count;
				}
			}
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j] && newMap[i][j] == 0) {
						que.offer(new int[] { i, j });
						bfs();
						ans++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j])
						ans++;
				}
			}
			System.out.println("#" + t + " " + ans);

		}

	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int[] now = que.poll();
			int r = now[0];
			int c = now[1];

			if (v[r][c])
				continue;
			v[r][c] = true;

			if (newMap[r][c] == 0) {
				for (int d = 0; d < 8; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (!isIn(nr, nc))
						continue;
					que.offer(new int[] { nr, nc });
				}
			}

		}

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
