
/* D3.8673. 코딩토너먼트1
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AW2Jldrqlo4DFASu&categoryId=AW2Jldrqlo4DFASu&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=2
 * SW Expert Acadamy 문제
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_D3_8673_코딩토너먼트1 {
	static int T;
	static int K;
	static ArrayList<Integer> list;
	static int ans;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();

		for (int t = 1; t <= T; t++) {
			K = scan.nextInt();
			list = new ArrayList<>();
			for (int i = 0; i < Math.pow(2, K); i++) {
				list.add(scan.nextInt());
			}
			ans = 0;
			while (list.size() > 1) {
				match();
			}
			System.out.println("#" + t + " " + ans);
		}
		scan.close();
	}

	static void match() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) >= list.get(i + 1)) {
				ans += list.get(i) - list.get(i + 1);
				list.remove(i + 1);
			} else {
				ans += list.get(i + 1) - list.get(i);
				list.remove(i);
			}
		}
	}
}
