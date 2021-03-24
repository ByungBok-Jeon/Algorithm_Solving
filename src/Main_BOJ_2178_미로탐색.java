
/* 2178번 미로탐색
 * 출처 : https://www.acmicpc.net/problem/2178
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2178_미로탐색 {
	static int N,M;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {-1,0,1,0};//위오아왼
	static int[] dc = {0,1,0,-1};
	
	static class rc{
		int r;
		int c;
		public rc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] s= br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = s[j] - '0';
			}
		}
		
		Queue<rc> que = new LinkedList<>();
		que.offer(new rc(0,0));
		L1:while(!que.isEmpty()) {
			rc now = que.poll();
			if(v[now.r][now.c]) continue;
			v[now.r][now.c] = true;
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				if(!isIn(nr,nc)) continue;
				if(map[nr][nc]==0) continue;
				que.offer(new rc(nr,nc));
				map[nr][nc] = map[now.r][now.c]+1;
				if(nr==N-1 && nc == M-1) {
					break L1;
				}
			}
		}
		System.out.println(map[N-1][M-1]);
		
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && c>= 0 && r<N && c<M;
	}

}
