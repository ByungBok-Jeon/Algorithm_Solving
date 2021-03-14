
/* D3.5601. 쥬스 나누기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWXGAylqcdYDFAUo&categoryId=AWXGAylqcdYDFAUo&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=2
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_5601_쥬스나누기 {
	static int T;
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			System.out.print("#" + t + " ");
			for (int i = 0; i < N; i++) {
				System.out.print("1/" + N + " ");
			}
			System.out.println();
		}
		scan.close();
	}
}
