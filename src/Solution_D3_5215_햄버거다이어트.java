
/* D3.5215. 햄버거 다이어트
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT&categoryId=AWT-lPB6dHUDFAVT&categoryType=CODE&problemTitle=5215&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트 {
	static int T;
	static int N;
	static int L;
	static int[] score;
	static int[] cal;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N];
			cal = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			sbs(0, 0, 0);
			bw.write("#" + t + " " + ans);
			bw.newLine();
			bw.flush();
			ans = 0;
		}
		bw.close();
	}

	private static void sbs(int cnt, int sum, int sc) {
		if (cnt == N) {
			if (sum <= L) {
				ans = Math.max(ans, sc);
			}
			return;
		}
		sbs(cnt + 1, sum + cal[cnt], sc + score[cnt]);
		sbs(cnt + 1, sum, sc);
	}
}
