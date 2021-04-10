
/* D3.5515. 2016년요일맞추기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWWOwecaFrIDFAV4&categoryId=AWWOwecaFrIDFAV4&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=5
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_5515_2016년요일맞추기 {
	static int T;
	static int m,d;
	static int[] days = {31,29,31,30,31,30,31,31,30,31,30};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			m = scan.nextInt();
			d = scan.nextInt();
			int day = 4;
			for (int i = 0; i < m-1; i++) {
				day += days[i];
			}
			day+=d-1;
			day %=7;
			System.out.println("#"+t+" "+day);
		}
		scan.close();
	}

}
