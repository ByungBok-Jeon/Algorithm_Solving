
/* D4.8382. 방향전환
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWyNQrCahHcDFAVP&categoryId=AWyNQrCahHcDFAVP&categoryType=CODE&problemTitle=8382&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_8382_방향전환 {
	static int T;
	static int[][] map;
	static int[] dr = {-1,-1,1,1};
	static int[] dc = {-1,1,-1,1}; // 대각선 4방향
	static int[] d4r = {-1,1,0,0};
	static int[] d4c = {0,0,-1,1}; // 상하좌우 4방향
	static RC start;
	static RC end;
	static int ans;
	
	static class RC{
		int r;
		int c;
		int dis;
		public RC(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = 0;
			map = new int[201][201];
			start = new RC(scan.nextInt()+100,scan.nextInt()+100,0);
			end = new RC(scan.nextInt()+100,scan.nextInt()+100,0);
			bfs();
			System.out.println("#"+t+" "+ans);
		}
		scan.close();
	}

	private static void bfs() {
		Queue<RC> que = new LinkedList<>();
		que.offer(start);
		int[][] v = new int[201][201];
		for (int i = 0; i < v.length; i++) {
			Arrays.fill(v[i], -1);
		}
		
		while(!que.isEmpty()) {
			RC now = que.poll();
			v[now.r][now.c] = now.dis;
			if(now.r == end.r && now.c == end.c) {
				ans = now.dis*2;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = now.r+d4r[d];
				int nc = now.c+d4c[d];
				if(!isIn(nr,nc)) continue;
				if(nr==end.r && nc==end.c) {
					ans = (now.dis * 2)+1;
					return;
				}
			}
			for (int d = 0; d < 4; d++) {
				int nr = now.r+dr[d];
				int nc = now.c+dc[d];
				if(!isIn(nr,nc)) continue;
				if(v[nr][nc] != -1) continue;
				v[nr][nc] = now.dis+1;
				que.offer(new RC(nr,nc,now.dis+1));
			}
		}
		
		
		
	}

	static boolean isIn(int r, int c) {
		return r>=0 && r<201 && c>=0 && c<201;
	}

}
