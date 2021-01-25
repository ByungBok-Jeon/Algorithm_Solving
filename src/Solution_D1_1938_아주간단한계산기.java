
/* D1.1938. 아주 간단한 계산기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PjsYKAMIDFAUq&categoryId=AV5PjsYKAMIDFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */

import java.util.Scanner;

public class Solution_D1_1938_아주간단한계산기 {
	static int a, b;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
	}

}
