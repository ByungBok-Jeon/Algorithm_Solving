
/* 1260번 DFS와BFS
 * 출처 : https://www.acmicpc.net/problem/1260
 * Baekjoon Online Judge  문제
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_1260_DFS와BFS {
	static int N, M, start;
	static boolean[] v;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		start = scan.nextInt();
		v = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			graph[from].add(to);
			graph[to].add(from);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		DFS(start);
		v = new boolean[N + 1];
		System.out.println();
		BFS(start);

		scan.close();
	}
	static void DFS(int s) {
		System.out.print(s + " ");
		v[s] = true;
		for (int i = 0; i < graph[s].size(); i++) {
			int node = graph[s].get(i);
			if (!v[node]) {
				DFS(node);
			}
		}
	}
	static void BFS(int s) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(s);
		v[s] = true;
		while (!que.isEmpty()) {
			int tmp = que.poll();
			System.out.print(tmp + " ");
			for (int i = 0; i < graph[tmp].size(); i++) {
				int node = graph[tmp].get(i);
				if (!v[node]) {
					que.offer(node);
					v[node] = true;
				}
			}
		}
	}
}
