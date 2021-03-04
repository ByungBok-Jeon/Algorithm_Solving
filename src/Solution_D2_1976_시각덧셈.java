import java.util.Scanner;
 
public class Solution_D2_1976_시각덧셈 {
	static int T;
	static int h1, h2, m1, m2;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			h1 = scan.nextInt();
			m1 = scan.nextInt();
			h2 = scan.nextInt();
			m2 = scan.nextInt();
			int ansH = h1 + h2;
			int ansM = m1 + m2;
			if (ansM >= 60) {
				ansM -= 60;
				ansH += 1;
			}
			if (ansH > 12) {
				ansH -= 12;
			}
			System.out.println("#" + t + " " + ansH + " " + ansM);
		}
		scan.close();
	}

}
