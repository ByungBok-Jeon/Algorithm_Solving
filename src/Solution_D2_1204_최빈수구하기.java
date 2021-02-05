
/* D2.1204. 최빈수 구하기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV13zo1KAAACFAYh&categoryId=AV13zo1KAAACFAYh&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=3
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D2_1204_최빈수구하기 {
	static int T;
	static int[] score;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			score = new int[101];
			br.readLine();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				int n = Integer.parseInt(st.nextToken());
				score[n]++;
			}
			int max = 0;
			int maxIdx = 0;
			for (int i = 0; i < score.length; i++) {
				if (score[i] >= max) {
					max = score[i];
					maxIdx = i;
				}
			}
			bw.write("#" + t + " " + maxIdx);
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

}
