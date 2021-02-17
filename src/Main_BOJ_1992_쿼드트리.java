
/* 1992번 쿼드트리
 * 출처 : https://www.acmicpc.net/problem/1992
 * Baekjoon Online Judge  문제
 */
import java.util.Scanner;

public class Main_BOJ_1992_쿼드트리 {
	static int N;
	static char[][] map;
	static int[] dr = { 0, 0, 1, 1 };
	static int[] dc = { 0, 1, 0, 1 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = scan.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		qt(N, 0, 0);
	}

	static void qt(int n, int rIdx, int cIdx) {
		char num = map[rIdx][cIdx];
		if (n == 1) {
			System.out.print(num);
			return;
		}
		boolean same = true;
		L1: for (int i = rIdx; i < rIdx + n; i++) {
			for (int j = cIdx; j < cIdx + n; j++) {
				if (num != map[i][j]) {
					same = false;
					break L1;
				}
			}
		}
		if (same)
			System.out.print(num);
		else {
			System.out.print("(");
			for (int i = 0; i < 4; i++) {
				qt(n / 2, rIdx + dr[i] * n / 2, cIdx + dc[i] * n / 2);
			}
			System.out.print(")");
		}
	}
}
