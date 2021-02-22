
/* 10163번 색종이
 * 출처 : https://www.acmicpc.net/problem/10163
 * Baekjoon Online Judge  문제
 */
import java.util.Scanner;

public class Main_BOJ_10163_색종이 {
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		map = new int[101][101];
		N = scan.nextInt();
		int paper = 1;
		for (int n = 0; n < N; n++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			y = 100-y;
			int width = scan.nextInt();
			int height = scan.nextInt();
			for (int i = y; i > y-height; i--) {
				for (int j = x; j < x+width; j++) {
					map[i][j] = paper;
				}
			}
			paper++;
		}
		for (int n = 1; n < paper; n++) {
			int area = 0;
			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					if(map[i][j] == n) {
						area++;
					}
				}
			}
			System.out.println(area);
		}
	}
}
