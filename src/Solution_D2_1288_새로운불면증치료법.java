
/* D2.1288. 새로운 불면증 치료법
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV18_yw6I9MCFAZN&categoryId=AV18_yw6I9MCFAZN&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=2&pageSize=10&pageIndex=3
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D2_1288_새로운불면증치료법 {
	static int T;
	static int N;
	static boolean[] num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			num = new boolean[10];
			N = Integer.parseInt(br.readLine());
			int cnt = 1;
			String s = "";
			while (!isFull()) {
				s = Integer.toString(N * cnt);
				for (int i = 0; i < s.length(); i++) {
					int idx = s.charAt(i) - '0';
					if (!num[idx]) {
						num[idx] = true;
					}

				}
				cnt++;
			}
			bw.write("#" + t + " " + s);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	private static boolean isFull() {
		for (int i = 0; i < num.length; i++) {
			if (!num[i]) {
				return false;
			}
		}
		return true;
	}

}
