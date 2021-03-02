
/* 1523번 별삼각형1
 * 출처 : http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=795&sca=99&sfl=wr_hit&stx=1523
 * 정올  문제
 */
import java.util.Scanner;

public class Main_JO_1523_별삼각형1 {
	static int n, m;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		if (n < 1 || n > 100 || m < 1 || m > 3)
			System.out.println("INPUT ERROR!");
		else {
			switch (m) {
			case 1:
				for (int i = 0; i < n; i++) {
					for (int j = 0; j <= i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 2:
				for (int i = 0; i < n; i++) {
					for (int j = n; j > i; j--) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 3:
				int tmp = 1;
				for (int i = 0; i < n; i++) {
					for (int j = n - 1; j > i; j--) {
						System.out.print(" ");
					}
					for (int j = 0; j < tmp; j++) {
						System.out.print("*");
					}
					tmp += 2;
					System.out.println();
				}
				break;

			default:
				break;
			}
		}
	}
}
