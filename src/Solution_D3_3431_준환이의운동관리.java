
/* D3.3431. 준환이의 운동관리
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWE_ZXcqAAMDFAV2&categoryId=AWE_ZXcqAAMDFAV2&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_3431_준환이의운동관리 {
	static int T;
	static int L, U, X;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			L = scan.nextInt();
			U = scan.nextInt();
			X = scan.nextInt();
			int ans = 0;
			if (U < X) {
				ans = -1;
			} else if (X >= L) {
				ans = 0;
			} else {
				ans = L - X;
			}
			System.out.println("#" + t + " " + ans);
		}
		scan.close();
	}
}
