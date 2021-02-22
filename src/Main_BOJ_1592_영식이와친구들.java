
/* 1592번 영식이와친구들
 * 출처 : https://www.acmicpc.net/problem/1592
 * Baekjoon Online Judge  문제
 */
import java.util.Scanner;

public class Main_BOJ_1592_영식이와친구들 {
	static int N;
	static int M;
	static int L;
	static int[] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		L = scan.nextInt();
		map = new int[N];

		map[0] = 1;
		int tmp = 0;
		while (true) {

			if (map[tmp] % 2 == 1) {
				tmp = (tmp + L) % N;
				map[tmp]++;

			} else if (map[tmp] % 2 == 0) {
				if (tmp - L < 0)
					tmp = tmp - L + N;
				else
					tmp = tmp - L;
				map[tmp]++;
			}
			if (map[tmp] == M)
				break;
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt += map[i];
		}
		System.out.println(cnt - 1);

	}

}
