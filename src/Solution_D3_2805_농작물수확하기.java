
/* D3.2805. 농작물 수확하기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB&categoryId=AV7GLXqKAWYDFAXB&categoryType=CODE&problemTitle=2805&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기 {
	static int T, N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			N = scan.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = scan.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = Math.abs(i - N / 2); j < N - Math.abs(i - N / 2); j++) {
					ans += map[i][j];
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
