
/* D1.2068. 최대수 구하기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QQhbqA4QDFAUq&categoryId=AV5QQhbqA4QDFAUq&categoryType=CODE&&&
 * SW Expert Acadamy 문제
 */

import java.util.Scanner;

public class Solution_D1_2068_최대수구하기 {
	static int T;
	static int[] input;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			int max = 0;
			input = new int[10];
			for (int i = 0; i < input.length; i++) {
				input[i] = scan.nextInt();
				max = Math.max(max, input[i]);
			}

			System.out.println("#" + t + " " + max);
		}

	}

}
