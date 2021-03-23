
/* D3.10993. 군주제와 공화제
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXXfloFa29EDFAST&categoryId=AXXfloFa29EDFAST&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D3_10993_군주제와공화제 {
	
	static class city{
		int x;
		int y;
		int power;
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Double> infs = new ArrayList<>();
		public city(int x, int y, int power) {
			super();
			this.x = x;
			this.y = y;
			this.power = power;
		}
	}
	
	static int T;
	static int N;
	static ArrayList<city> cities;
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			cities = new ArrayList<>();
			cities.add(new city(0,0,0));
			p = new int[N+1];
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				cities.add(new city(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i==j)continue;
					city a = cities.get(i);
					city b = cities.get(j);
					
					double inf = (double)b.power/(Math.pow((a.x - b.x), 2)+(Math.pow((a.y - b.y), 2)));
					if(inf>a.power) {
						a.list.add(j);
						a.infs.add(inf);
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				city c = cities.get(i);
				if(c.list.size()>0) {
					double max = 0;
					int maxSize = 0;
					int maxIdx = 0;
					for (int j = 0; j < c.list.size(); j++) {
						if(max<c.infs.get(j)) {
							max = c.infs.get(j);
							maxIdx = c.list.get(j);
						}
					}
					for (int j = 0; j < c.list.size(); j++) {
						if(max== c.infs.get(j)) maxSize++;
					}
					if(maxSize>1) {
						p[i] = -1;
					}else {
						p[i] = p[maxIdx];
						for (int j = 1; j <= N; j++) {
							if(p[j] == i) {
								p[j] = p[i];
							}
						}
					}
				}
			}
			System.out.print("#"+t);
			for (int i = 1; i <= N; i++) {
				if(p[i] == -1) {
					System.out.print(" D");
				}else if(p[i] == i) {
					System.out.print(" K");
				}else {
					System.out.print(" "+ p[i]);
				}
			}
			System.out.println();
		}
	}
}
