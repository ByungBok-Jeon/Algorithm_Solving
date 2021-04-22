
/* D3.2930. 힙
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-Tj7ya3jYDFAXr&categoryId=AV-Tj7ya3jYDFAXr&categoryType=CODE&problemTitle=2930&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_D3_2930_힙 {
	static int T,N;
	static PriorityQueue<Integer> que;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for(int t = 1; t <= T; t++) {
			N = scan.nextInt();
			que = new PriorityQueue<>(Collections.reverseOrder());
			System.out.print("#"+t+" ");
			for (int i = 0; i < N; i++) {
				int n = scan.nextInt();
				if(n==1) {
					int num = scan.nextInt();
					que.offer(num);
				}else {
					if(!que.isEmpty()) {
						System.out.print(que.poll()+" ");
					}else {
						System.out.print(-1+" ");
					}
				}
			}
			System.out.println();
		}
		
		
		scan.close();

	}

}
