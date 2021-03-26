
/* 2667번 단지번호붙이기
 * 출처 : https://www.acmicpc.net/problem/2667
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_2667_단지번호붙이기 {
	
	static class RC{
		int r;
		int c;
		public RC(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int[][] map;
	static int danji;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		danji = 2;
		for (int i = 0; i < N; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = s[j] - '0';
			}
		}
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					bfs(i,j);
					danji++;
				}
			}
		}
		int[] house = new int[danji];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0) continue;
				house[map[i][j]]++;
			}
		}
		Arrays.sort(house);
		System.out.println(danji-2);
		for (int i = 2; i < danji; i++) {
			System.out.println(house[i]);
		}
		

	}
	static void bfs(int r, int c) {
		Queue<RC> que = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		que.offer(new RC(r,c));
		v[r][c] = true;
		map[r][c] = danji;
		while(!que.isEmpty()) {
			RC now = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = now.r+dr[d];
				int nc = now.c+dc[d];
				if(!isIn(nr,nc)) continue;
				if(map[nr][nc]!=1) continue;
				if(v[nr][nc]) continue;
				v[nr][nc] = true;
				map[nr][nc] = danji;
				que.offer(new RC(nr,nc));
			}
		}
		
	}
	static boolean isIn(int r, int c) {
		return r>=0 && r < N && c>=0 && c<N;
	}

}
