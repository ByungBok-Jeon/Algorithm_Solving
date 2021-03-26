
/* 17472번 다리만들기2
 * 출처 : https://www.acmicpc.net/problem/17472
 * Baekjoon Online Judge  문제
 */
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_17472_다리만들기2 {
	static int N,M;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};//상하좌우
	static int island;
	static PriorityQueue<Edge> pq;
	static int p[];
	static int r[];
	
	static class rc{
		int r;
		int c;
		public rc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int start;
		int fin;
		int weight;
		
		public Edge(int start, int fin, int weight) {
			this.start = start;
			this.fin = fin;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][M];
		island = 2;
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					bfs(i,j);
					island++;
				}
			}
		}
		findIsland();
		makeSet();
		int sum = 0;
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(!isConnect(now.start, now.fin)) {
				union(now.start,now.fin);
				sum += now.weight;
			}
		}
		boolean allConnect = true;
		for (int i = 2; i < island-1; i++) {
			for (int j = i+1; j < island; j++) {
				if(!isConnect(i, j)) allConnect = false;
			}
		}
		if(allConnect) {
			System.out.println(sum);
		}else {
			System.out.println("-1");
		}
		scan.close();
	}
	static int find(int x) {
		if(p[x] ==x) return x;
		return p[x] = find(p[x]);
	}

	static boolean isConnect(int x, int y) {
		return find(x) == find(y);
	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px == py) return;
		if(r[px]>=r[py]) {
			p[py] = px;
			r[px] += r[py];
		}else {
			p[px] = py;
			r[py] += r[px];
		}
		
	}

	static void makeSet() {
		p = new int[island];
		for (int i = 2; i < island; i++) {
			p[i] = i;
		}
		r = new int[island];
		for (int i = 2; i < island; i++) {
			r[i] = 1;
		}
		
	}

	static void findIsland() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int n = 2; n < island; n++) {
					if(map[i][j] == n){
						for (int d = 0; d < 4; d++) {
							int cnt = 0;
							int nr = i+dr[d];
							int nc = j+dc[d];
							while(true) {
								if(!isIn(nr,nc)) break;
								if(map[nr][nc] != 0) break;
								cnt++;
								nr += dr[d];
								nc += dc[d];
							}
							if(isIn(nr,nc) && map[nr][nc] != 0 && cnt>=2 && map[nr][nc] != n) {
								pq.offer(new Edge(map[i][j],map[nr][nc],cnt));
							}
						}
					}
				}
			}
		}
	}

	static void bfs(int r, int c) {
		Queue<rc> que = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		que.offer(new rc(r,c));
		v[r][c] = true;
		map[r][c] = island;
		while(!que.isEmpty()) {
			rc now = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = now.r+dr[d];
				int nc = now.c+dc[d];
				if(!isIn(nr,nc)) continue;
				if(map[nr][nc]!=1) continue;
				if(v[nr][nc]) continue;
				v[nr][nc] = true;
				map[nr][nc] = island;
				que.offer(new rc(nr,nc));
			}
			
		}
		
		
	}

	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
