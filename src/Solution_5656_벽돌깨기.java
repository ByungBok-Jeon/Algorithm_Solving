
/* 5656. 벽돌깨기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo&categoryId=AWXRQm6qfL0DFAUo&categoryType=CODE&problemTitle=%EB%B2%BD%EB%8F%8C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static int T;
	static int N,W,H;
	static int[][] map;
	static int[] select;
	static int ans;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Block{
		int r;
		int c;
		int size;
		public Block(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			select = new int[N];
			ans = Integer.MAX_VALUE;
			nPr(0);
			System.out.println("#"+t+" "+ans);
		}
		
	}
	private static void nPr(int cnt) {
		if(cnt==N) {
			game(select);
			return;
		}
		for (int i = 0; i < W; i++) {
			select[cnt] = i;
			nPr(cnt+1);
		}
		
	}
	private static void game(int[] sel) {
		int[][] copyMap = copy();
		for (int i = 0; i < N; i++) {
			int row = 0, col = sel[i];
			boolean empty = true;
			while(row<H) {
				if(copyMap[row][col] != 0) {
					empty = false;
					break;
				}
				row++;
			}
			if(empty) continue;
			
			Queue<Block> que = new LinkedList<>();
			boolean[][] v = new boolean[H][W];
			que.offer(new Block(row, col, copyMap[row][col]));
			
			while(!que.isEmpty()) {
				Block now = que.poll();
				int r = now.r;
				int c = now.c;
				int size = now.size;
				
				if(v[r][c]) continue;
				v[r][c] = true;
				copyMap[r][c] = 0;
				
				for (int d = 0; d < 4; d++) {
					for (int j = 1; j < size; j++) {
						int nr = r + dr[d]*j;
						int nc = c + dc[d]*j;
						if(!isIn(nr,nc)) continue;
						if(copyMap[nr][nc]==0) continue;
						que.offer(new Block(nr, nc, copyMap[nr][nc]));
					}
				}
			}
			for (int c = 0; c < W; c++) {
				for (int r = H-1; r > 0; r--) {
					if(copyMap[r][c]==0) {
						int nr = r-1; 
						while(nr>0 && copyMap[nr][c]==0) nr--;
						copyMap[r][c] = copyMap[nr][c];
						copyMap[nr][c] = 0;
					}
				}
			}
			
		}
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(copyMap[i][j]!=0) cnt++;
			}
		}
		ans = Math.min(ans, cnt);
	}
	private static int[][] copy() {
		int[][] tmp_map = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tmp_map[i][j] = map[i][j];
			}
		}
		return tmp_map;
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}
}