/* D3.5162. 두가지 빵의 딜레마
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWTaTDua3OoDFAVT&categoryId=AWTaTDua3OoDFAVT&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=5
 * SW Expert Acadamy 문제
 */

import java.util.Scanner;

public class Solution_D3_5162_두가지빵의딜레마 {
	static int T;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			
			int min = Math.min(a, b);
			int ans = c/min;
			System.out.println("#"+t+" "+ans);
		}
		scan.close();
	}

}
