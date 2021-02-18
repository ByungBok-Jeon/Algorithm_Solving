
/* 1205번 조커
 * 출처 : http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=488&sca=99&sfl=wr_hit&stx=1205
 * 정올  문제
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_JO_1205_조커 {
	static int N;
	static int joker;
	static ArrayList<Integer> num;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		num = new ArrayList<>();
		joker = 0;
		for (int i = 0; i < N; i++) {
			int tmp = scan.nextInt();
			if (tmp == 0)
				joker++;
			else
				num.add(tmp);
		}
		Collections.sort(num);
		straight();
		scan.close();
	}

	static void straight() {
		int ans = 0;
		if (num.isEmpty() && joker > 0)
			ans = joker;
		else {
			for (int i = 0; i < num.size(); i++) {
				int jo = joker;
				int cnt = 1;
				int idx = i;
				int tmp = num.get(idx);
				while (true) {
					if (idx + 1 == num.size() && jo == 0)
						break;
					if (idx + 1 < num.size() && tmp + 1 == num.get(idx + 1)) {
						cnt++;
						idx++;
						tmp++;
					} else if (idx + 1 < num.size() && tmp == num.get(idx + 1)) {
						idx++;
					} else if (jo > 0) {
						cnt++;
						jo--;
						tmp++;
					} else
						break;
				}
				ans = Math.max(ans, cnt);
			}
		}
		System.out.println(ans);
	}
}
