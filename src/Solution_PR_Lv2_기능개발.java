import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Solution_PR_Lv2_기능개발 {
	static class Pg {
		int per;
		int spd;
		public Pg(int per, int spd) {
			this.per = per;
			this.spd = spd;
		}
	}
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
		Queue<Pg> que = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < progresses.length; i++) {
			que.offer(new Pg(progresses[i],speeds[i]));
		}
		int ans = 0;
		while(!que.isEmpty()) {
			while(que.peek().per+que.peek().spd*cnt >= 100) {
				que.poll();
				ans++;
				if(que.isEmpty()) break;
			}
			if(ans!=0) list.add(ans);
			ans = 0;
			cnt++;
		}
        int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }

}
