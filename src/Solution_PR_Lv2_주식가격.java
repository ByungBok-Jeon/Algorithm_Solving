
/* Lv2. 주식가격
 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42584
 * 프로그래머스 문제
 */
public class Solution_PR_Lv2_주식가격 {
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length-1; i++){
            int cnt = 0;
            for(int j=i+1; j<prices.length; j++){
                if(prices[i]<=prices[j]){
                    cnt++;
                }else{
                    cnt++;
                    break;
                }
            }
            answer[i] = cnt;
        }
        answer[prices.length-1] = 0;
        return answer;
    }
}
