
/* Silver1 7576번 토마토
 * 출처 : https://www.acmicpc.net/problem/7576
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_S1_7576_토마토 {
	static int M,N;
	static int[][] map;
	static Queue<int[]> que;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		que = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) {
					que.offer(new int[] {i,j,0});
				}
			}
		}
		bfs();
		
	}

	private static void bfs() {
		boolean[][] visited = new boolean[N][M];
		int last = 0;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int r = now[0];
			int c = now[1];
			int time = now[2];
			last = time;
			if(visited[r][c]) continue;
			visited[r][c] = true;
			
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(isIn(nr,nc) && map[nr][nc] == 0) {
					map[nr][nc] = 1;
					que.offer(new int[] {nr,nc,time+1});
				}
			}
		}
		boolean allOk = true;
		L1 : for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					allOk = false;
					break L1;
				}
			}
		}
		if(allOk) {
			System.out.println(last);
		}else {
			System.out.println("-1");
		}
		
	}

	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
