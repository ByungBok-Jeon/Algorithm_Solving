
/* D3.5549. 홀수일까짝수일까
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWWxpEDaAVoDFAW4&categoryId=AWWxpEDaAVoDFAW4&categoryType=CODE&problemTitle=5549&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_5549_홀수일까짝수일까 {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String s = br.readLine();
			int n = s.charAt(s.length()-1)-'0';
			String ans = "";
			if(n%2==0) ans = "Even";
			else ans = "Odd";
			System.out.println("#"+t+" "+ans);
		}
	}
}
