
/* Silver1 7569번 토마토
 * 출처 : https://www.acmicpc.net/problem/7569
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_S1_7569_토마토 {
	static int M,N,H;
	static int[][][] map;
	static Queue<int[]> que;
	static int[] dh = {-1,1,0,0,0,0};
	static int[] dr = {0,0,-1,1,0,0};
	static int[] dc = {0,0,0,0,-1,1};//위아래 상하좌우
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		que = new LinkedList<int[]>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[h][i][j]==1) {
						que.offer(new int[] {h,i,j,0});
					}
				}
			}
		}
		bfs();
		
	}

	private static void bfs() {
		boolean[][][] visited = new boolean[H][N][M];
		int last = 0;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int h = now[0];
			int r = now[1];
			int c = now[2];
			int time = now[3];
			last = time;
			if(visited[h][r][c]) continue;
			visited[h][r][c] = true;
			
			for (int d = 0; d < 6; d++) {
				int nh = h+dh[d];
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(isIn(nh,nr,nc) && map[nh][nr][nc] == 0) {
					map[nh][nr][nc] = 1;
					que.offer(new int[] {nh,nr,nc,time+1});
				}
			}
		}
		boolean allOk = true;
		L1 : for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[h][i][j]==0) {
						allOk = false;
						break L1;
					}
				}
			}
		}
		
		if(allOk) {
			System.out.println(last);
		}else {
			System.out.println("-1");
		}
		
	}

	private static boolean isIn(int h,int r, int c) {
		return h>=0 && h<H && r>=0 && r<N && c>=0 && c<M;
	}

}
