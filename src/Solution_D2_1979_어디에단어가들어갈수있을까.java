
/* D2.1979. 어디에 단어가 들어갈 수 있을까
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PuPq6AaQDFAUq&categoryId=AV5PuPq6AaQDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D2_1979_어디에단어가들어갈수있을까 {
	static int T;
	static int N,K;
	static int[][] map;
	static int ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = 0;
			N=scan.nextInt();
			K=scan.nextInt();
			map=new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			word();
			System.out.println("#"+t+" "+ans);
		}
		scan.close();
	}
	static void word() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					int cnt =1;
					if(j==0 || map[i][j-1] ==0) {
						int nc= j+1;
						while(nc<N) {
							if(map[i][nc]==1) {
								cnt++;
							}else {
								break;
							}
							nc= nc+1;
						}
						if(cnt==K)
							ans++;
					}
					cnt =1;
					if(i==0 || map[i-1][j] ==0) {
						int nr= i+1;
						while(nr<N) {
							if(map[nr][j]==1) {
								cnt++;
							}else {
								break;
							}
							nr= nr+1;
						}
						if(cnt==K)
							ans++;
					}
				}
			}
		}
	}
}