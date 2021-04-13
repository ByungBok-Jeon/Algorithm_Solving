
/* 1249. 보급로
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD&categoryId=AV15QRX6APsCFAYD&categoryType=CODE&problemTitle=%EB%B3%B4%EA%B8%89%EB%A1%9C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_1249_보급로 {
	static int T, N;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Vertex implements Comparable<Vertex> {
		int r;
		int c;
		int result;

		public Vertex(int r, int c, int result) {
			this.r = r;
			this.c = c;
			this.result = result;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.result, o.result);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			System.out.println("#" + t + " " + dijkstra(0, 0));

		}
	}

	private static int dijkstra(int startR, int startC) {
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(minTime[i], Integer.MAX_VALUE);
		}
		PriorityQueue<Vertex> que = new PriorityQueue<>();

		minTime[startR][startC] = 0;
		que.offer(new Vertex(startR, startC, 0));

		while (true) {
			Vertex now = que.poll();
			int r = now.r;
			int c = now.c;
			int result = now.result;

			if(visited[r][c]) continue;
			visited[r][c] = true;

			if (r == N - 1 && c == N - 1)
				return result;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (isIn(nr, nc) && !visited[nr][nc] && minTime[nr][nc] > result + map[nr][nc]) {
					minTime[nr][nc] = result + map[nr][nc];
					que.offer(new Vertex(nr, nc, minTime[nr][nc]));
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
