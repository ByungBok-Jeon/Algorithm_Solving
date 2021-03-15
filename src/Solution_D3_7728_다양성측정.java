
/* D3.7728. 다양성측정
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWq40NEKLyADFARG&categoryId=AWq40NEKLyADFARG&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=2
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D3_7728_다양성측정 {
	static int T;
	static String[] nums = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			String s = scan.next();
			int ans = 0;
			for (int i = 0; i < nums.length; i++) {
				if (s.contains(nums[i])) {
					ans++;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
		scan.close();
	}
}
