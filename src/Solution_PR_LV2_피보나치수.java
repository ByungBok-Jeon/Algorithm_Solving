public class Solution_PR_LV2_피보나치수 {
    public int solution(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i=2; i<=n; i++){
            arr[i] = arr[i-1] + arr[i-2];
            if(arr[i] > 1234567) arr[i] = arr[i] %1234567;
        }

        int answer = arr[n] % 1234567;

        return answer;
    }
}
