
/* D3.11315. 오목 판정
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXaSUPYqPYMDFASQ&categoryId=AXaSUPYqPYMDFASQ&categoryType=CODE&problemTitle=11315&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D3_11315_오목판정 {
	static int T;
	static int N;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			bw.write("#" + t + " " + five());
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	static String five() {
		if (rCheck() || cCheck() || diaCheck())
			return "YES";
		else
			return "NO";
	}

	static boolean rCheck() {
		for (int i = 0; i < N; i++) {
			String s = "";
			for (int j = 0; j < N; j++) {
				s += map[i][j];
			}
			if (s.contains("ooooo"))
				return true;
		}
		return false;
	}

	static boolean cCheck() {
		for (int j = 0; j < N; j++) {
			String s = "";
			for (int i = 0; i < N; i++) {
				s += map[i][j];
			}
			if (s.contains("ooooo"))
				return true;
		}
		return false;
	}

	static boolean diaCheck() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 'o')
					continue;
				int a = i;
				int b = j;
				for (int k = 0; k < 5; k++) {
					if (map[a][b] == 'o')
						cnt++;
					else
						break;
					if (a + 1 < N && b - 1 >= 0) {
						a++;
						b--;
					} else
						break;
				}
				if (cnt == 5)
					return true;
				else
					cnt = 0;
				a = i;
				b = j;
				for (int k = 0; k < 5; k++) {
					if (map[a][b] == 'o')
						cnt++;
					else
						break;
					if (a + 1 < N && b + 1 < N) {
						a++;
						b++;
					} else
						break;
				}
				if (cnt == 5)
					return true;
				else
					cnt = 0;
			}
		}
		return false;
	}
}
