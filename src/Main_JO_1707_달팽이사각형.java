
/* 1707번 달팽이사각형
 * 출처 : http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=980&sca=99&sfl=wr_hit&stx=1707
 * 정올  문제
 */
import java.util.Scanner;

public class Main_JO_1707_달팽이사각형 {
	static int n;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n= scan.nextInt();
		map = new int[n][n];
		v = new boolean[n][n];
		snail();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		scan.close();
	}
	static void snail() {
		int r = 0;
		int c = 0;
		int d = 0;
		for (int i = 1; i <= n*n; i++) {
			map[r][c] = i;
			v[r][c] = true;
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!isIn(nr,nc) || v[nr][nc]) {
				d = (d+1)%4;
				nr = r+dr[d];
				nc = c+dc[d];
			}
			r = nr;
			c = nc;
		}
	}
	static boolean isIn(int r, int c) {
		return r>=0 && r<n && c>=0 && c<n;
	}
}
