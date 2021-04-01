
/* D3.1213. String
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV14P0c6AAUCFAYi&categoryId=AV14P0c6AAUCFAYi&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=3
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_1213_String {
	static int T = 10;
	static String s,input;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {
			ans = 0;
			br.readLine();
			s = br.readLine();
			input = br.readLine();
			for (int i = 0; i < input.length()-s.length()+1; i++) {
				int cnt = 0;
				for (int j = 0; j < s.length(); j++) {
					if(input.charAt(i+cnt)==s.charAt(j)) {
						cnt++;
					}else {
						break;
					}
				}
				if(cnt==s.length()) {
					ans++;
				}
			}
			System.out.println("#"+t+" "+ans);
			
		}
	}

}
