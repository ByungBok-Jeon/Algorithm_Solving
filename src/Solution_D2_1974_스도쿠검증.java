
/* D2.1974. 스도쿠검증
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Psz16AYEDFAUq&categoryId=AV5Psz16AYEDFAUq&categoryType=CODE&problemTitle=1974&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_D2_1974_스도쿠검증 {
	static int T;
	static int[][] map;
	static HashSet<Integer> hs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			map = new int[9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bw.write("#" + t + " " + output());
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	static int output() {
		if (rCheck() || cCheck() || boxCheck()) {
			return 0;
		}
		return 1;
	}

	static boolean rCheck() {
		hs = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				hs.add(map[i][j]);
			}
			if (hs.size() != 9)
				return true;
			hs.clear();
		}
		return false;
	}

	static boolean cCheck() {
		hs = new HashSet<>();
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				hs.add(map[i][j]);
			}
			if (hs.size() != 9)
				return true;
			hs.clear();
		}
		return false;
	}

	static boolean boxCheck() {
		hs = new HashSet<>();
		int r = 0;
		int c = 0;
		int[] dr = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
		int[] dc = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				hs.add(map[r + dr[j]][c + dc[j]]);
			}
			if (hs.size() != 9)
				return true;
			if (c == 6) {
				r += 3;
				c = 0;
			} else
				c += 3;
			hs.clear();
		}
		return false;
	}
}
