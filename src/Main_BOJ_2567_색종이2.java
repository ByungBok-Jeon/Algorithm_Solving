
/* 2567번 색종이2
 * 출처 : https://www.acmicpc.net/problem/2567
 * Baekjoon Online Judge  문제
 */
import java.util.Scanner;

public class Main_BOJ_2567_색종이2 {
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[102][102];
		int ans = 0;
		for (int n = 0; n < N; n++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					map[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if(i+1<102 && map[i][j] != map[i+1][j]) {
					ans++;
				}
			}
		}
		for (int j = 0; j < 102; j++) {
			for (int i = 0; i < 102; i++) {
				if(j+1<102 && map[i][j] != map[i][j+1]) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
