
/* D2.1970. 쉬운 거스름돈
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PsIl6AXIDFAUq&categoryId=AV5PsIl6AXIDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D2_1970_쉬운거스름돈 {
	static int T;
	static int N;
	static int[] money;
	static int[] bill = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			money = new int[8];
			for (int i = 0; i < bill.length; i++) {
				while (N >= bill[i]) {
					N -= bill[i];
					money[i]++;
				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < money.length; i++) {
				System.out.print(money[i] + " ");
			}
			System.out.println();
		}
		scan.close();
	}
}
