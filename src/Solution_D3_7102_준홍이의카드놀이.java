
/* D3.7102. 준홍이의카드놀이
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWkIlHWqBYcDFAXC&categoryId=AWkIlHWqBYcDFAXC&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=3
 * SW Expert Acadamy 문제
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution_D3_7102_준홍이의카드놀이 {	
	static int T;
	static int N,M;
	static List<Card> list;
	
	static class Card implements Comparable<Card>{
		int n;
		int cnt;
		public Card(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Card c) {
			return -Integer.compare(this.cnt, c.cnt);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			M = scan.nextInt();
			list = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					int n = i+j;
					boolean isIn = false;
					for (int k = 0; k < list.size(); k++) {
						if(list.get(k).n==n) {
							list.get(k).cnt++;
							isIn = true;
							break;
						}
					}
					if(!isIn) {
						list.add(new Card(n,1));
					}
				}
			}
			Collections.sort(list);
			int maxCnt = list.get(0).cnt;
			System.out.print("#"+t+" ");
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).cnt!=maxCnt) break;
				System.out.print(list.get(i).n+" ");
			}
			System.out.println();
			
			
		}

		scan.close();
	}

}
