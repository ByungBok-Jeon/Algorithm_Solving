
/* D1.1936. 1대1 가위바위보
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PjKXKALcDFAUq&categoryId=AV5PjKXKALcDFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D1_1936_1대1가위바위보 {
	static int A, B;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		A = scan.nextInt();
		B = scan.nextInt();
		if ((A == 1 && B == 3) || (A == 2 && B == 1) || (A == 3 && B == 2)) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
	}

}
