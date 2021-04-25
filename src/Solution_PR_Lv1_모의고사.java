
/* Lv1. 모의고사
 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42840
 * 프로그래머스 문제
 */
import java.util.Arrays;

public class Solution_PR_Lv1_모의고사 {
	    static int[] score;
	    static int[] stu1 = {1,2,3,4,5};
	    static int[] stu2 = {2,1,2,3,2,4,2,5};
	    static int[] stu3 = {3,3,1,1,2,2,4,4,5,5};
	    public int[] solution(int[] answers) {
	        
	        score = new int[3];
	        for(int i=0; i<answers.length; i++){
	            if(stu1[i%5]==answers[i]) score[0]++;
	            if(stu2[i%8]==answers[i]) score[1]++;
	            if(stu3[i%10]==answers[i]) score[2]++;
	        }
	        int max = 0;
	        int maxIdx = 0;
	        for(int i=0; i<3; i++){
	            if(max<score[i]){
	                max = score[i];
	                maxIdx = i;
	            }
	        }
	        int cnt = 0;
	        for(int i=0; i<3; i++){
	            if(max == score[i]){
	                cnt++;
	            }
	        }
	        int[] answer = new int[cnt];
	        int idx = 0;
	        for(int i=0; i<3; i++){
	            if(max == score[i]){
	                answer[idx++] = i+1;
	            }
	        }
	        Arrays.sort(answer);
	        
	        return answer;
	    }
	
}
