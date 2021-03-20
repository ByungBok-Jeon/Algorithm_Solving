
/* D3.10912. 외로운문자
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXVJuEvqLAADFASe&categoryId=AXVJuEvqLAADFASe&categoryType=CODE&problemTitle=10912&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_10912_외로운문자 {
	static int T;
	static char[] s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			s = br.readLine().toCharArray();
			for (int i = 0; i < s.length - 1; i++) {
				for (int j = i + 1; j < s.length; j++) {
					if (s[i] == s[j]) {
						s[i] = ' ';
						s[j] = ' ';
						break;
					}
				}
			}
			boolean good = true;
			for (int i = 0; i < s.length; i++) {
				if (s[i] != ' ') {
					good = false;
					break;
				}
			}
			System.out.print("#" + t + " ");
			if (!good) {
				Arrays.sort(s);
				for (int i = 0; i < s.length; i++) {
					if (s[i] != ' ') {
						System.out.print(s[i]);
					}
				}
			} else {
				System.out.print("Good");
			}
			System.out.println();

		}

	}

}
