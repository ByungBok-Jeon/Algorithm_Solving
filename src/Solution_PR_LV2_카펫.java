public class Solution_PR_LV2_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int prd = brown + yellow;

        for(int i=1; i<= prd; i++){
            if(prd%i == 0){
                int div = prd/i;
                if((i-2)*(div-2) == yellow){
                    answer = new int[] {div,i};
                    break;
                }
            }
        }

        return answer;
    }
}
