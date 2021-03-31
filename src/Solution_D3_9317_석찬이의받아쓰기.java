
/* D3.9317. 석찬이의받아쓰기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AW-hOY5KeEIDFAVg&categoryId=AW-hOY5KeEIDFAVg&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=2
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_9317_석찬이의받아쓰기 {
	static int T;
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			String s1 = scan.next();
			String s2 = scan.next();
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if(s1.charAt(i)!=s2.charAt(i)) {
					cnt++;
				}
			}
			System.out.println("#"+t+ " " + (N-cnt));
		}
		scan.close();
	}
}
