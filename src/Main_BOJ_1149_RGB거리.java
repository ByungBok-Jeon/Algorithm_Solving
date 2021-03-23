
/* 1149번 RGB거리
 * 출처 : https://www.acmicpc.net/problem/1149
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1149_RGB거리 {
	static int N;
	static int[][] D;
	static int[] R,G,B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		D = new int[N+1][3];
		R = new int[N+1];
		G = new int[N+1];
		B = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			G[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			D[i][0] = Math.min(D[i-1][1], D[i-1][2])+R[i];
			D[i][1] = Math.min(D[i-1][0], D[i-1][2])+G[i];
			D[i][2] = Math.min(D[i-1][0], D[i-1][1])+B[i];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, D[N][i]);
		}
		System.out.println(min);
	}
}
