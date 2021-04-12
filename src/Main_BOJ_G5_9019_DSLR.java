
/* Gold5 9019번 DSLR
 * 출처 : https://www.acmicpc.net/problem/9019
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_G5_9019_DSLR {
	static int T;
	
	static class Num{
		int n;
		String result;
		public Num(int n, String result) {
			this.n = n;
			this.result = result;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			bfs(n1,n2);
		}
	}
	private static void bfs(int n1, int n2) {
		boolean[] v = new boolean[10000];
		Queue<Num> que = new LinkedList<>();
		que.offer(new Num(n1,""));
		while(!que.isEmpty()) {
			Num now = que.poll();
			if(v[now.n]) continue;
			v[now.n] = true;
			if(now.n==n2) {
				System.out.println(now.result);
				return;
			}
			//D
			int tmp = (now.n*2)%10000;
			que.offer(new Num(tmp,now.result+"D"));
			//S
			tmp = now.n-1;
			if(tmp<0) tmp = 9999;
			que.offer(new Num(tmp,now.result+"S"));
			//각자리의 값 구하기
			String s = Integer.toString(now.n);
			while(s.length()!=4) {
				s = "0"+s;
			}
			char[] d = new char[4];
			for (int i = 0; i < 4; i++) {
				d[i] = s.charAt(i);
			}
			//L
			s = ""+d[1]+d[2]+d[3]+d[0];
			tmp = Integer.parseInt(s);
			que.offer(new Num(tmp,now.result+"L"));
			//R
			s = ""+d[3]+d[0]+d[1]+d[2];
			tmp = Integer.parseInt(s);
			que.offer(new Num(tmp,now.result+"R"));
		}
	}
}