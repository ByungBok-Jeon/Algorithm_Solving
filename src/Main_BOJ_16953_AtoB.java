
/* 16953번 A → B
 * 출처 : https://www.acmicpc.net/problem/16953
 * Baekjoon Online Judge  문제
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_16953_AtoB {
	static Long A,B;
	static int min;
	static class Num{
		Long n;
		int cnt;
		public Num(Long n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		A = scan.nextLong();
		B = scan.nextLong();
		min = Integer.MAX_VALUE;
		bfs();
		System.out.println(min);
		scan.close();
	}
	static void bfs() {
		Queue<Num> que = new LinkedList<>();
		que.offer(new Num(A,0));
		while(!que.isEmpty()) {
			Num now = que.poll();
			Long n = now.n;
			if(n>B) {
				continue;
			}
			int cnt = now.cnt;
			if(n.equals(B)) {
				min = cnt+1;
				return;
			}
			que.offer(new Num(n*2,cnt+1));
			que.offer(new Num(n*10+1,cnt+1));
		}
		min = -1;
	}
}
