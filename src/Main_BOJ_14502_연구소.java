
/* 14502번 연구소
 * 출처 : https://www.acmicpc.net/problem/14502
 * Baekjoon Online Judge  문제
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_14502_연구소 {
	static int N,M;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};//상하좌우
	static int ans;
	static List<rc> zero = new ArrayList<>();
	
	static class rc{
		int r;
		int c;
		public rc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
				if(map[i][j] == 0) zero.add(new rc(i,j));
			}
		}
		ans = 0;
		for (int i = 0; i < zero.size()-2; i++) {
			for (int j = i+1; j < zero.size()-1; j++) {
				for (int k = j+1; k < zero.size(); k++) {
					int[][] tmpMap = new int[N][M];
					for (int l = 0; l < N; l++) {
						for (int m = 0; m < M; m++) {
							tmpMap[l][m] = map[l][m];
						}
					}
					rc a = zero.get(i);
					rc b = zero.get(j);
					rc c = zero.get(k);
					tmpMap[a.r][a.c] = 1;
					tmpMap[b.r][b.c] = 1;
					tmpMap[c.r][c.c] = 1;
					tmpMap = bfs(tmpMap);
					int sum = 0;
					for (int l = 0; l < N; l++) {
						for (int m = 0; m < M; m++) {
							if(tmpMap[l][m] == 0) {
								sum+=1;
							}
						}
					}
					ans = Math.max(ans, sum);
				}
			}
		}
		System.out.println(ans);
		scan.close();
	}
	static int[][] bfs(int[][] m) {
		boolean[][] v = new boolean[N][M];
		Queue<rc> que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(m[i][j] == 2) {
					que.offer(new rc(i,j));
					v[i][j] = true;
				}
			}
		}
		while(!que.isEmpty()) {
			rc now = que.poll();
			int r = now.r;
			int c = now.c;
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!isIn(nr,nc)) continue;
				if(m[nr][nc]!=0) continue;
				if(v[nr][nc]) continue;
				v[nr][nc] = true;
				m[nr][nc] = 2;
				que.offer(new rc(nr,nc));
			}
			
		}
		return m;
	}
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
