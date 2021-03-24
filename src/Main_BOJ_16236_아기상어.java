
/* 16236번 아기상어
 * 출처 : https://www.acmicpc.net/problem/16236
 * Baekjoon Online Judge  문제
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_16236_아기상어 {
	static int N;
	static int[][] map;
	static int[][] v;
	static Shark shark;
	static int cnt;
	static List<Fish> fishq = new ArrayList<>();
	//이동 추적할 물고기
	static List<Fish> ff = new ArrayList<>();
	
	static class Shark{
		int r;
		int c;
		int size;
		int quant;
		int time;
		public Shark(int r, int c, int size, int quant, int time) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			if(this.size == quant) {
				this.size++;
				this.quant = 0;
			}else {
				this.quant = quant;
			}
			this.time = time;
		}
		public Shark(){
			
		}
	}
	
	static class Fish implements Comparable<Fish>{
		int r;
		int c;
		int size;
		int d;
		
		public Fish(int r, int c, int size, int d) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.d = d;
		}
		public Fish() {
		}
		@Override
		public int compareTo(Fish f) {
			int r = Integer.compare(this.d, f.d);
			if(r==0) {
				int u = Integer.compare(this.r, f.r);
				if(u == 0) {
					int z = Integer.compare(this.c, f.c);
					return z;
				}else return u;
			}else return r;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scan.nextInt();
				if(map[i][j] == 9) {
					shark = new Shark(i,j,2,0,0);
				}
			}
		}
		cnt = 0;
		dfs();
		System.out.println(cnt);
		
		
		
		scan.close();

	}
	static int[] dr = {-1,1,0,0};//상하좌우
	static int[] dc = {0,0,-1,1};
	

	static void dfs() {
		fishq.clear();
		//물고기 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]>0 && map[i][j]<7) {
					fishq.add(new Fish(i,j,map[i][j],0));
				}
			}
		}
		ff.clear();
		//상어보다 작은 물고기를 가져와서 거리를 구함.
		for(Fish sfish : fishq) {
			if(sfish.size<shark.size) {
				int kk = distance(shark.r,shark.c,sfish.r,sfish.c,shark.size);
				if(kk!=-1) {
					sfish.d = kk;
					ff.add(sfish);
				}
			}
		}
		if(ff.size()==0) {
			return;
		}else {
			Collections.sort(ff);
			Fish tfish = ff.get(0);
			int distance = tfish.d;
			int tr = tfish.r;
			int tc = tfish.c;
			int sr = shark.r;
			int sc = shark.c;
			shark = new Shark(tr, tc, shark.size, shark.quant+1, shark.time+distance);
			map[sr][sc] = 0; // 원래 있던 상어위치 초기화
			map[tr][tc] = 9; // 먹힌 고기위치로 상어이동
			cnt = shark.time; // 총 이동거리
			dfs(); // 현재 상어부터 다시 시작
		}
	}

	static int distance(int sr, int sc, int er, int ec, int size) {
		int[][] b = new int[N][N];
		Queue<Fish> que = new LinkedList<>();
		que.offer(new Fish(sr,sc,size,0));
		b[sr][sc] = 1;
		while(!que.isEmpty()) {
			Fish cf = que.poll();
			int cr = cf.r;
			int cc = cf.c;
			int csize = cf.size;
			for (int d = 0; d < 4; d++) {
				int nr = cr+dr[d];
				int nc = cc+dc[d];
				if(!isIn(nr,nc)) continue;
				if(b[nr][nc]==0 && map[nr][nc]<=csize) {
					if(er == nr && ec==nc) {
						return b[cr][cc];
					}
					b[nr][nc] = b[cr][cc]+1;
					que.offer(new Fish(nr,nc,csize,0));
				}
			}
		}
		
		return -1;
	}

	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
