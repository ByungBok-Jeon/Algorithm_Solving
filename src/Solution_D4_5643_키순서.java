
/* D4.5643. 키순서
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo&categoryId=AWXQsLWKd5cDFAUo&categoryType=CODE&problemTitle=%ED%82%A4+%EC%88%9C%EC%84%9C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_5643_키순서 {
	static int T;
	static int N,M;
	static int[][] graph;
	static int[] up,down;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			up = new int[N];
			down = new int[N];
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken())-1;
				graph[r][c] = 1;
			}
			for (int i = 0; i < N; i++) {
				dfs(i,i,new boolean[N]);
			}
			ans = 0;
			for (int i = 0; i < N; i++) {
				if(up[i]+down[i]==N-1) {
					ans++;
				}
			}
			System.out.println("#"+t+" "+ans);
			
		}
		
	}
	private static void dfs(int now,int start, boolean[] v) {
		v[now] = true;
		
		for (int i = 0; i < N; i++) {
			if(!v[i] && graph[now][i]==1) {
				dfs(i,start,v);
				up[start]++;
				down[i]++;
			}
		}
	}
}
