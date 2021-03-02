
/* 1329번 별삼각형3
 * 출처 : http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=608&sca=99&sfl=wr_hit&stx=1329
 * 정올  문제
 */
import java.util.Scanner;

public class Main_JO_1329_별삼각형3 {
	static int n;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		if (n % 2 == 0 || n < 1 || n > 100)
			System.out.println("INPUT ERROR!");
		else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < Math.abs(Math.abs(i-n/2)-n/2); j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < (Math.abs(Math.abs(i-n/2)-n/2))*2+1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}
