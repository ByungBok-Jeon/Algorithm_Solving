
/* D4.3289. 서로소집합
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr&categoryId=AWBJKA6qr2oDFAWr&categoryType=CODE&problemTitle=3289&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합 {
	static int T;
	static int n,m;
	static int[] set;
	static int[] R;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			set = new int[n+1];
			for (int i = 1; i <= n; i++) {
				set[i] = i;
			}
			R = new int[n+1];
			Arrays.fill(R, 1);
			
			System.out.print("#"+t+" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int comm = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(comm == 0) {
					union(x,y);
				}else if(comm ==1) {
					isConnect(x,y);
				}
			}
			System.out.println();
		}
	}

	private static void isConnect(int x, int y) {
		if(find(x)==find(y)) {
			System.out.print(1);
		}else {
			System.out.print(0);
		}
	}

	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px == py) {
			return;
		}
		if(R[px]>=R[py]) {
			set[py] = px;
			R[px]+= R[py];
		}else {
			set[px] = py;
			R[py]+= R[px];
		}
	}

	private static int find(int x) {
		if(x==set[x]) {
			return x;
		}
		return find(set[x]);
	}
}
