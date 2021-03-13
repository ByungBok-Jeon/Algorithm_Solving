
/* D3.1230. 암호문3
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV14zIwqAHwCFAYD&categoryId=AV14zIwqAHwCFAYD&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1 
 * SW Expert Acadamy 문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D3_1230_암호문3 {
	static int T = 10;
	static int N;
	static ArrayList<String> password;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			password = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				password.add(st.nextToken());
			}
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				char command = st.nextToken().charAt(0);
				int x = 0;
				int y = 0;
				String[] tmp;
				switch (command) {
				case 'I':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					tmp = new String[y];
					for (int j = 0; j < y; j++) {
						tmp[j] = st.nextToken();
					}
					for (int j = y - 1; j >= 0; j--) {
						password.add(x, tmp[j]);
					}
					break;
				case 'D':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						password.remove(x);
					}
					break;
				case 'A':
					y = Integer.parseInt(st.nextToken());
					tmp = new String[y];
					for (int j = 0; j < y; j++) {
						tmp[j] = st.nextToken();
					}
					for (int j = y - 1; j >= 0; j--) {
						password.add(tmp[j]);
					}
					break;
				default:
					break;
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(password.get(i) + " ");
			}
			System.out.println();
		}
	}
}