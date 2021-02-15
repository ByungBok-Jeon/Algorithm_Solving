
/* 3040번 백설 공주와 일곱 난쟁이
 * 출처 : https://www.acmicpc.net/problem/3040
 * Baekjoon Online Judge  문제
 */
import java.util.Scanner;

public class Main_BOJ_3040_백설공주와일곱난쟁이 {
	static int N = 9;
	static int[] dwarf;
	static int[] realDwarf;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		dwarf = new int[N];
		realDwarf = new int[7];
		for (int i = 0; i < N; i++) {
			dwarf[i] = scan.nextInt();
		}
		nCr(0, 0);
	}

	static void nCr(int start, int cnt) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += realDwarf[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(realDwarf[i]);
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			realDwarf[cnt] = dwarf[i];
			nCr(i + 1, cnt + 1);
		}
	}
}
