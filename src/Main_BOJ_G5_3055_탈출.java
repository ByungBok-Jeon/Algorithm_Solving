
/* Gold5 3055번 탈출
 * 출처 : https://www.acmicpc.net/problem/3055
 * Baekjoon Online Judge  문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_G5_3055_탈출 {
	static int R, C;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> que;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		que = new LinkedList<>();
		int startR = 0, startC = 0;
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '*')
					que.offer(new int[] { 0, i, j, 0 });
				if (map[i][j] == 'S') {
					startR = i;
					startC = j;
				}
			}
		}
		que.offer(new int[] { 1, startR, startC, 0 });
		ans = 0;
		simulation();
		if (ans == 0)
			System.out.println("KAKTUS");
		else
			System.out.println(ans);

	}

	private static void simulation() {
		boolean[][] v = new boolean[R][C];

		while (!que.isEmpty()) {
			int[] now = que.poll();
			int type = now[0];
			int r = now[1];
			int c = now[2];
			int time = now[3];

			if (v[r][c])
				continue;
			v[r][c] = true;
			if (type == 1 && map[r][c] == 'D') {
				ans = time;
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (isIn(nr, nc)) {
					if (type == 0 && map[nr][nc] == '.') {
						map[nr][nc] = '*';
						que.offer(new int[] { type, nr, nc, time + 1 });
					} else if (type == 1 && map[nr][nc] != '*' && map[nr][nc]!='X') {
						que.offer(new int[] { type, nr, nc, time + 1 });
					}
				}

			}

		}

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}

