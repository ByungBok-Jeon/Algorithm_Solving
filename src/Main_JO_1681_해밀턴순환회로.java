
/* 1681번 해밀턴순환회로
 * 출처 : http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=954&sca=99&sfl=wr_hit&stx=1681
 * 정올  문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1681_해밀턴순환회로 {
	static int N;
	static int[][] graph;
	static boolean[] visited;
	static int min;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0] = true;
		dfs(0,0,0);
		System.out.println(min);
	}


	static void dfs(int vertex, int cnt, int distance) {
		if(cnt==N-1) {
			if(graph[vertex][0] == 0) {
				return;
			}
			distance+=graph[vertex][0];
			min = Math.min(min, distance);
			return;
		}
		if(distance>min) {
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) {
				continue;
			}
			if(graph[vertex][i]==0) {
				continue;
			}
			visited[i] = true;
			dfs(i,cnt+1,distance+graph[vertex][i]);
			visited[i] = false;
		}
		
	}

}


