
/* D3.8741. 두문자어
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW2y6n3qPXQDFATy&categoryId=AW2y6n3qPXQDFATy&categoryType=CODE&problemTitle=8741&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_8741_두문자어 {
	static int T;
	static String[] words;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//-32
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			words = br.readLine().split(" ");
			System.out.print("#"+t+" ");
			for (int i = 0; i < words.length; i++) {
				System.out.print((char)(words[i].charAt(0)-32));
			}
			System.out.println();
		}
	}
}
