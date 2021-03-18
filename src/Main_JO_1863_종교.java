
/* 1863번 종교
 * 출처 : http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1136&sca=99&sfl=wr_hit&stx=1863
 * 정올  문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_JO_1863_종교 {
	static int n,m;
	static int[] student;
	static int[] Rank;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		student = new int[n+1];
		Rank = new int[n+1];
		for (int i = 1; i <= n; i++) {
			student[i] = i;
			Rank[i] = 1;
		}
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			set.add(find(student[i]));
		}
		System.out.println(set.size());
	}
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px==py) return;
		if(Rank[px]>=Rank[py]) {
			student[py] = px;
			Rank[px]+= Rank[py];
		}else {
			student[px] = py;
			Rank[py]+= Rank[px];
		}
		
	}
	static int find(int x) {
		if(x==student[x]) return x;
		return student[x] = find(student[x]);
	}

}
