import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_16926_배열돌리기1 {
	static int N;
	static int M;
	static int R;
	static int[][] map;
	static boolean[][] rotated;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		rotated = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int r = 0; r < R; r++) {
			rotate();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (j == M - 1) {
					bw.write("" + map[i][j]);
				} else {
					bw.write("" + map[i][j] + " ");
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	static void rotate() {
		int a = 0;
		int[][] tmpArr = new int[N][M];
		for (int n = 0; n < Math.min(M, N) / 2; n++) {

			int d = 0;
			int r = a;
			int c = a;
			int nr = r + dr[d];
			int nc = c + dc[d];
			for (int i = 0; i < 2 * (M-2*a) + 2 * (N-2*a) - 4; i++) {
				tmpArr[nr][nc] = map[r][c];
				rotated[nr][nc] = true;
				r = nr;
				c = nc;
				if (!inMap(r + dr[d], c + dc[d]) || rotated[r + dr[d]][c + dc[d]]) {
					d = (d + 1) % 4;
				}
				nr = r + dr[d];
				nc = c + dc[d];
			}
			a++;
		}
		map = tmpArr.clone();
		rotated = new boolean[N][M];
	}

	static boolean inMap(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
