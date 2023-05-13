public class Solution_PR_LV2_점프와순간이동 {
    public int solution(int n) {
        int answer = 1;
        while (true){
            if(n==1) break;
            if(n%2 != 0) {
                n -= 1;
                answer++;
            }else n/=2;
        }

        return answer;
    }
}
