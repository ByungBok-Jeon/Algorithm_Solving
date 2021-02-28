
/* 2804번 크로스워드만들기
 * 출처 : https://www.acmicpc.net/problem/2804
 * Baekjoon Online Judge  문제
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_2804_크로스워드만들기 {
	static char[][] map;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		map = new char[s2.length()][s1.length()];
		int rIdx = 0;
		int cIdx = 0;
		L1 : for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					rIdx = j;
					cIdx = i;
					break L1;
				}
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			Arrays.fill(map[i], '.');
		}
		for (int i = 0; i < s2.length(); i++) {
			map[i][cIdx] = s2.charAt(i);
		}
		for (int j = 0; j < s1.length(); j++) {
			map[rIdx][j] = s1.charAt(j);
		}
		
		for (int i = 0; i < s2.length(); i++) {
			for (int j = 0; j < s1.length(); j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
