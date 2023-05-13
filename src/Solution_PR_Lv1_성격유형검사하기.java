import java.util.HashMap;

/*
Lv1. 성격 유형 검사하기
출처 : https://school.programmers.co.kr/learn/courses/30/lessons/118666
프로그래머스 문제
 */
public class Solution_PR_Lv1_성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        HashMap map = new HashMap<Character,Integer>();

        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            int score = choices[i] -4;
            Character surv;
            if(score < 0){
                surv = survey[i].charAt(0);
                map.put(surv, (int) map.get(surv) - score);
            }else if (score > 0) {
                surv = survey[i].charAt(1);
                map.put(surv, (int) map.get(surv) + score);
            }
        }

        if ((int)map.get('R') < (int)map.get('T')) {
            answer += "T";
        }else{
            answer += "R";
        }
        if ((int)map.get('C') < (int)map.get('F')) {
            answer += "F";
        }else{
            answer += "C";
        }
        if ((int)map.get('J') < (int)map.get('M')) {
            answer += "M";
        }else{
            answer += "J";
        }
        if ((int)map.get('A') < (int)map.get('N')) {
            answer += "N";
        }else{
            answer += "A";
        }
        return answer;
    }
}
