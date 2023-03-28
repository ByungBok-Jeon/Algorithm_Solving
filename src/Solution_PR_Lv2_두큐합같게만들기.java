/*
Lv2. 두 큐 합 같게만들기
출처 : https://school.programmers.co.kr/learn/courses/30/lessons/118667?language=java
프로그래머스 문제
 */

//정확성: 90.0
//합계: 90.0 / 100.0
//추후 수정예정

import java.util.LinkedList;
import java.util.Queue;

public class Solution_PR_Lv2_두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        int queSize = queue1.length; //큐의 크기
        int que1Total = 0; // 1번 큐의 합
        int que2Total = 0; // 2번 큐의 합
        int result = 0; // 움직인 횟수

        for (int i = 0; i < queSize; i++) {
            que1Total += queue1[i];
            que2Total += queue2[i];
            que1.add(queue1[i]);
            que2.add(queue2[i]);
        }
        int total =  que1Total + que2Total; // 전체총합

        if(total % 2 == 1){
            return answer;
        }

        for (int i = 0; i < queSize*4; i++) {
            if (que1Total == que2Total){
                return result;
            } else if (que1Total > que2Total) {
                int tmp = que1.poll();
                que1Total -= tmp;
                que2Total += tmp;
                que2.add(tmp);
            }else{
                int tmp = que2.poll();
                que2Total -= tmp;
                que1Total += tmp;
                que1.add(tmp);
            }

            result++;
        }
        return answer;
    }
}
