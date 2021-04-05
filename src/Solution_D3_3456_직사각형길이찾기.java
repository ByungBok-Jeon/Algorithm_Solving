
/* D3.3456. 직사각형길이찾기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWFPmsqqALwDFAV0&categoryId=AWFPmsqqALwDFAV0&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=3
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3456_직사각형길이찾기 {
	static int T;
	static int a,b,c;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(a==b) {
				ans = c;
			}else if(a==c) {
				ans = b;
			}else if(b==c) {
				ans = a;
			}
			System.out.println("#"+t+" " + ans);
		}
	}

}
