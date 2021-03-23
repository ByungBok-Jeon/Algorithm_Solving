
/* D4.3124. 최소스패닝트리
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리 {
	
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int c;
		public Edge(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.c, e.c);
		}
	}
	static int T;
	static int V, E;
	static int[] p;
	static int[] r;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				pq.offer(new Edge(A-1, B-1, C));
				
			}
			makeSet();
			long sum = 0L;
			while(!pq.isEmpty()) {
				Edge now = pq.poll();
				if(!isConnect(now.a, now.b)) {
					union(now.a,now.b);
					sum += now.c;
				}
			}
			System.out.println("#"+t+" " + sum);
		}

	}
	static void makeSet() {
		p = new int[V];
		for (int i = 0; i < V; i++) {
			p[i] = i;
		}
		r = new int[V];
		Arrays.fill(r, 1);
	}
	
	static int find(int x) {
		if(x==p[x]) return x;
		return p[x] = find(p[x]);
	}
	
	static boolean isConnect(int x, int y) {
		return find(x) == find(y);
	}
	
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py) return;
		
		if(r[px]>=r[py]) {
			p[py] = px;
			r[px] += r[py];
		}else {
			p[px] = py;
			r[py] += r[px];
		}
	}
}
