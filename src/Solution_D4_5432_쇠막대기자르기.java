
/* D4.5432. 쇠막대기 자르기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVl47b6DGMDFAXm&categoryId=AWVl47b6DGMDFAXm&categoryType=CODE&problemTitle=%EC%87%A0%EB%A7%89%EB%8C%80%EA%B8%B0&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_5432_쇠막대기자르기 {
	static int T;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			int tot = 0;
			Stack<Character> stack = new Stack<>();
			boolean isOpen = false;
			String s = scan.next();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					stack.push('(');
					isOpen = true;
				} else if (s.charAt(i) == ')') {
					stack.pop();
					if (isOpen) {
						tot += stack.size();
					} else {
						tot += 1;
					}
					isOpen = false;
				}
			}
			System.out.println("#" + t + " " + tot);
		}

	}

}
