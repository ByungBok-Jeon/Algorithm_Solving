public class Solution_PR_LV2_숫자의표현 {
    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n; i++){
            int sum = 0;
            int idx = i;
            while(sum <= n){
                sum += idx++;
                if(sum == n){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
