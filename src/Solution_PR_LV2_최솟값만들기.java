import java.util.Arrays;

public class Solution_PR_LV2_최솟값만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++){
            answer += A[i] * B[B.length-1-i];
        }

        return answer;
    }
}
