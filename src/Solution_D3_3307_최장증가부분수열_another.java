
/* D3.3307. 최장증가부분수열
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr&categoryId=AWBOKg-a6l0DFAWr&categoryType=CODE&problemTitle=3307&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_3307_최장증가부분수열_another {
	static int T;
	static int N;
	static int[] arr;
	static int[] p;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			arr = new int[N];
			p = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = scan.nextInt();
			}
			Arrays.fill(p, 1);
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i; j++) {
					if(arr[j]<arr[i] && p[i]<p[j]+1) {
						p[i] = p[j] + 1;
					}
				}
				max = Math.max(max, p[i]);
			}
			System.out.println("#"+t+" " + max);
		}
		scan.close();
	}
}
