
/* D3.11445. 무한사전
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXdHwI1aCy0DFAS5&categoryId=AXdHwI1aCy0DFAS5&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_11445_무한사전 {
	static int T;
	static char[] P, Q;
	static char answer;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = Integer.parseInt(scan.nextLine());
		for (int t = 1; t <= T; t++) {
			String s = scan.nextLine();
			s = s.replaceAll(" ", "");
			P = s.toCharArray();
			s = scan.nextLine();
			s = s.replaceAll(" ", "");
			Q = s.toCharArray();
			answer = 'Y';
			dic();
			System.out.println("#" + t + " " + answer);
		}
		scan.close();
	}

	static void dic() {
		char[] p, q;
		if (P.length >= Q.length) {
			p = Arrays.copyOfRange(P, 0, P.length);
			q = Arrays.copyOfRange(Q, 0, Q.length);
		} else {
			p = Arrays.copyOfRange(Q, 0, Q.length);
			q = Arrays.copyOfRange(P, 0, P.length);
		}
		int plen = p.length;
		int qlen = q.length;
		if (plen - qlen > 1)
			return;
		if (plen - qlen == 1) {
			boolean same = true;
			for (int i = 0; i < q.length; i++) {
				if (p[i] != q[i]) {
					same = false;
					break;
				}
			}
			if (same && p[p.length - 1] == 'a') {
				answer = 'N';
				return;
			}
		} else if (plen - qlen == 0) {
			boolean same = true;
			for (int i = 0; i < p.length; i++) {
				if (p[i] != q[i]) {
					same = false;
					break;
				}
			}
			if (same) {
				answer = 'N';
				return;
			}
		}
	}
}
