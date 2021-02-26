
/* D3.1234. SW문제해결기본_비밀번호
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14_DEKAJcCFAYD&categoryId=AV14_DEKAJcCFAYD&categoryType=CODE&problemTitle=%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;
public class Solution_D3_1234_SW문제해결기본_비밀번호 {
	static int T = 10;
	static int N;
	static int[] password;
	static int sameIdx;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			password = new int[N];
			String s = scan.next();
			for (int i = 0; i < N; i++) {
				password[i] = s.charAt(i) - '0';
			}
			String ans = "";
			int[] pw = deleteSameNum(password);
			for (int i = 0; i < pw.length; i++) {
				ans += pw[i];
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	static boolean sameNum(int[] pw) {
		for (int i = 0; i < pw.length - 1; i++) {
			if (pw[i] == pw[i + 1]) {
				sameIdx = i;
				return true;
			}
		}
		return false;
	}
	static int[] deleteSameNum(int[] pw) {
		while (sameNum(pw)) {
			int[] npw = new int[pw.length - 2];
			int idx = 0;
			for (int i = 0; i < pw.length; i++) {
				if (i == sameIdx || i == sameIdx + 1) {
					continue;
				}
				npw[idx++] = pw[i];
			}
			pw = npw;
		}
		return pw;
	}
}
