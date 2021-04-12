
/* 5644. 무선충전
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo&categoryId=AWXRDL1aeugDFAUo&categoryType=CODE&problemTitle=5644&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static int T;
	static int m, a;
	static int[][] map;
	static Queue<Integer> infoA, infoB;
	static List<BC>[][] listMap;
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };
	static int sum;

	static class Rc {
		int r;
		int c;

		public Rc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class BC implements Comparable<BC> {
		int no;
		int val;

		public BC(int no, int val) {
			this.no = no;
			this.val = val;
		}

		@Override
		public int compareTo(BC o) {
			return -Integer.compare(this.val, o.val);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			map = new int[10][10];
			listMap = new List[10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					listMap[i][j] = new ArrayList<>();
				}
			}
			infoA = new LinkedList<>();
			infoB = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				infoA.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				infoB.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				int tmp_c = Integer.parseInt(st.nextToken()) - 1;
				int tmp_r = Integer.parseInt(st.nextToken()) - 1;
				int tmp_cnt = Integer.parseInt(st.nextToken());
				int tmp_val = Integer.parseInt(st.nextToken());
				bfs(tmp_r, tmp_c, tmp_cnt, tmp_val, i);
			}
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					Collections.sort(listMap[i][j]);
				}
			}
			sum = 0;
			int Ar = 0;
			int Ac = 0;
			int Br = 9;
			int Bc = 9;
			if (!listMap[Ar][Ac].isEmpty()) {
				sum += listMap[Ar][Ac].get(0).val;
			}
			if (!listMap[Br][Bc].isEmpty()) {
				sum += listMap[Br][Bc].get(0).val;
			}

			while (!infoA.isEmpty()) {
				int dA = infoA.poll();
				int dB = infoB.poll();
				Ar += dr[dA];
				Ac += dc[dA];
				Br += dr[dB];
				Bc += dc[dB];
				if (listMap[Ar][Ac].isEmpty() && listMap[Br][Bc].isEmpty())
					continue;
				else if (!listMap[Ar][Ac].isEmpty() && listMap[Br][Bc].isEmpty()) {
					sum += listMap[Ar][Ac].get(0).val;
				} else if (listMap[Ar][Ac].isEmpty() && !listMap[Br][Bc].isEmpty()) {
					sum += listMap[Br][Bc].get(0).val;
				} else if (!listMap[Ar][Ac].isEmpty() && !listMap[Br][Bc].isEmpty()
						&& listMap[Ar][Ac].get(0).no != listMap[Br][Bc].get(0).no) {
					sum += listMap[Ar][Ac].get(0).val;
					sum += listMap[Br][Bc].get(0).val;
				} else if (!listMap[Ar][Ac].isEmpty() && !listMap[Br][Bc].isEmpty()
						&& listMap[Ar][Ac].get(0).no == listMap[Br][Bc].get(0).no) {
					if (listMap[Ar][Ac].size() == 1 && listMap[Br][Bc].size() == 1) {
						sum += listMap[Ar][Ac].get(0).val;
					} else if (listMap[Ar][Ac].size() == 1 && listMap[Br][Bc].size() != 1) {
						sum += listMap[Ar][Ac].get(0).val;
						sum += listMap[Br][Bc].get(1).val;
					} else if (listMap[Ar][Ac].size() != 1 && listMap[Br][Bc].size() == 1) {
						sum += listMap[Ar][Ac].get(1).val;
						sum += listMap[Br][Bc].get(0).val;
					} else if (listMap[Ar][Ac].get(1).val > listMap[Br][Bc].get(1).val) {
						sum += listMap[Ar][Ac].get(1).val;
						sum += listMap[Br][Bc].get(0).val;
					} else {
						sum += listMap[Ar][Ac].get(0).val;
						sum += listMap[Br][Bc].get(1).val;
					}
				}
			}
			System.out.println("#" + t + " " + sum);

		}

	}

	private static void bfs(int r, int c, int n, int val, int idx) {
		boolean[][] v = new boolean[10][10];
		Queue<Rc> que = new LinkedList<>();
		v[r][c] = true;
		que.offer(new Rc(r, c));
		listMap[r][c].add(new BC(idx, val));

		while (!que.isEmpty()) {
			Rc now = que.poll();

			for (int d = 1; d < 5; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				if (!isIn(nr, nc) || v[nr][nc])
					continue;
				int tmp_dis = Math.abs(nr - r) + Math.abs(nc - c);
				if (tmp_dis > n)
					continue;
				v[nr][nc] = true;
				que.offer(new Rc(nr, nc));
				listMap[nr][nc].add(new BC(idx, val));
			}
		}

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < 10 && c >= 0 && c < 10;
	}

}
