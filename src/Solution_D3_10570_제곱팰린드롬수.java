
/* D3.10570. 제곱팰린드롬수
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXO72aaqPrcDFAXS&categoryId=AXO72aaqPrcDFAXS&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=2
 * SW Expert Acadamy 문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_10570_제곱팰린드롬수 {
	static int T;
	static int a,b;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ans = 0;
			for (int i = a; i <= b; i++) {
				double sqrt = Math.sqrt(i);
				if(sqrt != (int)sqrt) {
					continue;
				}
				boolean pal = true;
				char[] s = Integer.toString(i).toCharArray();
				for (int j = 0; j < s.length/2; j++) {
					if(s[j] != s[s.length-1-j]) {
						pal = false;
						break;
					}
				}
				if(pal) {
					boolean palSqrt = true;
					char[] sSqrt = Integer.toString((int)sqrt).toCharArray();
					for (int j = 0; j < sSqrt.length/2; j++) {
						if(sSqrt[j] != sSqrt[sSqrt.length-1-j]) {
							palSqrt = false;
							break;
						}
					}
					if(palSqrt) {
						ans++;
					}
				}
			}
			System.out.println("#"+t+" " + ans);
		}
	}

}
