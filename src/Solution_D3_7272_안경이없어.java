
/* D3.7372. 안경이 없어
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWl0ZQ8qn7UDFAXz&categoryId=AWl0ZQ8qn7UDFAXz&categoryType=CODE&problemTitle=7272&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_7272_안경이없어 {
	static int T;
	static String s1, s2;
	static char[] alpha1 = {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
	static char[] alpha2 = {'A','D','O','P','Q','R'};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			String ans ="SAME";
			s1 = scan.next();
			s2 = scan.next();
			if(s1.length()!=s2.length())
				ans = "DIFF";
			else {
				for (int i = 0; i < s1.length(); i++) {
					if(isIn(s1.charAt(i),alpha1)&&!isIn(s2.charAt(i),alpha1))
						ans = "DIFF";
					else if(isIn(s1.charAt(i),alpha2)&&!isIn(s2.charAt(i),alpha2))
						ans = "DIFF";
					else if(s1.charAt(i)=='B' && s2.charAt(i)!='B')
						ans = "DIFF";
				}
			}
			System.out.println("#"+t+ " " + ans);
		}
	}
	static boolean isIn(char c, char[] alpha) {
		for (int i = 0; i < alpha.length; i++) {
			if(alpha[i]==c)
				return true;
		}
		return false;
	}
}
