
/* Gold5 17144번 미세먼지안녕
 * 출처 : https://www.acmicpc.net/problem/17144
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_G5_17144_미세먼지안녕 {
	static int R,C,T;
	static int[][] map;
	static int cleaner1r,cleaner2r;
	static int ans;
	static int[] dr = {0,-1,0,1};//우상좌하
	static int[] dc = {1,0,-1,0};//우상좌하
	static int[] dr2 = {0,1,0,-1};//우하좌상
	static int[] dc2 = {1,0,-1,0};//우하좌상
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					cleaner2r = i;
				}
			}
		}
		cleaner1r = cleaner2r -1;
		ans = 0;
		simulation();
		System.out.println(ans);
	}
	
	private static void simulation() {
		for (int t = 0; t < T; t++) { // T초 반복
			//확산
			int[][] tmp_map = new int[R][C];
			tmp_map[cleaner1r][0] = -1;
			tmp_map[cleaner2r][0] = -1;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] != 0 && map[i][j]!=-1) {
						int dust = map[i][j];
						int spread_dust = 0;
						for (int d = 0; d < 4; d++) {
							int nr = i+dr[d];
							int nc = j+dc[d];
							if(isIn(nr,nc)&&map[nr][nc]!=-1) {
								tmp_map[nr][nc]+=dust/5;
								spread_dust+=dust/5;
							}
						}
						tmp_map[i][j]+=(dust-spread_dust);
					}
				}
			}
			map = Arrays.copyOfRange(tmp_map, 0, R);
			//순환
			int nr = cleaner1r;
			int nc = 1;
			int val = map[nr][nc];
			map[nr][nc] = 0;
			int d = 0;
			while(true) {
				if(!isIn(nr+dr[d],nc+dc[d])) d=d+1;
				nr = nr+dr[d];
				nc = nc+dc[d];
				int tmp_val = map[nr][nc];
				map[nr][nc] = val;
				val = tmp_val;
				if(nr+dr[d]==cleaner1r && nc+dc[d] ==0) break;
			}
			nr = cleaner2r;
			nc = 1;
			val = map[nr][nc];
			map[nr][nc] = 0;
			d = 0;
			while(true) {
				if(!isIn(nr+dr2[d],nc+dc2[d])) d=d+1;
				nr = nr+dr2[d];
				nc = nc+dc2[d];
				int tmp_val = map[nr][nc];
				map[nr][nc] = val;
				val = tmp_val;
				if(nr+dr2[d]==cleaner2r && nc+dc2[d] ==0) break;
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==-1) continue;
				ans+=map[i][j];
			}
		}
		
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}

}
