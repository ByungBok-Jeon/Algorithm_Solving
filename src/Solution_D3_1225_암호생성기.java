
/* D3.1225. 암호생성기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD&categoryId=AV14uWl6AF0CFAYD&categoryType=CODE&problemTitle=1225&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_1225_암호생성기 {
	static int[] n;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 10;
		for (int t = 1; t <= T; t++) {
			scan.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			n = new int[8];
			for (int i = 0; i < n.length; i++) {
				n[i] = scan.nextInt();
				queue.add(n[i]);
			}
			Loop1: while (true) {
				for (int i = 1; i <= 5; i++) {
					if (queue.peek() - i <= 0) {
						queue.poll();
						queue.add(0);
						break Loop1;
					} else {
						queue.add(queue.poll() - i);
					}
				}
			}
			System.out.print("#" + t);
			for (int i = 0; i < 8; i++) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();

		}

	}

}
