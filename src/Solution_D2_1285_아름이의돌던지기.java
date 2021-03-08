
/* D2.1285. 아름이의 돌 던지기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV18-stqI8oCFAZN&categoryId=AV18-stqI8oCFAZN&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=3
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D2_1285_아름이의돌던지기 {
	static int T;
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			int min = Integer.MAX_VALUE;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				int num = Math.abs(scan.nextInt());
				if (min > num) {
					min = num;
					cnt = 1;
				} else if (min == num) {
					cnt++;
				}
			}
			System.out.println("#" + t + " " + min + " " + cnt);
		}
		scan.close();
	}
}
