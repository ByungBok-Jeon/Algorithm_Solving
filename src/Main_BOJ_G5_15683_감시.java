
/* Gold5 15683번 감시
 * 출처 : https://www.acmicpc.net/problem/15683
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_G5_15683_감시 {
	static int N,M;
	static int[][] map;
	static int ans;
	static List<Camera> list;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};//상하좌우
	static class Camera{
		int r;
		int c;
		int val;
		public Camera(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0 && map[i][j] <6) list.add(new Camera(i,j,map[i][j]));
			}
		}
		ans = Integer.MAX_VALUE;
		dfs(0,map);
		System.out.println(ans);
	}
	
	
	private static void dfs(int cnt, int[][] m) {
		if(cnt==list.size()) {
			int count = 0;
			for (int i = 0; i <N; i++) {
				for (int j = 0; j < M; j++) {
					if(m[i][j]==0) count++;
				}
			}
			ans = Math.min(ans, count);
			return;
		}
		
		switch (list.get(cnt).val) {
		case 1:
			int[][] dir1 = {{0},{1},{2},{3}};
			for (int i = 0; i < dir1.length; i++) {
				int[][] tmp_map = fill(copy(m),dir1[i],list.get(cnt));
				dfs(cnt+1,tmp_map);
			}
			break;
		case 2:
			int[][] dir2 = {{2,3},{0,1}};
			for (int i = 0; i < dir2.length; i++) {
				int[][] tmp_map = fill(copy(m),dir2[i],list.get(cnt));
				dfs(cnt+1,tmp_map);
			}
			break;
		case 3:
			int[][] dir3 = {{0,3},{1,3},{1,2},{0,2}};
			for (int i = 0; i < dir3.length; i++) {
				int[][] tmp_map = fill(copy(m),dir3[i],list.get(cnt));
				dfs(cnt+1,tmp_map);
			}
			break;
		case 4:
			int[][] dir4 = {{0,1,2},{0,1,3},{0,2,3},{1,2,3}};
			for (int i = 0; i < dir4.length; i++) {
				int[][] tmp_map = fill(copy(m),dir4[i],list.get(cnt));
				dfs(cnt+1,tmp_map);
			}
			break;
		case 5:
			int[][] dir5 = {{0,1,2,3}};
			for (int i = 0; i < dir5.length; i++) {
				int[][] tmp_map = fill(copy(m),dir5[i],list.get(cnt));
				dfs(cnt+1,tmp_map);
			}
			break;

		default:
			break;
		}
		
	}
	
	
	private static int[][] fill(int[][] tmp_map, int[] dir, Camera cam) {
		int r = cam.r;
		int c = cam.c;
		for (int n = 0; n < dir.length; n++) {
			int d = dir[n];
			int nr = r;
			int nc = c;
			while(true) {
				nr += dr[d];
				nc += dc[d];
				if(!isIn(nr,nc) || tmp_map[nr][nc] == 6) {
					break;
				} else if(tmp_map[nr][nc]>0 && tmp_map[nr][nc] <6) continue;
				tmp_map[nr][nc] = 7;
			}
		}
		return tmp_map;
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	
	private static int[][] copy(int[][] m) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = m[i][j];
			}
		}
		return tmp;
	}
}
