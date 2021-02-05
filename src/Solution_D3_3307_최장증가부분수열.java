
/* D3.3307. 최장 증가 부분 수열
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr&categoryId=AWBOKg-a6l0DFAWr&categoryType=CODE&problemTitle=3307&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_3307_최장증가부분수열 {
	static int T;
	static int N;
	static int[] num;
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			cnt = new int[N];
			Arrays.fill(cnt, 1);
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = N - 2; i >= 0; i--) {
				int max = 1;
				boolean up = false;
				for (int j = N - 1; j > i; j--) {
					if (num[j] > num[i]) {
						max = Math.max(max, cnt[j]);
						up = true;
					}
				}
				if (up) {
					cnt[i] += max;
				}
			}
			int ans = 0;
			for (int i = 0; i < N; i++) {
				ans = Math.max(ans, cnt[i]);
			}
			bw.write("#" + t + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
