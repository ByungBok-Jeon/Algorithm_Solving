
/* D2.1983. 조교의 성적 매기기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PwGK6AcIDFAUq&categoryId=AV5PwGK6AcIDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D2_1983_조교의성적매기기 {
	static int T;
	static int N;
	static int K;
	static double[] score;
	static String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()) - 1;
			score = new double[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken()) * 0.35 + Integer.parseInt(st.nextToken()) * 0.45
						+ Integer.parseInt(st.nextToken()) * 0.2;
			}

			double kScore = score[K];
			String kGrade = "";
			Arrays.sort(score);

			for (int i = 0; i < N / 2; i++) {
				double tmp = score[i];
				score[i] = score[N - 1 - i];
				score[N - 1 - i] = tmp;
			}
			for (int i = 0; i < N; i++) {
				if (score[i] == kScore) {
					kGrade = grade[i / (N / 10)];
				}
			}
			bw.write("#" + t + " " + kGrade);
			bw.newLine();
			bw.flush();

		}
		bw.close();
	}

}
