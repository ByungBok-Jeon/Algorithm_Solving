
/* 9205번 맥주마시면서걸어가기
 * 출처 : https://www.acmicpc.net/problem/9205
 * Baekjoon Online Judge  문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_9205_맥주마시면서걸어가기 {
	static final int INF = 999999;
	static int T,N;
	static int[][] graph;
	static int[] xl;
	static int[] yl;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			graph = new int[N+2][N+2];
			xl = new int[N+2];
			yl = new int[N+2];
			
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				xl[i] = Integer.parseInt(st.nextToken());
				yl[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					if(i==j) continue;
					int dist = Math.abs(xl[i]-xl[j])+ Math.abs(yl[i]-yl[j]);
					if(dist<=1000) {
						graph[i][j] = 1;
					}else {
						graph[i][j] = INF;
					}
				}
			}
			for (int k = 0; k < N+2; ++k) {
				for (int i = 0; i < N+2; ++i) {
					if(k==i) continue;
					for (int j = 0; j < N+2; ++j) {
						if(k==j || i==j) continue;
						if(graph[i][j] > graph[i][k] + graph[k][j]) {
							graph[i][j] = graph[i][k] + graph[k][j];
						}
					}
				}
			}
			if(graph[0][N+1] >= INF) {
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}
		}
	}
}
