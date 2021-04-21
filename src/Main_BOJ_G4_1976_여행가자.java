
/* Gold4 1976번 여행가자
 * 출처 : https://www.acmicpc.net/problem/1976
 * Baekjoon Online Judge  문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_G4_1976_여행가자 {
	static int N,M;
	static int[][] graph;
	static Queue<Integer> que;
	static boolean can;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		que = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			que.offer(Integer.parseInt(st.nextToken())-1);
		}
		can = true;
		simulation();
		if(can) System.out.println("YES");
		else System.out.println("NO");
	}
	private static void simulation() {
		int start = que.poll();
		while(!que.isEmpty()) {
			int to = que.poll();
			if(start == to) continue;
			boolean canGo = bfs(start,to);
			if(!canGo) {
				can = false;
				return;
			}
			start = to;
		}
		
	}
	static boolean bfs(int start, int to) {
		Queue<Integer> que = new LinkedList<>();
		boolean[] v = new boolean[N];
		que.offer(start);
		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(v[now]) continue;
			v[now] = true;
			
			for (int i = 0; i < N; i++) {
				if(i==now)continue;
				if(graph[now][i]==1) { 
					int next = i;
					if(next==to) return true;
					que.offer(next);
				}
			}
		}
		return false;
	}
}
