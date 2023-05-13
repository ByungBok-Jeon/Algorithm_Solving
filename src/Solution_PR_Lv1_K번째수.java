import java.util.Arrays;

public class Solution_PR_Lv1_K번째수 {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int start = commands[i][0];
            int finish = commands[i][1];
            int gap = finish - start;

            int[] tmpArr = new int[gap + 1];
            for(int j=0; j< gap+1; j++){
                tmpArr[j] = array[start-1+j];
            }

            Arrays.sort(tmpArr);

            answer[i] = tmpArr[commands[i][2]-1];
        }

        return answer;
    }
}
