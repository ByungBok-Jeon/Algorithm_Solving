import java.util.PriorityQueue;

public class Solution_PR_Lv2_더맵게 {

	 public int solution(int[] scoville, int K) {
	        int answer = 0;
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < scoville.length; i++) {
				pq.offer(scoville[i]);
			}
	        while(!pq.isEmpty()) {
				int f1 = pq.poll();
				if(f1>=K) break;
				if(pq.size()==0) {
					return -1;
				}
				int f2 = pq.poll();
				pq.offer(f1+f2*2);
				answer++;
			}
	        return answer;
	    }

}
