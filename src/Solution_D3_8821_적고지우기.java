
/* D3.8821. 적고지우기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW37UDPKCgQDFATy&categoryId=AW37UDPKCgQDFATy&categoryType=CODE&problemTitle=8821&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_D3_8821_적고지우기 {
	static int T;
	static List<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String s = br.readLine();
			list = new ArrayList<>();
			for (int i = 0; i < s.length(); i++) {
				int c = s.charAt(i)-'0';
				if(list.contains(c)) list.remove(list.indexOf(c));
				else list.add(c);
			}
			System.out.println("#"+t+" "+list.size());
		}
	}
}
