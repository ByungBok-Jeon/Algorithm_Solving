
/* D2.1945. 간단한 소인수분해
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5Pl0Q6ANQDFAUq&categoryId=AV5Pl0Q6ANQDFAUq&categoryType=CODE&problemTitle=%EC%86%8C%EC%9D%B8%EC%88%98&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D2_1945_간단한소인수분해 {
	static int T, N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
			while (N % 2 == 0) {
				N = N / 2;
				a++;
			}
			while (N % 3 == 0) {
				N = N / 3;
				b++;
			}
			while (N % 5 == 0) {
				N = N / 5;
				c++;
			}
			while (N % 7 == 0) {
				N = N / 7;
				d++;
			}
			while (N % 11 == 0) {
				N = N / 11;
				e++;
			}
			System.out.printf("#%d %d %d %d %d %d\n", t, a, b, c, d, e);
		}

	}

}
