
/* 17413번 단어뒤집기2
 * 출처 : https://www.acmicpc.net/problem/17413
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_BOJ_17413_단어뒤집기2 {
	static char[] input;
	static Stack<Character> stack;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		stack = new Stack<>();
		String s = br.readLine();
		input = s.toCharArray();
		for (int i = 0; i < input.length; i++) {
			if(input[i] == '<') {
				while(!stack.isEmpty()) {
					bw.write(stack.pop());
				}
				while(input[i]!='>') {
					bw.write(input[i++]);
				}
				bw.write('>');
				continue;
			}else if(input[i] == ' ') {
				while(!stack.isEmpty()) {
					bw.write(stack.pop());
				}
				bw.write(' ');
				continue;
			}
			stack.push(input[i]);
			if(i == input.length-1) {
				while(!stack.isEmpty()) {
					bw.write(stack.pop());
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
