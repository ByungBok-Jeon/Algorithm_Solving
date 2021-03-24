
/* 17086번 아기상어2
 * 출처 : https://www.acmicpc.net/problem/17086
 * Baekjoon Online Judge  문제
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_BOJ_17086_아기상어2 {
	static int N,M;
	static int[][] map;
	
	static class Shark{
		int x;
		int y;
		public Shark(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static List<Shark> sharkList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][M];
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
				if(map[i][j]==1) {
					sharkList.add(new Shark(i,j));
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) continue;
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < sharkList.size(); k++) {
					Shark s = sharkList.get(k);
					min = Math.min(min, Math.max(Math.abs(i-s.x), Math.abs(j-s.y)));
				}
				max = Math.max(max, min);
			}
		}
		System.out.println(max);
		scan.close();
	}

}
