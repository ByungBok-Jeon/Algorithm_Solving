
/* D2.1948. 날짜계산기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PnnU6AOsDFAUq&categoryId=AV5PnnU6AOsDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D2_1948_날짜계산기 {
	static int T;
	static int mon1, day1, mon2, day2;
	static int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			mon1 = scan.nextInt();
			day1 = scan.nextInt();
			mon2 = scan.nextInt();
			day2 = scan.nextInt();
			int ans = 0;
			for (int i = mon1; i < mon2; i++) {
				ans += month[i];
			}
			ans += day2 - day1 + 1;
			System.out.println("#" + t + " " + ans);
		}
	}
}
