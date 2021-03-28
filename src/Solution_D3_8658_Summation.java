
/* D3.8658. Summation
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AW1lwyh6WPwDFARC&categoryId=AW1lwyh6WPwDFARC&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=2
 * SW Expert Acadamy 문제
 */

import java.util.Scanner;

public class Solution_D3_8658_Summation {
	static int T;
	static int[] nums;
	static int min,max;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			nums = new int[10];
			for (int i = 0; i < 10; i++) {
				nums[i] = scan.nextInt();
			}
			min = Integer.MAX_VALUE;
			max = 0;
			for (int i = 0; i < 10; i++) {
				int tmp = nums[i];
				char[] cl = Integer.toString(tmp).toCharArray();
				int sum = 0;
				for (int j = 0; j < cl.length; j++) {
					sum += cl[j] -'0';
				}
				min = Math.min(min, sum);
				max = Math.max(max, sum);
			}
			System.out.println("#"+t+" " + max+" "+ min);
			
			
			
		}
		
		scan.close();
	}

}
