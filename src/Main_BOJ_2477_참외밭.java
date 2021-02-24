
/* 2477번 참외밭
 * 출처 : https://www.acmicpc.net/problem/2477
 * Baekjoon Online Judge  문제
 */
import java.util.Scanner;

public class Main_BOJ_2477_참외밭 {
	static int N;
	static int[][] map;

	public static void main(String[] args) {
		int s1 = 0;
		int s1Idx = 0;
		int s2 = 0;
		int s3 = 0;
		int s4 = 0;
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[6][2];
		for (int i = 0; i < 6; i++) {
			map[i][0] = scan.nextInt();
			map[i][1] = scan.nextInt();
			if (s1 < map[i][1]) {
				s1 = map[i][1];
				s1Idx = i;
			}
		}
		if (map[check(s1Idx + 1)][1] > map[check(s1Idx - 1)][1]) {
			s2 = map[check(s1Idx + 1)][1];
			s3 = map[check(s1Idx - 1)][1];
			s4 = map[check(s1Idx + 2)][1];
		} else {
			s2 = map[check(s1Idx - 1)][1];
			s3 = map[check(s1Idx + 1)][1];
			s4 = map[check(s1Idx - 2)][1];
		}
		int area = s1 * s2 - (s1 - s4) * (s2 - s3);
		System.out.println(area * N);
	}

	static int check(int n) {
		if (n < 0)
			return 6 + n;
		else if (n > 5)
			return n % 6;
		else
			return n;
	}

}
