
/* 1719번 별삼각형2
 * 출처 : http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=992&sca=99&sfl=wr_hit&stx=1719
 * 정올  문제
 */
import java.util.Scanner;

public class Main_JO_1719_별삼각형2 {
	static int n, m;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		if (n % 2 == 0 || n < 1 || n > 100 || m < 1 || m > 4)
			System.out.println("INPUT ERROR!");
		else {
			switch (m) {
			case 1:
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < Math.abs(Math.abs(i - n / 2) - n / 2) + 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 2:
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < Math.abs(i - n / 2); j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < Math.abs(Math.abs(i - n / 2) - n / 2) + 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 3:
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < Math.abs(Math.abs(i - n / 2) - n / 2); j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < Math.abs(i - n / 2) * 2 + 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 4:
				for (int i = 0; i < n / 2; i++) {
					for (int j = 0; j < i; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < n / 2 + 1 - i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = n / 2; i < n; i++) {
					for (int j = 0; j < n / 2; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j <= i - n / 2; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			default:
				break;
			}
		}
	}
}
