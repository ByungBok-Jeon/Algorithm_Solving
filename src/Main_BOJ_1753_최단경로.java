
/* 1753번 최단경로
 * 출처 : https://www.acmicpc.net/problem/1753
 * Baekjoon Online Judge  문제
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_1753_최단경로 {
	static int V, E;
	static int K;
	static int u,v,w;
	static List<List<node>> graph;
	static int[] min;
	static boolean[] visited;
	
	static class node implements Comparable<node>{
		int index;
		int weight;
		public node(int index,int weight){
			this.index=index;
			this.weight=weight;
		}
		@Override
		public int compareTo(node o) {
			return this.weight-o.weight;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		V = scan.nextInt();
		E = scan.nextInt();
		K = scan.nextInt()-1;
		graph = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}
		min = new int[V];
		visited = new boolean[V];
		Arrays.fill(min, Integer.MAX_VALUE);
		
		for (int i = 0; i < E; i++) {
			u = scan.nextInt()-1;
			v = scan.nextInt()-1;
			w = scan.nextInt();
			graph.get(u).add(new node(v,w));
		}
		Queue<node> pq = new PriorityQueue<>();
		min[K] = 0;
		pq.add(new node(K,0));
		while(!pq.isEmpty()) {
			int now = pq.poll().index;
			if(visited[now]) continue;
			visited[now] = true;
			
			for(node n : graph.get(now)) {
                if(min[n.index] > min[now] + n.weight) {
                	min[n.index] = min[now] + n.weight;
                    pq.add(new node(n.index, min[n.index]));
                }
            }
		}
		for (int i = 0; i < V; i++) {
			if(min[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(min[i]);
			}
		}
		scan.close();
	}
}
