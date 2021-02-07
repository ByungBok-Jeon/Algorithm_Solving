
/* D2.1959. 두 개의 숫자열
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PpoFaAS4DFAUq&categoryId=AV5PpoFaAS4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2&&&&&&&&&&
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D2_1959_두개의숫자열 {
	static int T;
	static int N, M;
	static int[] A;
	static int[] B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int[N];
			B = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			int ans = maxSum();
			bw.write("#" + t + " " + ans);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	static int maxSum() {
		int[] ArrA, ArrB;
		int ans = 0;

		if (A.length > B.length) {
			ArrA = B;
			ArrB = A;
		} else {
			ArrA = A;
			ArrB = B;
		}
		int idx = 0;
		for (int i = 0; i <= ArrB.length - ArrA.length; i++) {
			int tmp = 0;
			for (int j = 0; j < ArrA.length; j++) {
				tmp += ArrA[j] * ArrB[j + idx];
			}
			ans = Math.max(ans, tmp);
			idx++;
		}

		return ans;
	}
}
