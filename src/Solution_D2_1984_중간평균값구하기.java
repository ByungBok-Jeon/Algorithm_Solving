
/* D2.1984. 중간 평균값 구하기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pw_-KAdcDFAUq&categoryId=AV5Pw_-KAdcDFAUq&categoryType=CODE&problemTitle=1984&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D2_1984_중간평균값구하기 {

	static int T;
	static int[] num;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			num = new int[10];
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				num[i] = scann.nextInt();
				sum += num[i];
			}
			int max = num[0];
			int min = num[0];
			for (int i = 1; i < 10; i++) {
				max = Math.max(max, num[i]);
				min = Math.min(min, num[i]);
			}
			System.out.printf("#%d %.0f\n", t, (sum - max - min) / 8.0);
		}

	}

}
