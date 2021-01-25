
/* D1.1933. 간단한 N 의 약수
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PhcWaAKIDFAUq&categoryId=AV5PhcWaAKIDFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D1_1933_간단한N의약수 {
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				System.out.printf("%d ", i);
			}
		}

	}

}
