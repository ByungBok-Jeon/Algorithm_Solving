import java.util.Arrays;
import java.util.Collections;

public class Solution_PR_LV2_귤고르기 {
    public int solution(int k, int[] tangerine) {
        Integer[] cntArray = new Integer[10000001];
        for(int i=0; i<cntArray.length;i++){
            cntArray[i] = 0;
        }

        for (int i = 0; i < tangerine.length; i++) {
            cntArray[tangerine[i]]++;
        }

        Arrays.sort(cntArray, Collections.reverseOrder());
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < cntArray.length; i++) {
            sum+= cntArray[i];
            answer++;
            if(sum>=k) break;
        }
        return answer;
    }
}
