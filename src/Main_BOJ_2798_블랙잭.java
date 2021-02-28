
/* 2798번 블랙잭
 * 출처 : https://www.acmicpc.net/problem/2798
 * Baekjoon Online Judge  문제
 */
import java.util.Scanner;

public class Main_BOJ_2798_블랙잭 {
	static int N,M;
	static int[] card;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = scan.nextInt();
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					int sum = card[i]+card[j]+card[k];
					if(sum<=M) {
						ans = Math.max(ans, sum);
					}
				}
			}
		}
		System.out.println(ans);
	}
}
