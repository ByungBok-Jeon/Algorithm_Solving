
/* D2.1940. 가랏! RC카!
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PjMgaALgDFAUq&categoryId=AV5PjMgaALgDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=2&pageSize=10&pageIndex=3
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D2_1940_가랏RC카 {
	static int T;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int tot = 0;
			int speed = 0;
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				if (command == 0) {
					tot += speed;
					continue;
				}
				int acc = Integer.parseInt(st.nextToken());
				if (command == 1) {
					speed += acc;
				} else if (command == 2) {
					speed -= acc;
					if (speed < 0) {
						speed = 0;
						continue;
					}
				}

				tot += speed;

			}
			bw.write("#" + t + " " + tot);
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

}
