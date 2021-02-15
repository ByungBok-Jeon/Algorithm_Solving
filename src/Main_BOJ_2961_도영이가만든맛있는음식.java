
/* 2961번 도영이가만든맛있는음식
 * 출처 : https://www.acmicpc.net/problem/2961
 * Baekjoon Online Judge  문제
 */
import java.util.Scanner;

public class Main_BOJ_2961_도영이가만든맛있는음식 {
	static int N;
	static int[] sin;
	static int[] sseun;
	static long min;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		sin = new int[N];
		sseun = new int[N];
		for (int i = 0; i < N; i++) {
			sin[i] = scan.nextInt();
			sseun[i] = scan.nextInt();
		}
		min = Long.MAX_VALUE;
		sbs(0, 1, 0);
		System.out.println(min);
	}

	private static void sbs(int cnt, long sinSum, long sseunSum) {
		if (cnt == N) {
			if (sinSum == 1 && sseunSum == 0)
				return;
			long gap = sinSum - sseunSum;
			if (gap < 0)
				gap = -gap;
			min = Math.min(min, gap);
			return;
		}
		sbs(cnt + 1, sinSum * sin[cnt], sseunSum + sseun[cnt]);
		sbs(cnt + 1, sinSum, sseunSum);
	}
}
