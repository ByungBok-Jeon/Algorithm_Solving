
/* 1600번 말이되고픈원숭이
 * 출처 : https://www.acmicpc.net/problem/1600
 * Baekjoon Online Judge  문제
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_1600_말이되고픈원숭이 {
	static int K, W, H;
    static int[][] map;
    static boolean[][][] visit;
    // 동서남북 좌우상하(말)
    static int[] dr = {1,-1, 0, 0};
    static int[] dc = {0, 0, 1, -1}; 
    static int[] hr = {-2, -2, 2, 2, 1, -1, 1, -1};
    static int[] hc = {1, -1, 1, -1, 2, 2, -2, -2};
    static class Monkey{
        int r;
        int c;
        int cnt;
        int k;
        
        Monkey(int r, int c, int cnt, int k){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.k = k;
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        K = scan.nextInt();
        W = scan.nextInt();
        H = scan.nextInt();
        
        map = new int[H][W];
        visit = new boolean[H][W][31];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        visit[0][0][0] = true;
        solve();
        scan.close();
    }

	static void solve() {
		Queue<Monkey> que = new LinkedList<>();
		que.offer(new Monkey(0,0,0,K));
		while(!que.isEmpty()) {
			Monkey now = que.poll();
			int r = now.r;
			int c = now.c;
			int cnt = now.cnt;
			int k = now.k;
			if(r==H-1 && c==W-1) {
				System.out.println(cnt);
				return;
			}
			if(!isIn(r,c)) continue;
			if(map[r][c] == 1) continue;
			if(visit[r][c][k]) continue;
			visit[r][c][k] = true;
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				que.offer(new Monkey(nr,nc,cnt+1,k));
			}
			if(k == 0) continue;
			for (int d = 0; d < 8; d++) {
				int nr = r+hr[d];
				int nc = c+hc[d];
				que.offer(new Monkey(nr,nc,cnt+1,k-1));
			}
			
		}
		System.out.println("-1");
	}

	static boolean isIn(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}
	

}
