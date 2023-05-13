public class Solution_PR_LV2_다음큰숫자 {
    public int solution(int n) {
        int answer = 0;

        int tmp = n+1;
        String binN = Integer.toBinaryString(n);
        int nCnt = binN.replace("0","").length();
        while (true){
            String binTmp = Integer.toBinaryString(tmp++);
            int tmpCnt = binTmp.replace("0", "").length();
            if(tmpCnt == nCnt) {
                answer = tmp-1;
                break;
            }
        }
        return answer;
    }
}
