
/* D4.7733. 치즈도둑
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWrDOdQqRCUDFARG&categoryId=AWrDOdQqRCUDFARG&categoryType=CODE&problemTitle=7733&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_7733_치즈도둑 {
	static int T;
	static int N;
	static int[][] map;
	static int ans;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int cnt;
	static int[][] tmpMap;
	
	static class RC{
		int r;
		int c;
		public RC(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			map = new int[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt()-1;
					max = Math.max(max, map[i][j]);
				}
			}
			int ans = 1;
			for (int k = 0; k < 100; k++) {
				if(k>max) break;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j]==k) map[i][j] = 0;
						
					}
				}
				tmpMap = new int[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						tmpMap[i][j] = map[i][j];
					}
				}
				cnt = 0;
				calMax();
				ans = Math.max(ans, cnt);
			}
			System.out.println("#"+t+" " + ans);
			
			
			
		}
		
		scan.close();
	}
	static void calMax() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(tmpMap[i][j] != 0) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		
	}
	static void bfs(int r, int c) {
		Queue<RC> que = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		que.offer(new RC(r,c));
		v[r][c] = true;
		while(!que.isEmpty()) {
			RC now = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = now.r+dr[d];
				int nc = now.c+dc[d];
				if(!isIn(nr,nc)) continue;
				if(tmpMap[nr][nc]==0) continue;
				if(v[nr][nc]) continue;
				v[nr][nc] = true;
				tmpMap[nr][nc] = 0;
				que.offer(new RC(nr,nc));
			}
		}
	}
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
