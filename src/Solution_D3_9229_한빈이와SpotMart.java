
/* D3.9229. 한빈이와 Spot Mart
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN&categoryId=AW8Wj7cqbY0DFAXN&categoryType=CODE&problemTitle=%ED%95%9C%EB%B9%88&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_9229_한빈이와SpotMart {

	static int T;
	static int N;
	static long M;
	static int[] snack;
	static int[] ans;
	static long max;
	static boolean impossible;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			max = 0L;
			ans = new int[2];
			impossible = true;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			nCr(0, 0);
			if (impossible) {
				max = -1;
			}
			bw.write("#" + t + " " + max);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	static void nCr(int start, int cnt) {
		if (cnt == 2) {
			if (ans[0] + ans[1] <= M) {
				max = Math.max(max, ans[0] + ans[1]);
				impossible = false;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			ans[cnt] = snack[i];
			nCr(i + 1, cnt + 1);
		}
	}
}
