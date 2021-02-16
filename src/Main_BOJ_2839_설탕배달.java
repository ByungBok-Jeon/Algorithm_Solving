
/* 2839번 설탕 배달
 * 출처 : https://www.acmicpc.net/problem/2839
 * Baekjoon Online Judge  문제
 */
import java.util.Scanner;

public class Main_BOJ_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int ans = 0;
		while (true) {
			if (N % 5 == 0) {
				N -= 5;
				ans++;
			} else if (N % 3 == 0) {
				N -= 3;
				ans++;
			} else if (N > 5) {
				N -= 5;
				ans++;
			} else if (N > 3) {
				N -= 3;
				ans++;
			} else if (N != 0) {
				ans = -1;
				break;
			}
			if (N == 0)
				break;
		}
		System.out.println(ans);
	}
}
