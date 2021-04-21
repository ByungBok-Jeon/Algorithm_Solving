
/* Lv3. 네트워크
 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/43162
 * 프로그래머스 문제
 */

import java.util.HashSet;
import java.util.Set;

public class Solution_PR_Lv3_네트워크 {
	static int[] p;
	public static void main(String[] args) {
		int n = 5;
		int[][] computers = {{1, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 1}, {1, 0, 0, 0, 1}};
		System.out.println(solution(n,computers));
	}
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        makeSet(n);
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i==j) continue;
				if(computers[i][j]==1) {
					computers[j][i]=1;
				}
			}
		}
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i==j) continue;
				if(computers[i][j]==1) {
					computers[j][i]=1;
					union(i,j);
				}
			}
		}
        for (int i = 0; i < n; i++) {
			p[i] = find(p[i]);
		}
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
			set.add(p[i]);
		}
        answer = set.size();
        return answer;
    }
	static int find(int x) {
		if(x==p[x]) return x;
		return p[x] = find(p[x]);
	}
	
	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py) return;
		p[px] = py;
	}
	private static void makeSet(int n) {
		p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
	}
	
	

}
