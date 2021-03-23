
/* 1463번 1로 만들기
 * 출처 : https://www.acmicpc.net/problem/1463
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1463_1로만들기 {
	static int N;
	static int[] mem;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mem = new int[N+1];
		//로직
		for (int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			if(mem[i-1]+1 <min) {
				min = mem[i-1] + 1;
			}
			if(i>=2 && i%2 == 0 && mem[i/2]+1 < min) {
				min = mem[i/2]+1;
			}
			if(i>=3 && i%3 == 0 && mem[i/3]+1 < min) {
				min = mem[i/3]+1;
			}
			mem[i] = min;
		}
		System.out.println(mem[N]);
	}
}
