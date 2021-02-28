
/* 2941번 크로아티아알파벳
 * 출처 : https://www.acmicpc.net/problem/2941
 * Baekjoon Online Judge  문제
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_BOJ_2941_크로아티아알파벳 {
	static String input;
	static String[] alpha = {"c=","c-","d-","lj","nj","s=","z="};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		input = scan.next();
		List<Integer> list = new LinkedList<>();
		int two = 0;
		int three = 0;
		int ans = 0;
		for (int i = 0; i < input.length()-2; i++) {
			String s ="";
			s += input.charAt(i);
			s += input.charAt(i+1);
			s += input.charAt(i+2);
			if(s.equals("dz=")) {
				list.add(i);
				list.add(i+1);
				list.add(i+2);
				ans++;
				three++;
			}
		}
		for (int i = 0; i < input.length()-1; i++) {
			if(list.contains(i))
				continue;
			String s ="";
			s += input.charAt(i);
			s += input.charAt(i+1);
			for (int j = 0; j < alpha.length; j++) {
				if(s.equals(alpha[j])) {
					ans++;
					two++;
				}
			}
		}
		ans += input.length()-two*2-three*3;
		System.out.println(ans);
	}
}
