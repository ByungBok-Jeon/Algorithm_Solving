
/* D4.1238. Contact
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE&problemTitle=1238&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1238_Contact {
	static int T = 10;
	static int len, start;
	static boolean[][] graph;
	static int[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			graph = new boolean[101][101];
			v = new int[101];
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from][to] = true;
			}
			Queue<Integer> que = new LinkedList<>();
			Queue<Integer> tmpQue = new LinkedList<>();

			que.offer(start);
			int level = 1;
			v[start] = level++;

			while (!que.isEmpty()) {
				tmpQue.clear();
				int qSize = que.size();
				for (int i = 0; i < qSize; i++) {
					int tmp = que.poll();
					for (int j = 1; j < 101; j++) {
						if (v[j] == 0 && graph[tmp][j]) {
							tmpQue.offer(j);
							v[j] = level;
						}
					}
				}
				while (!tmpQue.isEmpty()) {
					que.offer(tmpQue.poll());
				}
				level++;
			}
			for (int i = 1; i < 101; i++) {
				if (v[i] == level - 2) {
					ans = Math.max(ans, i);
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}