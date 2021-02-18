
/* 1733번 오목
 * 출처 : http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1006&sca=99&sfl=wr_hit&stx=1733
 * 정올  문제
 */
import java.util.Scanner;

public class Main_JO_1733_오목 {
	final static int N = 19;
	static int[][] map;
	static int ansR, ansC;
	static int[] dr = { 0, 1, 1, -1 };
	static int[] dc = { 1, 0, 1, 1 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		map = new int[N][N];
		ansR = 0;
		ansC = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		if (!isWin(1) && !isWin(2))
			System.out.println(0);
		scan.close();
	}

	static boolean isWin(int num) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == num && five(num, i, j)) {
					System.out.println(num);
					System.out.println(ansR + " " + ansC);
					return true;
				}
			}
		}
		return false;
	}

	static boolean five(int num, int r, int c) {
		for (int d = 0; d < 4; d++) {
			int cnt = 1;
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (isIn(r - dr[d], c - dc[d]) && map[r - dr[d]][c - dc[d]] == num)
				continue;
			while (true) {
				if (isIn(nr, nc) && map[nr][nc] == num) {
					cnt++;
					nr += dr[d];
					nc += +dc[d];
				} else
					break;
			}
			if (cnt == 5) {
				ansR = r + 1;
				ansC = c + 1;
				return true;
			}
		}
		return false;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
