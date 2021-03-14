
/* D3.10505. 소득 불균형
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXNP4CvauaMDFAXS&categoryId=AXNP4CvauaMDFAXS&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_10505_소득불균형 {
	static int T;
	static int N;
	static int[] income;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			income = new int[N];
			double avg = 0;
			for (int i = 0; i < N; i++) {
				income[i] = scan.nextInt();
				avg += income[i];
			}
			avg = avg / N;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				if (income[i] <= avg) {
					ans++;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
		scan.close();
	}
}
