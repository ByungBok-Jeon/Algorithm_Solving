
/* D3.1209. Sum
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13_BWKACUCFAYh&categoryId=AV13_BWKACUCFAYh&categoryType=CODE&problemTitle=1209&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1209_Sum {
	static int T = 10;
	static int[][] map;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			map = new int[100][100];
			max = 0;
			br.readLine();
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += map[i][j];
				}
				max = Math.max(max, sum);
			}
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += map[j][i];
				}
				max = Math.max(max, sum);
			}
			int tmpSum = 0;
			for (int idx = 0; idx < 100; idx++) {
				tmpSum += map[idx][idx];
			}
			max = Math.max(max, tmpSum);
			tmpSum = 0;
			for (int i = 0; i < 100; i++) {
				tmpSum += map[i][99-i];
			}
			max = Math.max(max, tmpSum);
			System.out.println("#"+t+" "+max);
		}
	}
}
