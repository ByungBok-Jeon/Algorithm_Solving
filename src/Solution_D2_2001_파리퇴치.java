
/* D2.2001. 파리 퇴치
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq&categoryId=AV5PzOCKAigDFAUq&categoryType=CODE&problemTitle=2001&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D2_2001_파리퇴치 {
	static int T;
	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			M = scan.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt();
				}
			}

			System.out.println("#" + t + " " + maxSum());

		}

	}

	private static int maxSum() {
		int tot = 0;
		for (int i = 0; i < N - M + 1; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				int sum = 0;
				for (int r = i; r < i + M; r++) {
					for (int c = j; c < j + M; c++) {
						sum += map[r][c];
					}
				}
				tot = Math.max(tot, sum);
			}
		}
		return tot;
	}

}
