
/* D1.2019. 더블더블
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QDEX6AqwDFAUq&categoryId=AV5QDEX6AqwDFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D1_2019_더블더블 {
	static int n;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int a = 1;
		for (int i = 0; i <= n; i++) {
			System.out.printf("%d ", a);
			a *= 2;
		}
	}
}
