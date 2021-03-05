
/* D2.1976. 시각덧셈
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PttaaAZIDFAUq&categoryId=AV5PttaaAZIDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;
 
public class Solution_D2_1976_시각덧셈 {
	static int T;
	static int h1, h2, m1, m2;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			h1 = scan.nextInt();
			m1 = scan.nextInt();
			h2 = scan.nextInt();
			m2 = scan.nextInt();
			int ansH = h1 + h2;
			int ansM = m1 + m2;
			if (ansM >= 60) {
				ansM -= 60;
				ansH += 1;
			}
			if (ansH > 12) {
				ansH -= 12;
			}
			System.out.println("#" + t + " " + ansH + " " + ansM);
		}
		scan.close();
	}

}
