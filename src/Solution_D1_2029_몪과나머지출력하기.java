
/* D1.2029. 몫과 나머지 출력하기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QGNvKAtEDFAUq&categoryId=AV5QGNvKAtEDFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D1_2029_몪과나머지출력하기 {
	static int T, a, b;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			a = scan.nextInt();
			b = scan.nextInt();
			System.out.printf("#%d %d %d\n", t, a / b, a % b);
		}

	}

}