
/* 16562번 친구비
 * 출처 : https://www.acmicpc.net/problem/16562
 * Baekjoon Online Judge  문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_16562_친구비 {
	static int N,M,k;
	static int[] student;
	static int[] smoney;
	static int[] rank;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		student = new int[N+1];
		smoney = new int[N+1];
		rank = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			student[i] = i;
			smoney[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		ArrayList<Integer> group = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			int pi = find(student[i]);
			if(!group.contains(pi)) {
				group.add(pi);
			}
		}
		int[] minMoneyList = new int[group.size()];
		Arrays.fill(minMoneyList, Integer.MAX_VALUE);
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < group.size(); j++) {
				int pi = find(student[i]);
				if(pi==group.get(j)) {
					minMoneyList[j] = Math.min(minMoneyList[j], smoney[i]);
					break;
				}
			}
		}
		int total = 0;
		for (int i = 0; i < minMoneyList.length; i++) {
			total += minMoneyList[i];
		}
		if(total>k) {
			System.out.println("Oh no");
		}else {
			System.out.println(total);
		}
	}
	
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px==py) return;
		if(rank[px]>=rank[py]) {
			student[py] = px;
			rank[px] += rank[py];
		}else {
			student[px] = py;
			rank[py] += rank[px];
		}
		
	}
	static int find(int x) {
		if(x==student[x]) return x;
		return student[x] = find(student[x]);
	}

}
