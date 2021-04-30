import java.util.Arrays;

public class Solution_PR_Lv2_HIndex {
	public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
		for (int i = citations.length-1; i >= 0; i--) {
			if(answer>=citations[i]) {
				break;
			}
			answer++;
		}
        return answer;
    }

}
