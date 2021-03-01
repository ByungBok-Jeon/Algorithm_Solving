
/* D2.2005. 파스칼의 삼각형
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5P0-h6Ak4DFAUq&categoryId=AV5P0-h6Ak4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Arrays;
import java.util.Scanner;

public class Solution_d2_2005_파스칼의삼각형 {
	static int T,N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			map = new int[N][];
			for (int i = 0; i < N; i++) {
				map[i] = new int[i+1];
				Arrays.fill(map[i], 1);
			}
			for (int i = 2; i < N; i++) {
				for (int j = 1; j < i; j++) {
					map[i][j] = map[i-1][j-1]+ map[i-1][j];
				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j]+ " ");
				}
				System.out.println();
			}
		}
		scan.close();
	}
}
