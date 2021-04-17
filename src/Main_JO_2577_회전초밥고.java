
/* 2577번 회전초밥(고)
 * 출처 : http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1838&sca=99
 * 정올  문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_JO_2577_회전초밥고 {
    static int N,D,K,C;
    static int[] map;
    static int[] isIn;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        isIn = new int[D+1];
        ans = 0;
        simualtion();
        System.out.println(ans);
    }
    private static void simualtion() {
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            if(isIn[map[i]] ==0) {
                cnt++;
            }
            isIn[map[i]]++;
        }
        if(isIn[C] !=0) ans=cnt;
        else ans = cnt+1;
        for (int i = K; i < K+N; i++) {
            int idx = i%N;
            int tmp = map[(i-K)%N];
            if(isIn[tmp] == 1) {
                cnt--;
            }
            isIn[tmp]--;
            if(isIn[map[idx]]==0) {
                cnt++;
            }
            isIn[map[idx]]++;
            if(ans>cnt)continue;
            if(isIn[C] !=0) ans=cnt;
            else ans = cnt+1;
        }
    }
}
