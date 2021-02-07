
/* D2.1954. 달팽이 숫자
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq&categoryId=AV5PobmqAPoDFAUq&categoryType=CODE&problemTitle=1954&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {

	static int T;
	static int N;
	static int[][] snail;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static boolean check(int rr, int cc) {
		if (rr >= 0 && rr < N && cc >= 0 && cc < N) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			snail = new int[N][N];
			int r = 0;
			int c = 0;
			int d = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					snail[r][c] = i * N + j + 1;
					if (!(check(r + dr[d], c + dc[d]) && snail[r + dr[d]][c + dc[d]] == 0)) {
						d = (d + 1) % 4;

					}
					r += dr[d];
					c += dc[d];
				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}

		}

	}

}
