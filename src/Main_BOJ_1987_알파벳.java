
/* 1987번 알파벳
 * 출처 : https://www.acmicpc.net/problem/1987
 * Baekjoon Online Judge  문제
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main_BOJ_1987_알파벳 {
	static int R;
	static int C;
	static char[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int max;
	static ArrayList<Character> alphabet;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		R = scan.nextInt();
		C = scan.nextInt();
		alphabet = new ArrayList<>();
		map = new char[R][C];
		max = 0;
		for (int i = 0; i < R; i++) {
			String s = scan.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		go(1, 0, 0);
		System.out.println(max);
		scan.close();
	}

	static void go(int cnt, int r, int c) {
		alphabet.add(map[r][c]);
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!isIn(nr, nc) || alphabet.contains(map[nr][nc]))
				continue;
			go(cnt + 1, nr, nc);
			alphabet.remove(alphabet.size() - 1);
		}
		max = Math.max(max, cnt);
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
