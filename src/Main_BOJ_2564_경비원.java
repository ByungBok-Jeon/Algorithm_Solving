
/* 2564번 경비원
 * 출처 : https://www.acmicpc.net/problem/2564
 * Baekjoon Online Judge  문제
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_2564_경비원 {
	static int W;
	static int H;
	static int N;
	static int[] arr;
	static int[] idx;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		arr = new int[2 * (W + H)];
		idx = new int[N + 1];
		int cnt = 1;
		for (int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			switch (d) {
			case 1:
				arr[x] = cnt++;
				idx[i] = x;
				break;
			case 2:
				arr[2 * W + H - x] = cnt++;
				idx[i] = 2 * W + H - x;
				break;
			case 3:
				arr[2 * (W + H) - x] = cnt++;
				idx[i] = 2 * (W + H) - x;
				break;
			case 4:
				arr[W + x] = cnt++;
				idx[i] = W + x;
				break;
			}
		}
		int tot = 0;
		int dong = idx[N];
		for (int i = 0; i < N; i++) {
			int dis = Math.abs(dong - idx[i]);
			dis = Math.min(dis, 2 * (W + H) - dis);
			tot += dis;
		}
		bw.write("" + tot);
		bw.flush();
		bw.close();
	}

}
