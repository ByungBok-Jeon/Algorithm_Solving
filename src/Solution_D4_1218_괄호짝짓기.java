
/* D4.1218. 괄호 짝짓기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD&categoryId=AV14eWb6AAkCFAYD&categoryType=CODE&problemTitle=1218&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 10;
		for (int t = 1; t <= T; t++) {
			Stack<Character> st = new Stack<>();
			int n = scan.nextInt();
			String s = scan.next();
			char c = ' ';
			for (int i = 0; i < n; i++) {
				c = s.charAt(i);
				if (!st.empty() && st.peek() == '{' && c == '}') {
					st.pop();
				} else if (!st.empty() && st.peek() == '[' && c == ']') {
					st.pop();
				} else if (!st.empty() && st.peek() == '<' && c == '>') {
					st.pop();
				} else if (!st.empty() && st.peek() == '(' && c == ')') {
					st.pop();
				} else {
					st.push(c);
				}
			}
			int ans = 0;
			if (st.empty()) {
				ans = 1;
			} else {
				ans = 0;
			}

			System.out.println("#" + t + " " + ans);
		}
	}

}
