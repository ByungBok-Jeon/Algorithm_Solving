
/* D3.1206. View
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh&categoryId=AV134DPqAA8CFAYh&categoryType=CODE&problemTitle=1206&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_10804_문자열의거울상 {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			char[] s = br.readLine().toCharArray();
			for (int i = 0; i < s.length; i++) {
				switch (s[i]) {
				case 'b':
					s[i] = 'd';
					break;
				case 'd':
					s[i] = 'b';
					break;
				case 'p':
					s[i] = 'q';
					break;
				case 'q':
					s[i] = 'p';
					break;
				default:
					break;
				}
			}
			for (int i = 0; i < s.length/2; i++) {
				char tmp = s[i];
				s[i] = s[s.length-1-i];
				s[s.length-1-i] = tmp;
			}
			System.out.print("#"+t+ " ");
			for (int i = 0; i < s.length; i++) {
				System.out.print(s[i]);
			}
			System.out.println();
		}

	}

}
