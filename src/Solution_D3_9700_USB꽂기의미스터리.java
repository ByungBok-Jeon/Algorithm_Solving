
/* D3.5549. 홀수일까짝수일까
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXDNEA3aaU0DFAVX&categoryId=AXDNEA3aaU0DFAVX&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=4
 * SW Expert Acadamy 문제
 */

import java.util.Scanner;

public class Solution_D3_9700_USB꽂기의미스터리 {
	static int T;
	static double s1,s2;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			double p = scan.nextDouble();
			double q = scan.nextDouble();
			s1 = (1-p)*q;
			s2 = p*(1-q)*(q);
			String ans = s1<s2 ? "YES" : "NO";
			System.out.println("#"+t+" " +ans);
		}
		scan.close();
	}
}
