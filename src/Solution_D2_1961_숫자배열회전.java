
/* D2.1961. 숫자 배열 회전
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5Pq-OKAVYDFAUq&categoryId=AV5Pq-OKAVYDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2
 * SW Expert Acadamy 문제
 */
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1961_숫자배열회전 {
	static int T;
	static int N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			int[][][] nMap = new int[3][N][N];
			int[][] ans = new int[N][N];
			ans = Arrays.copyOfRange(map, 0, N);
			for (int k = 0; k < 3; k++) {
				nMap[k] = rot(ans);
				ans = Arrays.copyOfRange(nMap[k], 0, N);
			}

			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < 3; k++) {
					for (int j = 0; j < N; j++) {
						System.out.print(nMap[k][i][j]);
					}
					System.out.print(" ");
				}
				System.out.println();
			}
		}
		scan.close();
	}

	static int[][] rot(int[][] m) {
		int[][] nm = new int[N][N];
		int r = 0;
		int c = 0;
		for (int j = 0; j < N; j++) {
			for (int i = N - 1; i >= 0; i--) {
				nm[r][c] = m[i][j];
				c = (c + 1) % N;
			}
			r++;
		}
		return nm;
	}
}
