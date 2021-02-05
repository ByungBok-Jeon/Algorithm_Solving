
/* D3.3499. 퍼펙트 셔플
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW&categoryId=AWGsRbk6AQIDFAVW&categoryType=CODE&problemTitle=3499&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플 {
	static int T;
	static int N;
	static String[] s1;
	static String[] s2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			s1 = new String[N];
			s2 = new String[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				s1[i] = st.nextToken();
			}
			s2 = perfectShupple(s1);
			bw.write("#" + t);
//			System.out.printf("#%d", t);
			for (String s : s2) {
				bw.write(" " + s);
			}
			bw.newLine();

		}
		bw.flush();
		bw.close();

	}

	static String[] perfectShupple(String[] s) {
		int half = (int) Math.round(N / 2.0);
		String[] tmps = new String[N];
		for (int i = 0; i < half; i++) {
			tmps[i * 2] = s[i];
		}
		int start = 1;
		for (int i = half; i < N; i++) {
			tmps[start] = s[i];
			start += 2;
		}
		return tmps.clone();
	}

}
