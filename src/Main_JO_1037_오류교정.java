
/* 1037번 오류교정
 * 출처 : http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=316&sca=99&sfl=wr_hit&stx=1037
 * 정올  문제
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_JO_1037_오류교정 {
	static int n;
	static int[][] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		List<Integer> rList = new LinkedList<>();
		List<Integer> lList = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				sum += map[i][j];
			}
			if (sum % 2 == 1)
				rList.add(i);
		}
		for (int j = 1; j <= n; j++) {
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				sum += map[i][j];
			}
			if (sum % 2 == 1)
				lList.add(j);
		}
		if (rList.size() == 0 && lList.size() == 0) {
			System.out.print("OK");
		} else if (rList.size() == 1 && lList.size() == 1) {
			System.out.printf("Change bit (%d,%d)", rList.get(0), lList.get(0));
		} else {
			System.out.print("Corrupt");
		}
	}
}
