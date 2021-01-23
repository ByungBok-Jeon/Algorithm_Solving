
/* D1.2056. 연월일 달력
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QLkdKAz4DFAUq&categoryId=AV5QLkdKAz4DFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D1_2056_연월일달력 {
	static int T;
	static int year, month, day;
	static int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static String input;

	static boolean correct() {
		boolean c = false;
		if (month >= 1 && month <= 12) {
			for (int i = 0; i < 12; i++) {
				if (month == i + 1 && day <= days[i] && day >= 1) {
					c = true;
				}
			}
		}

		return c;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			input = br.readLine();
			year = Integer.parseInt(input.substring(0, 4));
			month = Integer.parseInt(input.substring(4, 6));
			day = Integer.parseInt(input.substring(6, 8));
			if (correct()) {
				System.out.printf("#%d %04d/%02d/%02d\n", t, year, month, day);
			} else {
				System.out.printf("#%d -1\n", t);
			}
		}
	}

}
