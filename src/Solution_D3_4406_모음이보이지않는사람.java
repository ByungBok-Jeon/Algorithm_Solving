
/* D3.4406. 모음이보이지않는사람
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWNcD_66pUEDFAV8&categoryId=AWNcD_66pUEDFAV8&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */

import java.util.Scanner;

public class Solution_D3_4406_모음이보이지않는사람 {
	static int T;
	static String[] vowel = {"a","e","i","o","u"};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			String s = scan.next();
			for (int i = 0; i < vowel.length; i++) {
				s = s.replaceAll(vowel[i], "");
			}
			System.out.println("#"+t+" "+ s);
		}
		scan.close();
	}
}
