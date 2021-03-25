
/* D6.1263. 사람네트워크2
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18P2B6Iu8CFAZN&categoryId=AV18P2B6Iu8CFAZN&categoryType=CODE&problemTitle=1263&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D6_1263_사람네트워크2 {
	static final int INF = 9999999;
	static int T;
	static int N;
	static int[][] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			graph = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && graph[i][j] == 0) {
						graph[i][j] = INF;
					}
				}
			}
			
			for (int k = 0; k < N; ++k) {
				for (int i = 0; i < N; ++i) {
					if(k==i) continue;
					for (int j = 0; j < N; ++j) {
						if(k==j && i==j) continue;
						if(graph[i][j] > graph[i][k] + graph[k][j]) {
							graph[i][j] = graph[i][k] + graph[k][j];
						}
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int tmp = 0;
				for (int j = 0; j < N; j++) {
					tmp += graph[i][j];
				}
				min = Math.min(min, tmp);
			}
			System.out.println("#"+t+" "+ min);
		}
		
	}

}
