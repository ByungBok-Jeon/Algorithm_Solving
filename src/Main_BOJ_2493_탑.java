
/* 2493번 탑
 * 출처 : https://www.acmicpc.net/problem/2493
 * Baekjoon Online Judge  문제
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_2493_탑 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stackIdx = new Stack<>();
		st = new StringTokenizer(br.readLine());
		stack.push(Integer.parseInt(st.nextToken()));
		stackIdx.push(0);
		bw.write("0");
		for (int i = 1; i < N; i++) {
			int tower = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek() <= tower) {
				stack.pop();
				stackIdx.pop();
			}
			if (stack.empty()) {
				bw.write(" 0");
			} else {
				bw.write(" " + (stackIdx.peek() + 1));
			}
			stack.push(tower);
			stackIdx.push(i);
		}
		bw.flush();
		bw.close();

	}
}
