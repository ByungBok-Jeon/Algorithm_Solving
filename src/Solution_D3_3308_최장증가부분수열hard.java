
/* D3.3308. 최장증가부분수열hard
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOPZeK6nUDFAWr&categoryId=AWBOPZeK6nUDFAWr&categoryType=CODE&problemTitle=3308&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_3308_최장증가부분수열hard {
	static int T;
	static int N;
	static int[] arr;
	static int[] C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			C = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int size = 0;
			for (int i = 0; i < N; i++) {
				int temp = Arrays.binarySearch(C, 0, size, arr[i]);
				temp = Math.abs(temp) - 1;
				C[temp] = arr[i];
				
				if(size == temp) {
					size++;
				}
			}
			System.out.println("#" + t+ " " + size);
		}
	}
}
