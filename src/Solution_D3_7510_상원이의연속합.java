
/* D3.7510. 상원이의연속합
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWoEzJFa2A4DFARq&categoryId=AWoEzJFa2A4DFARq&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=6
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_7510_상원이의연속합 {
	static int T;
	static int N;
	static int ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			ans = 0;
			simulation();
			ans++;
			System.out.println("#"+t+" "+ans);
		}
		
		scan.close();
	}
	private static void simulation() {
		for (int i = 1; i < N-1; i++) {
			int sum = i;
			for (int j = i+1; j <= N; j++) {
				sum+=j;
				if(sum>N)break;
				if(sum==N) {
					ans++;
					break;
				}
			}
		}
		
	}

}
