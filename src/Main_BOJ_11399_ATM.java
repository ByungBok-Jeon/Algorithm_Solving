
/* 11399번 ATM
 * 출처 : https://www.acmicpc.net/problem/11399
 * Baekjoon Online Judge  문제
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_11399_ATM {
	static int N;
	static int[] time;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ans = 0;
		N = scan.nextInt();
		time = new int[N];
		for (int i = 0; i < N; i++) {
			time[i] = scan.nextInt();
		}
		Arrays.sort(time);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				ans += time[j];
			}
		}
		System.out.println(ans);
	}
}
