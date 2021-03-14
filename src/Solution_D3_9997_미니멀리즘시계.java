
/* D3.9997. 미니멀리즘 시계
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXIvNBzKapEDFAXR&categoryId=AXIvNBzKapEDFAXR&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */

import java.util.Scanner;

public class Solution_D3_9997_미니멀리즘시계 {
	static int T;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			int angle = scan.nextInt();
			int h = 0;
			int m = 0;
			h = (angle * 2) / 60;
			m = (angle * 2) % 60;
			System.out.println("#" + t + " " + h + " " + m);
		}
		scan.close();
	}
}
