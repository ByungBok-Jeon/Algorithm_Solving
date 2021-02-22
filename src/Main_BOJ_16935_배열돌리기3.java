
/* 16935번배열돌리기3
 * 출처 : https://www.acmicpc.net/problem/16935
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_16935_배열돌리기3 {
	static int N;
	static int M;
	static int R;
	static int[][] map;
	static int input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			input = Integer.parseInt(st.nextToken());
			switch (input) {
			case 1:
				btn1();
				break;
			case 2:
				btn2();
				break;
			case 3:
				btn3();
				break;
			case 4:
				btn4();
				break;
			case 5:
				btn5();
				break;
			case 6:
				btn6();
				break;
			default:
				break;
			}
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

	static void btn1() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				int tmp = map[i][j];
				map[i][j] = map[N - 1 - i][j];
				map[N - 1 - i][j] = tmp;
			}
		}
	}

	static void btn2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				int tmp = map[i][j];
				map[i][j] = map[i][M - 1 - j];
				map[i][M - 1 - j] = tmp;
			}
		}
	}

	static void btn3() {
		int[][] tmpArr = new int[M][N];
		int a = 0;
		int b = 0;
		for (int j = N - 1; j >= 0; j--) {
			for (int i = 0; i < M; i++) {
				tmpArr[i][j] = map[a][b];
				if (b + 1 == M) {
					a++;
					b = 0;
				} else {
					b++;
				}
			}
		}
		int tmp = N;
		N = M;
		M = tmp;
		map = tmpArr.clone();
	}

	static void btn4() {
		int[][] tmpArr = new int[M][N];
		int a = 0;
		int b = 0;
		for (int j = 0; j < N; j++) {
			for (int i = M - 1; i >= 0; i--) {
				tmpArr[i][j] = map[a][b];
				if (b + 1 == M) {
					a++;
					b = 0;
				} else {
					b++;
				}
			}
		}
		int tmp = N;
		N = M;
		M = tmp;
		map = tmpArr.clone();
	}

	static void btn5() {
		int[] dr = { 0, N / 2, 0, -N / 2 };
		int[] dc = { M / 2, 0, -M / 2, 0 };
		int d = 0;
		int a = 0;
		int b = 0;
		int[][] tmpArr = new int[N][M];
		for (int n = 0; n < 4; n++) {
			for (int i = a; i < a + N / 2; i++) {
				for (int j = b; j < b + M / 2; j++) {
					tmpArr[i + dr[d]][j + dc[d]] = map[i][j];
				}
			}
			a += dr[d];
			b += dc[d];
			d++;
		}
		map = tmpArr.clone();
	}

	static void btn6() {
		int[] dr = { N / 2, 0, -N / 2, 0 };
		int[] dc = { 0, M / 2, 0, -M / 2 };
		int d = 0;
		int a = 0;
		int b = 0;
		int[][] tmpArr = new int[N][M];
		for (int n = 0; n < 4; n++) {
			for (int i = a; i < a + N / 2; i++) {
				for (int j = b; j < b + M / 2; j++) {
					tmpArr[i + dr[d]][j + dc[d]] = map[i][j];
				}
			}
			a += dr[d];
			b += dc[d];
			d++;
		}
		map = tmpArr.clone();
	}
}
