/*
Lv2. 주차 요금 계산
출처 : https://school.programmers.co.kr/learn/courses/30/lessons/92341
프로그래머스 문제
 */

/*
<첫 번째 접근>
1. IN일 경우 주차장 Map에 시간*60 + 분 을 value로 저장
2. OUT일 경우 주차시간Map에 (시간*60+분 - 주차장Map에서 꺼낸 값) 을 value로 저장
3. 반복 끝나면 주차장 Map 탐색 후 1439(24시간을 분 환산 -1) - 주차장Map에서 꺼낸 값을 value로 저장
4. List 선언 후 주차시간 Map을 key값으로 정렬하여 변환
5. List 탐색하면서 계산 후 다시 넣기
6. fees[0](기본시간)보다 작거나 같으면 fees[1]
7. 크다면 fees[0]을 뺀 값에서 %fees[2]이 0보다 크면 /fees[2]하고 +1을 fees[3]과 곱하고 아니면 +1을 안하고 fees[3]와 곱한 다음 fees[1]을 더하여 저장

 */

import java.util.*;

public class Solution_PR_Lv2_주차요금계산 {

    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> parkingMap = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();

        for (int i = 0; i < records.length; i++) {

            String[] tmp = records[i].split(" ");
            String[] tmpTime = tmp[0].split(":");
            int time =  Integer.parseInt(tmpTime[0])*60 +  Integer.parseInt(tmpTime[1]);

            if(tmp[2].equals("IN")){
                parkingMap.put(tmp[1],time);
            }else {
                int parkingTime = time - parkingMap.get(tmp[1]);
                if(timeMap.containsKey(tmp[1])){
                    timeMap.put(tmp[1], timeMap.get(tmp[1]) + parkingTime);
                }else{
                    timeMap.put(tmp[1], parkingTime);
                }
                parkingMap.remove(tmp[1]);
            }
        }

        for( String key : parkingMap.keySet()) {

            int parkingTime = 1439 - parkingMap.get(key);

            if(timeMap.containsKey(key)){
                timeMap.put(key, timeMap.get(key) + parkingTime);
            }else{
                timeMap.put(key, parkingTime);
            }
        }

        List<String> keySet = new ArrayList<>(timeMap.keySet());

        Collections.sort(keySet);

        int[] answer = new int[keySet.size()];

        for (int i = 0; i < answer.length; i++) {
            int price = 0;
            int totalTime = timeMap.get(keySet.get(i));
            if(totalTime <= fees[0]){
                price = fees[1];
            }else{
                totalTime-= fees[0];
                if(totalTime % fees[2] >= 1){
                    price = fees[1] + (totalTime/fees[2]+1)*fees[3];
                }else{
                    price = fees[1] + totalTime/fees[2]*fees[3];
                }
            }
            answer[i] = price;
        }
        return answer;
    }

}
