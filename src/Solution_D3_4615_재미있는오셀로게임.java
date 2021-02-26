
/* D3.4615. 재미있는 오셀로게임
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWQmA4uK8ygDFAXj&categoryId=AWQmA4uK8ygDFAXj&categoryType=CODE&problemTitle=%EC%98%A4%EC%85%80%EB%A1%9C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_4615_재미있는오셀로게임 {
	static int T, N, M;
	static int[][] map;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static Stack<Integer> rStack;
	static Stack<Integer> cStack;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			M = scan.nextInt();
			rStack = new Stack<>();
			cStack = new Stack<>();
			map = new int[N + 1][N + 1];
			map[N / 2][N / 2] = 2;
			map[N / 2 + 1][N / 2 + 1] = 2;
			map[N / 2][N / 2 + 1] = 1;
			map[N / 2 + 1][N / 2] = 1;
			for (int n = 0; n < M; n++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				int color = scan.nextInt();
				ocelo(a, b, color);
			}
			int ans1= 0;
			int ans2 =0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j]==1)
						ans1++;
					else if(map[i][j]==2)
						ans2++;
				}
			}
			System.out.println("#" + t + " " + ans1+ " " + ans2);
		}
		scan.close();
	}

	static void ocelo(int r, int c, int color) {
		int enemy =0;
		if (color == 1)
			enemy = 2;
		else if (color == 2)
			enemy = 1;
		map[r][c] = color;
		for (int d = 0; d < 8; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!isIn(nr,nc))
				continue;
			if(map[nr][nc] == enemy) {
				rStack.add(nr);
				cStack.add(nc);
				while(true) {
					nr = nr+dr[d];
					nc = nc + dc[d];
					if(!isIn(nr,nc)){
						rStack.clear();
						cStack.clear();
						break;
					}
					if(map[nr][nc] ==color) {
						while(!rStack.isEmpty()) {
							map[rStack.pop()][cStack.pop()] = color;
						}
						break;
					}else if(map[nr][nc] ==enemy) {
						rStack.add(nr);
						cStack.add(nc);
					}else if(map[nr][nc] == 0) {
						rStack.clear();
						cStack.clear();
						break;
					}
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r > 0 && c > 0 && r <= N && c <= N;
	}

}
