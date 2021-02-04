
/* D3.9280. 진용이네 주차타워
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW9j74FacD0DFAUY&categoryId=AW9j74FacD0DFAUY&categoryType=CODE&problemTitle=%EC%A3%BC%EC%B0%A8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_9280_진용이네주차타워 {
	static int T;
	static int n;// 주차공간
	static int m;// 차의 개수
	static int[] R_i; // 단위 무게당 요금
	static int[] W_i; // 차량의 무게
	static int[] area; // 주차장 안에 있는 차번호
	static boolean[] isIn; // 주차공간에 차가 있는지

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			int tot = 0;
			int car = 0;
			n = scan.nextInt();
			m = scan.nextInt();
			R_i = new int[n];
			W_i = new int[m];
			area = new int[n];
			isIn = new boolean[n];
			Queue<Integer> que = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
				R_i[i] = scan.nextInt();
			}
			for (int i = 0; i < m; i++) {
				W_i[i] = scan.nextInt();
			}
			for (int i = 0; i < m * 2; i++) {
				car = scan.nextInt();
				if (car > 0) {
					if (isFull()) {
						que.offer(car);
					} else {
						for (int j = 0; j < n; j++) {
							if (!isIn[j]) {
								isIn[j] = true;
								tot += R_i[j] * W_i[car - 1];
								area[j] = car;
								break;
							}
						}
					}
				} else if (car < 0) {
					for (int j = 0; j < n; j++) {
						if (area[j] == car * (-1)) {
							area[j] = 0;
							isIn[j] = false;
						}
					}
					if (!(isFull()) && !que.isEmpty()) {
						car = que.poll();
						for (int j = 0; j < n; j++) {
							if (!isIn[j]) {
								isIn[j] = true;
								tot += R_i[j] * W_i[car - 1];
								area[j] = car;
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + tot);
		}
	}

	static boolean isFull() {
		for (int i = 0; i < n; i++) {
			if (!isIn[i]) {
				return false;
			}
		}
		return true;
	}
}
