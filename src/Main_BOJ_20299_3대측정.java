
/* 20299번 3대측정
 * 출처 : https://www.acmicpc.net/problem/20299
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_20299_3대측정 {
	static int N;
	static int S;
	static int M;
	static Queue<Integer> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int stu1 = Integer.parseInt(st.nextToken());
			int stu2 = Integer.parseInt(st.nextToken());
			int stu3 = Integer.parseInt(st.nextToken());
			if (stu1 + stu2 + stu3 >= S && stu1 >= M && stu2 >= M && stu3 >= M) {
				queue.offer(stu1);
				queue.offer(stu2);
				queue.offer(stu3);
				cnt++;
			}
		}
		bw.write("" + cnt);
		bw.newLine();
		while (!queue.isEmpty()) {
			bw.write(queue.poll() + " ");
		}
		bw.flush();
		bw.close();
	}
}
