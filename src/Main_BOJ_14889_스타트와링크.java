
/* 14889번 스타트와링크
 * 출처 : https://www.acmicpc.net/problem/14889
 * Baekjoon Online Judge  문제
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main_BOJ_14889_스타트와링크 {
	static int N;
	static int[][] map;
	static int[] team1;
	static ArrayList<Integer> team;
	static int ans;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		team = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			team.add(i);
		}
		team1 = new int[N / 2];
		ans = Integer.MAX_VALUE;
		nPr(0, 0);
		System.out.println(ans);
		scan.close();
	}

	private static void nPr(int start, int cnt) {
		if (cnt == N / 2) {
			int val1 = 0;
			int val2 = 0;
			for (int i = 0; i < team1.length; i++) {
				team.remove(team.indexOf(team1[i]));
			}
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					val1 += map[team1[i]][team1[j]];
					val2 += map[team.get(i)][team.get(j)];
				}
			}
			ans = Math.min(ans, Math.abs(val1 - val2));
			team.clear();
			for (int i = 0; i < N; i++) {
				team.add(i);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			team1[cnt] = team.get(i);
			nPr(i + 1, cnt + 1);
		}
	}
}
