
/* Gold3 14621번 나만안되는연애
 * 출처 : https://www.acmicpc.net/problem/14621
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_G3_14621_나만안되는연애 {
	
	static int N,M;
	static int[] p;
	static int[] r;
	static char[] mw;
	static int ans;
	static List<Edge> list;
	
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int cost;
		
		public Edge(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mw = new char[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			mw[i] = st.nextToken().charAt(0);
		}
		makeSet();
		list = new ArrayList<>();
		ans = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int dis  = Integer.parseInt(st.nextToken());
			if(mw[u]!=mw[v]) {
				list.add(new Edge(u,v,dis));
			}

		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			Edge now = list.get(i);
			if(!isConnect(now.x,now.y)) {
				union(now.x,now.y);
				ans+=now.cost;
			}
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(find(p[i]));
		}
		if(set.size()!=1) System.out.println(-1);
		else System.out.println(ans);
	}


	private static void makeSet() {
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
		r = new int[N];
		Arrays.fill(r, 1);
	}
	
	static int find(int x) {
		if(p[x] == x) return x;
		return p[x] = find(p[x]);
	}
	
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py) return;
		
		if(r[px]>r[py]) {
			p[py] = px;
			r[px] += py;
		}else {
			p[px] = py;
			r[py] += px;
		}
	}
	
	static boolean isConnect(int x, int y) {
		return find(x)==find(y);
	}

}
