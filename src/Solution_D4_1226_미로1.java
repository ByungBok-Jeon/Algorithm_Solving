
/* D4.1226. 미로1
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14vXUqAGMCFAYD&categoryId=AV14vXUqAGMCFAYD&categoryType=CODE&problemTitle=%EB%AF%B8%EB%A1%9C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1226_미로1 {
	static final int N = 16;
	static int[][] map;
	static boolean canGo;
	static RC start;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};//상하좌우
	
	static class RC{
		int r;
		int c;
		public RC(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] s = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = s[j] - '0';
					if(map[i][j] == 2) {
						start = new RC(i,j);
					}
				}
			}
			canGo = false;
			bfs();
			if(canGo) System.out.println("#"+t+" " + 1);
			else System.out.println("#"+t+" " + 0);
		}
	}
	private static void bfs() {
		Queue<RC> que = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		que.offer(start);
		v[start.r][start.c] = true;
		L1 :while(!que.isEmpty()) {
			RC now = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = now.r+dr[d];
				int nc = now.c+dc[d];
				if(!isIn(nr,nc)) continue;
				if(map[nr][nc] == 1) continue;
				if(map[nr][nc] == 3) {
					canGo = true;
					break L1;
				}
				if(v[nr][nc]) continue;
				v[nr][nc] = true;
				que.offer(new RC(nr,nc));
			}
		}
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
