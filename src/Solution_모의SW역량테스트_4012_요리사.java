
/* 모의SW역량테스트.4012. 요리사
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH&categoryId=AWIeUtVakTMDFAVH&categoryType=CODE&problemTitle=%EC%9A%94%EB%A6%AC%EC%82%AC&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_모의SW역량테스트_4012_요리사 {
	static int T, N;
	static int[][] map;
	static int[] num1;
	static int[] num2;
	static int taste1;
	static int taste2;
	static int min;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			map = new int[N][N];
			num1 = new int[N / 2];
			num2 = new int[N / 2];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			nCr(0, 0);
			System.out.println("#" + t + " " + min);
		}
		scan.close();
	}

	static void nCr(int start, int cnt) {
		if (cnt == N / 2) {
			taste1 = 0;
			taste2 = 0;
			calculate();
			return;
		}
		for (int i = start; i < N; i++) {
			num1[cnt] = i;
			nCr(i + 1, cnt + 1);
		}
	}

	static void calculate() {
		int idx = 0;
		for (int i = 0; i < N; i++) {
			boolean isIn = false;
			for (int j = 0; j < N / 2; j++) {
				if (num1[j] == i)
					isIn = true;
			}
			if (!isIn) {
				num2[idx] = i;
				idx++;
			}
		}
		for (int i = 0; i < num1.length - 1; i++) {
			for (int j = i + 1; j < num1.length; j++) {
				taste1 += map[num1[i]][num1[j]] + map[num1[j]][num1[i]];
			}
		}
		for (int i = 0; i < num2.length - 1; i++) {
			for (int j = i + 1; j < num2.length; j++) {
				taste2 += map[num2[i]][num2[j]] + map[num2[j]][num2[i]];
			}
		}
		min = Math.min(min, Math.abs(taste1 - taste2));
	}
}
