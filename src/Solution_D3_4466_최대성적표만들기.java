
/* D3.4466. 최대성적표만들기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWOUfCJ6qVMDFAWg&categoryId=AWOUfCJ6qVMDFAWg&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=4
 * SW Expert Acadamy 문제
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution_D3_4466_최대성적표만들기 {	
	
	static int T;
	static int n,k,ans;
	static Integer[] score;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			n = scan.nextInt();
			k = scan.nextInt();
			score = new Integer[n];
			ans = 0;
			for (int i = 0; i < n; i++) {
				score[i] = scan.nextInt();
			}
			Arrays.sort(score, Collections.reverseOrder());
			for (int i = 0; i < k; i++) {
				ans += score[i];
			}
			System.out.println("#"+t+" "+ans);
		}
		
		scan.close();
	}

}
