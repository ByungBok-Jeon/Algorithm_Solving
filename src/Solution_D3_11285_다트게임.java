
/* D3.11285. 다트게임
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXZuaLsqz9wDFAST&categoryId=AXZuaLsqz9wDFAST&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */

import java.util.Scanner;

public class Solution_D3_11285_다트게임 {
	static int T;
	static int N;
	static int[] circle = {20,40,60,80,100,120,140,160,180,200};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			int ans = 0;
			for (int n = 0; n < N; n++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				double dis = Math.sqrt(x*x + y*y);
				if(dis<=200) {
					for (int i = 0; i < circle.length; i++) {
						if(dis<=circle[i]) {
							ans+=circle.length-i;
							break;
						}
					}
				}
			}
			System.out.println("#"+t+" " +ans);
		}
		scan.close();
	}
}