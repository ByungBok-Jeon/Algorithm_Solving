
/* 2563번 색종이
 * 출처 : https://www.acmicpc.net/problem/2563
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_2563_색종이 {
	static int[][] map;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		map = new int[100][100];
		N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int down = Integer.parseInt(st.nextToken());
			for (int i = left; i < left + 10; i++) {
				for (int j = 99 - down; j > 89 - down; j--) {
					map[i][j] = 1;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		bw.write("" + cnt);
		bw.flush();
		bw.close();
	}
}
