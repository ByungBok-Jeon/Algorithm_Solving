
/* D4.1251. 하나로
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD&categoryId=AV15StKqAQkCFAYD&categoryType=CODE&problemTitle=1251&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로 {
	static int T;
	static int N;
	static double E;
	static int[] p;
	static int[] r;
	static List<Long> listX = new ArrayList<>();
	static List<Long> listY = new ArrayList<>();
	
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		double c;
		public Edge(int a, int b, double c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.c, e.c);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			listX.clear();
			listY.clear();
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				listX.add(Long.parseLong(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				listY.add(Long.parseLong(st.nextToken()));
			}
			E = Double.parseDouble(br.readLine());
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					double wei = Math.pow(listX.get(i)-listX.get(j),2) + Math.pow(listY.get(i)-listY.get(j),2);
					pq.offer(new Edge(i,j,E*wei));
					pq.offer(new Edge(j,i,E*wei));
				}
			}
			makeSet();
			double sum = 0.0;
			while(!pq.isEmpty()) {
				Edge now = pq.poll();
				if(!isConnect(now.a, now.b)) {
					union(now.a, now.b);
					sum += now.c;
				}
			}
			System.out.println("#"+t+" " + Math.round(sum));
		}
	}
	
	
	static void makeSet() {
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
		r = new int[N];
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
