
/* 1953. 탈주범검거
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq&categoryId=AV5PpLlKAQ4DFAUq&categoryType=CODE&problemTitle=%ED%83%88%EC%A3%BC%EB%B2%94&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	
	static int T;
	static int N,M,holeR,holeC,time;
	static int[][] map;
	static int ans;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};//상하좌우
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			holeR = Integer.parseInt(st.nextToken());
			holeC = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			bfs();
			System.out.println("#"+t+" "+ans);
			
		}
	}

	private static void bfs() {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {holeR,holeC,1});
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int r = now[0];
			int c = now[1];
			int t = now[2];
			int type = map[r][c];
			
			if(visited[r][c] || t>time) continue;
			visited[r][c] = true;
			int[] dir = selDir(type);
			for (int a = 0; a < dir.length; a++) {
				int d = dir[a];
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!isIn(nr,nc) || map[nr][nc]==0) continue;
				int tmp = map[nr][nc];
				switch (d) {
				case 0:
					if(tmp == 3 || tmp == 4 || tmp == 7) continue;
					break;
				case 1:
					if(tmp == 3 || tmp == 5 || tmp == 6) continue;
					break;
				case 2:
					if(tmp == 2 || tmp == 6 || tmp == 7) continue;
					break;
				case 3:
					if(tmp == 2 || tmp == 4 || tmp == 5) continue;
					break;
				default:
					break;
				}
				
				que.offer(new int[] {nr,nc,t+1});
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j]) ans++;
			}
		}
		
	}

	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

	private static int[] selDir(int type) {
		switch (type) {
		case 1:
			return new int[] {0,1,2,3};
		case 2:
			return new int[] {0,1};
		case 3:
			return new int[] {2,3};
		case 4:
			return new int[] {0,3};
		case 5:
			return new int[] {1,3};
		case 6:
			return new int[] {1,2};
		case 7:
			return new int[] {0,2};
		default:
			break;
		}
		return null;
	}
}
