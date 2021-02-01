
/* D3.1289. 원재의 메모리 복구하기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV19AcoKI9sCFAZN&categoryId=AV19AcoKI9sCFAZN&categoryType=CODE&problemTitle=1289&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기 {
	static int T;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			String ss = scan.next();
			int count = 0;
			if (ss.charAt(0) == '1') {
				count = 1;
			}
			for (int i = 0; i < ss.length(); i++) {
				if (i + 1 < ss.length() && ss.charAt(i) != ss.charAt(i + 1)) {
					count++;
				}
			}
			System.out.printf("#%d %d\n", t, count);
		}

	}

}
