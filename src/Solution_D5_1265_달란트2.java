
/* D5.1265. 달란트2
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18R8FKIvoCFAZN&categoryId=AV18R8FKIvoCFAZN&categoryType=CODE&problemTitle=%EB%8B%AC%EB%9E%80%ED%8A%B8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D5_1265_달란트2 {
	static int T, N, P;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			P = scan.nextInt();
			System.out.println("#" + t + " " + dalant(N, P));
		}
		scan.close();
	}

	static Long dalant(int n, int p) {
		Long ans = 1L;
		int num1 = N / P;
		int num2 = N % P;
		int[] nums = new int[P];

		for (int i = 0; i < P; i++) {
			if (num2 > 0)
				nums[i] = num1 + 1;
			else
				nums[i] = num1;
			num2--;
		}
		for (int i = 0; i < P; i++) {
			ans *= nums[i];
		}

		return ans;
	}

}
