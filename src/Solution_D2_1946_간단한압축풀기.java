
/* D2.1946. 간단한 압축 풀기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PmkDKAOMDFAUq&categoryId=AV5PmkDKAOMDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=2&pageSize=10&pageIndex=2
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D2_1946_간단한압축풀기 {
	static int T;
	static int N;
	static Queue<Character> que;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			que = new LinkedList<>();
			N = Integer.parseInt(br.readLine());
			char c;
			int num;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				c = st.nextToken().charAt(0);
				num = Integer.parseInt(st.nextToken());
				for (int j = 0; j < num; j++) {
					que.offer(c);
				}
			}
			bw.write("#" + t);
			bw.newLine();
			while (!que.isEmpty()) {
				for (int i = 0; i < 10; i++) {
					if (que.isEmpty()) {
						break;
					}
					bw.write(que.poll());
				}
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}

}
