
/* D2.1859. 백만장자 프로젝트
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5LrsUaDxcDFAXc&categoryId=AV5LrsUaDxcDFAXc&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1859_백만장자프로젝트 {
	static int T, N;
	static int[] price;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			Long ans = 0L;
			N = Integer.parseInt(br.readLine());
			price = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			int max = price[N - 1];
			for (int i = N - 1; i > 0; i--) {
				if (max < price[i - 1])
					max = price[i - 1];
				else if (max > price[i - 1])
					ans += max - price[i - 1];
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
