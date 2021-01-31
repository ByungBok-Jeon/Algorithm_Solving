
/* D2.2007. 패턴 마디의 길이
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5P1kNKAl8DFAUq&categoryId=AV5P1kNKAl8DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D2_2007_패턴마디의길이 {
	static int T;
	static String input;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = Integer.parseInt(scan.nextLine());
		for (int t = 1; t <= T; t++) {
			input = scan.nextLine();
			String pattern = "";
			int idx = 0;
			for (int i = 1; i < input.length(); i++) {
				if (input.charAt(0) == input.charAt(i)) {
					pattern = input.substring(0, i);
					idx = i;
					if (2 * idx - 1 < input.length() && pattern.equals(input.substring(idx, 2 * idx))) {
						break;
					}
				}
			}
			System.out.printf("#%d %d\n", t, pattern.length());

		}

	}

}
