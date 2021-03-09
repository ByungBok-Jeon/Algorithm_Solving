
/* D3.6730. 장애물 경주 난이도
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWefy5x65PoDFAUh&categoryId=AWefy5x65PoDFAUh&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_6730_장애물경주난이도 {
	static int T;
	static int N;
	static int[] block;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			block = new int[N];
			for (int i = 0; i < N; i++) {
				block[i] = scan.nextInt();
			}
			int up = 0;
			int down = 0;
			for (int i = 0; i < N - 1; i++) {
				int tmp = block[i + 1] - block[i];
				if (tmp > 0) {
					up = Math.max(up, tmp);
				} else if (tmp < 0) {
					down = Math.max(down, -tmp);
				}
			}
			System.out.println("#" + t + " " + up + " " + down);
		}
		scan.close();
	}
}