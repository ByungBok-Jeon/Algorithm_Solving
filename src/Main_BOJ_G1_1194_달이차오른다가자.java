import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_G1_1194_달이차오른다가자 {
	static int N,M;
	static char[][] map;
	static Queue<int[]> que;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='0') que.offer(new int[] {i,j,0,0,0,0,0,0,0});
			}
		}
		ans = -1;
		bfs();
		System.out.println(ans);
	
	}

	private static void bfs() {
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int r = now[0];
			int c = now[1];
			int cnt = now[2];
			
			if(map[r][c] == '1') {
				ans = cnt;
				return;
			}
				
			int[] key = new int[6];
			for (int i = 0; i < 6; i++) {
				key[i] = now[i+3];
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!isIn(nr,nc)) continue;
				if(map[nr][nc]=='#') continue;
				switch (map[nr][nc]) {
				
				case 'a':
					que.offer(new int[] {nr,nc,cnt+1,1,key[1],key[2],key[3],key[4],key[5]});
					break;
				case 'b':
					que.offer(new int[] {nr,nc,cnt+1,key[0],1,key[2],key[3],key[4],key[5]});
					break;
				case 'c':
					que.offer(new int[] {nr,nc,cnt+1,key[0],key[1],1,key[3],key[4],key[5]});
					break;
				case 'd':
					que.offer(new int[] {nr,nc,cnt+1,key[0],key[1],key[2],1,key[4],key[5]});
					break;
				case 'e':
					que.offer(new int[] {nr,nc,cnt+1,key[0],key[1],key[2],key[3],1,key[5]});
					break;
				case 'f':
					que.offer(new int[] {nr,nc,cnt+1,key[0],key[1],key[2],key[3],key[4],1});
					break;
				case 'A':
					if(key[0]==0)continue;
				case 'B':
					if(key[1]==0)continue;
				case 'C':
					if(key[2]==0)continue;
				case 'D':
					if(key[3]==0)continue;
				case 'E':
					if(key[4]==0)continue;
				case 'F':
					if(key[5]==0)continue;
				default:
					que.offer(new int[] {nr,nc,cnt+1,key[0],key[1],key[2],key[3],key[4],key[5]});
					break;
				}
			}
		}
		
		
		
	}

	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
