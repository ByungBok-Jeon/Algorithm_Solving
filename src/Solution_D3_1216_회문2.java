
/* D3.1216. 회문2
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV14Rq5aABUCFAYi&categoryId=AV14Rq5aABUCFAYi&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=2
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_1216_회문2 {
	static int T = 10;
	static int[][] map;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {
			ans = 0;
			br.readLine();
			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String s = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			palindrome();
			System.out.println("#" + t + " " + ans);
		}

	}

	static void palindrome() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 99; k > j; k--) {
					if (map[i][j] == map[i][k]) {
						int tmpJ = j;
						int tmpK = k;
						boolean isPal = true;
						for (int l = 0; l < (k - j + 1) / 2; l++) {
							if (map[i][tmpJ] != map[i][tmpK]) {
								isPal = false;
								break;
							}
							tmpJ++;
							tmpK--;
						}
						if (isPal) {
							ans = Math.max(ans, k - j+1);
							break;
						}
					}
				}
				for (int k = 99; k > i; k--) {
					if (map[i][j] == map[k][j]) {
						int tmpI = i;
						int tmpK = k;
						boolean isPal = true;
						for (int l = 0; l < (k - i + 1) / 2; l++) {
							if (map[tmpI][j] != map[tmpK][j]) {
								isPal = false;
								break;
							}
							tmpI++;
							tmpK--;
						}
						if (isPal) {
							ans = Math.max(ans, k - i+1);
							break;
						}
					}
				}
			}
		}
	}
}
