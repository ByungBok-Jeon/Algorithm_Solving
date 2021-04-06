
/* D3.5431. 민석이의과제체크하기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWVl3rWKDBYDFAXm&categoryId=AWVl3rWKDBYDFAXm&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=3
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_5431_민석이의과제체크하기 {
	static int T;
	static int N,K;
	static boolean[] report;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			K = scan.nextInt();
			report = new boolean[N+1];
			for (int i = 1; i <= K; i++) {
				report[scan.nextInt()] = true;
			}
			System.out.print("#"+t);
			for (int i = 1; i <= N; i++) {
				if(!report[i]) System.out.print(" "+i);
			}
			System.out.println();
		}
		scan.close();
	}
}
