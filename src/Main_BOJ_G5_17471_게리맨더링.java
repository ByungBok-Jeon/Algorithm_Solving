
/* Gold5 17471번 게리맨더링
 * 출처 : https://www.acmicpc.net/problem/17471
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_G5_17471_게리맨더링 {
	static int N;
	static int[] popul;
	static List<List<Integer>> graph;
	static List<Integer> list1,list2;
	static boolean[] v;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		popul = new int[N];
		for (int i = 0; i < N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		graph = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken())-1);
			}
		}
		v = new boolean[N];
		ans = Integer.MAX_VALUE;
		powerSet(0);
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	
	private static void powerSet(int cnt) {
		if(cnt==N) {
			list1 = new ArrayList<>();
			list2 = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if(v[i]) list1.add(i);
				else list2.add(i);
			}
			simulation();
			return;
		}
		v[cnt] = false;
		powerSet(cnt+1);
		v[cnt] = true;
		powerSet(cnt+1);
		
	}
	
	private static void simulation() {
		if(list1.size()==0 || list2.size()==0) return;
		if(isConnect(list1) && isConnect(list2)) {
			int pop1=0,pop2=0;
			for (int i = 0; i < list1.size(); i++) {
				pop1+=popul[list1.get(i)];
			}
			for (int i = 0; i < list2.size(); i++) {
				pop2+=popul[list2.get(i)];
			}
			ans = Math.min(ans, Math.abs(pop1-pop2));
		}
	}
	
	private static boolean isConnect(List<Integer> l) {
		boolean[] visited = new boolean[N];
		Queue<Integer> que = new LinkedList<>();
		que.offer(l.get(0));
		visited[l.get(0)] = true;
		int tot = 1;
		while(!que.isEmpty()) {
			int idx = que.poll();
			for (int i = 0; i < graph.get(idx).size(); i++) {
				int tmp = graph.get(idx).get(i);
				if(l.contains(tmp) && !visited[tmp] ) {
					que.offer(tmp);
					visited[tmp] = true;
					tot++;
				}
			}
			if(tot==l.size()) return true;
		}
		return false;
	}
}
