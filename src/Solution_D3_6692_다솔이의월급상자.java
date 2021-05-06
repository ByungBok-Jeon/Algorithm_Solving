
/* D3.6692. 다솔이의월급상자
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWdXofhKFkADFAWn&categoryId=AWdXofhKFkADFAWn&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=5
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_6692_다솔이의월급상자 {
	static int T;
	static double ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = scan.nextInt();
			ans = 0.0;
			for (int i = 0; i < n; i++) {
				ans += scan.nextDouble()*scan.nextInt();
			}
			System.out.printf("#%d %.6f\n",t,ans);
		}
		scan.close();
	}

}

