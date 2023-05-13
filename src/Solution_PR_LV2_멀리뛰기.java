public class Solution_PR_LV2_멀리뛰기 {
    public long solution(int n) {
        long answer = 0;
        int[] arr = new int[n+1];
        if(n==1) return 1;
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3; i<arr.length; i++){
            arr[i] = (arr[i-1] + arr[i-2])%1234567;
        }
        answer = arr[n];

        return answer;
    }
}
