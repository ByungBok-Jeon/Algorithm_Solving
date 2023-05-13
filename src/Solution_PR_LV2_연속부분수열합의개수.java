import java.util.HashSet;
import java.util.Set;

public class Solution_PR_LV2_연속부분수열합의개수 {
    public int solution(int[] elements) {
        int[] arr = new int[elements.length*2-1];
        for (int i = 0; i < elements.length; i++) {
            arr[i] = elements[i];
        }
        int idx = 0;
        for (int i = elements.length; i < elements.length*2-1; i++) {
            arr[i] = elements[idx++];
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {
            for (int j = i; j < i+elements.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum+=arr[k];
                }
                set.add(sum);
            }
        }
        int answer = set.size();
        return answer;
    }
}
