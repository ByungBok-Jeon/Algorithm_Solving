public class Solution_PR_LV2_예상대진표 {
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        while (true){
            a = (a+1)/2;
            b = (b+1)/2;

            if(a==b) break;
            answer++;
        }

        return answer;
    }
}
