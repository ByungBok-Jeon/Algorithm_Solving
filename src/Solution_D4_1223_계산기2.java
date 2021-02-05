
/* D4.1223. 계산기2
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14nnAaAFACFAYD&categoryId=AV14nnAaAFACFAYD&categoryType=CODE&problemTitle=1223&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution_D4_1223_계산기2 {
	static int T = 10;
	static int N;
	static Stack<Character> stack;
	static Stack<Integer> calcStack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			stack = new Stack<>();
			calcStack = new Stack<>();
			String s = br.readLine();
			String s2 = "";
			for (int i = 0; i < N; i++) {
				if (s.charAt(i) != '+' && s.charAt(i) != '*') {
					s2 += s.charAt(i);
					continue;
				}
				if (!stack.isEmpty() && s.charAt(i) == '+') {
					while (!stack.isEmpty()) {
						s2 += stack.pop();
					}
				}
				stack.push(s.charAt(i));
			}
			while (!stack.isEmpty()) {
				s2 += stack.pop();
			}
			calc(s2);
			bw.write("#" + t + " " + calcStack.pop());
			bw.newLine();
			bw.flush();
		}

		bw.close();

	}

	static void calc(String s) {
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == '+') {
				int tmp = calcStack.pop() + calcStack.pop();
				calcStack.push(tmp);
			} else if (s.charAt(i) == '*') {
				int tmp = calcStack.pop() * calcStack.pop();
				calcStack.push(tmp);
			} else {
				calcStack.push(s.charAt(i) - '0');
			}
		}
	}
}
