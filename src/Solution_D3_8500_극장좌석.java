
/* D3.8500. 극장좌석
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWz5yIfq74QDFARQ&categoryId=AWz5yIfq74QDFARQ&categoryType=CODE&problemTitle=8500&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_D3_8500_극장좌석 {
	static int T;
	static int n;
	static List<Integer> list;
	static int ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = 0;
			n = scan.nextInt();
			list = new ArrayList<>();
			int max = 0;
			for (int i = 0; i < n; i++) {
				int tmp = scan.nextInt();
				if(max<tmp) {
					list.add(max);
					max = tmp;
				}else list.add(tmp);
				
			}
			for (int i = 0; i < list.size(); i++) {
				ans += list.get(i);
			}
			ans += max*2+n;
			System.out.println("#"+t+" " + ans);
		}
		scan.close();
	}
}
