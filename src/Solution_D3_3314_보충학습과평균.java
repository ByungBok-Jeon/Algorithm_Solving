
/* D3.3314. 보충학습과평균
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWBnA2jaxDsDFAWr&categoryId=AWBnA2jaxDsDFAWr&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=3
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_3314_보충학습과평균 {
	static int T;
	static int[] score;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			score = new int[5];
			for (int i = 0; i < 5; i++) {
				score[i] = scan.nextInt();
			}
			int ans = 0;
			for (int i = 0; i < 5; i++) {
				if(score[i]<40) score[i] = 40;
				ans += score[i];
			}
			System.out.println("#"+t+" " + (ans/5));
			
		}
		scan.close();
	}

}
