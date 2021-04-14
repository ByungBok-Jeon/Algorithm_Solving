
/* Silver1 2564번 경비원
 * 출처 : https://www.acmicpc.net/problem/2564
 * Baekjoon Online Judge  문제
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_S1_2564_경비원 {
	static int M,N;
	static int stores;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		M = scan.nextInt()+1;
		N = scan.nextInt()+1;
		
		map = new int[N][M];
		stores = scan.nextInt();
		for (int i = 0; i <= stores; i++) {
			int dir = scan.nextInt();
			int dis = scan.nextInt();
			int a = 1;
			if(i==stores) a =2;
			switch (dir) {
			case 1:
				map[0][dis] = a;
				break;
			case 2:
				map[N-1][dis] = a;
				break;
			case 3:
				map[dis][0] = a;
				break;
			case 4:
				map[dis][M-1] = a;
				break;
			default:
				break;
			}
		}
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				map[i][j] = 3;
			}
		}
		ans = 0;
		bfs();
		System.out.println(ans);
		
		scan.close();
	}
	private static void bfs() {
		boolean[][] v = new boolean[N][M];
		Queue<int[]> que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==2) {
					que.offer(new int[] {i,j,0});
				}
			}
		}
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int r = now[0];
			int c = now[1];
			int time = now[2];
			if(v[r][c]) continue;
			v[r][c] = true;
			if(map[r][c] == 1) {
				ans+=time;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(isIn(nr,nc) && map[nr][nc]!=3) {
					que.offer(new int[] {nr,nc,time+1});
				}
				
			}
		}
		
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
