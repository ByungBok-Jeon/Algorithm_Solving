
/* D2.1989. 초심자의 회문 검사
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PyTLqAf4DFAUq&categoryId=AV5PyTLqAf4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D2_1989_초심자의회문검사 {
	static int T;

	static boolean isPalindrome(String input) {
		int last = input.length() - 1;
		boolean a = true;
		for (int i = 0; i < input.length() / 2; i++) {
			if (a == false || !(input.charAt(i) == input.charAt(last))) {
				a = false;
			}
			last--;
		}
		return a;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = Integer.parseInt(scan.nextLine());
		for (int t = 1; t <= T; t++) {
			String input = scan.nextLine();
			if (isPalindrome(input)) {
				System.out.printf("#%d %d\n", t, 1);
			} else {
				System.out.printf("#%d %d\n", t, 0);
			}
		}

	}

}
