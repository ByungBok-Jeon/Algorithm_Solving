
/* D3.3142. 영준이와신비한뿔의숲
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV_6xWk6sbADFAWS&categoryId=AV_6xWk6sbADFAWS&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=4
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_3142_영준이와신비한뿔의숲 {
	static int T;
	static int n, m;
	static int x, y;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			n = scan.nextInt();
			m = scan.nextInt();
			x = 2 * m - n;
			y = m - x;
			System.out.println("#" + t + " " + x + " " + y);
		}
		scan.close();
	}
}
