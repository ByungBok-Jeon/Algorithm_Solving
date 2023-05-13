public class Solution_PR_LV2_N개의최소공배수 {
    public int solution(int[] arr) {
        int answer = getLCM(arr[0],arr[1]);
        for (int i = 2; i < arr.length; i++) {
            answer = getLCM(answer, arr[i]);
        }
        return answer;

    }
    public int getGCD(int a, int b){
        if(b==0) return a;
        return getGCD(b, a%b);
    }

    public int getLCM(int a, int b){
        return a*b/getGCD(a,b);
    }
}
