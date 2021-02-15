
/* D3.6808. 규영이와 인영이의 카드게임
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0&categoryId=AWgv9va6HnkDFAW0&categoryType=CODE&problemTitle=%EA%B7%9C%EC%98%81%EC%9D%B4%EC%99%80&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_6808_규영이와인영이의카드게임 {
	static int N = 9;
	static boolean[] v;
	static int T;
	static int[] tt; // 1~18
	static int[] gy; // 규영
	static int[] iy; // 인영
	static int[] num;
	static int ngy, niy;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			tt = new int[N * 2];
			gy = new int[N];
			iy = new int[N];
			num = new int[N];
			v = new boolean[N];
			ngy = 0;
			niy = 0;
			for (int i = 0; i < N; i++) {
				gy[i] = scan.nextInt();
				tt[gy[i] - 1]++;
			}
			int cnt = 0;
			for (int i = 0; i < N * 2; i++) {
				if (tt[i] == 0)
					iy[cnt++] = i + 1;
			}
			nPr(0);
			System.out.println("#" + t + " " + ngy + " " + niy);
		}

	}

	static void nPr(int cnt) {
		if (cnt == N) {
			int gysum = 0;
			int iysum = 0;
			for (int i = 0; i < N; i++) {
				if (gy[i] > num[i])
					gysum += gy[i] + num[i];
				else if (gy[i] < num[i])
					iysum += gy[i] + num[i];
			}
			if (gysum > iysum)
				ngy++;
			else if (gysum < iysum)
				niy++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i]) {
				continue;
			}
			v[i] = true;
			num[cnt] = iy[i];
			nPr(cnt + 1);
			v[i] = false;
		}
	}
}
