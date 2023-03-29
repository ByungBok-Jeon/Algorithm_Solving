/*
Lv1. 햄버거 만들기
출처 : https://school.programmers.co.kr/learn/courses/30/lessons/133502
프로그래머스 문제
 */

import java.util.ArrayList;
import java.util.List;

/*
* 해결방법(문제 이해 잘못한 풀이...)
* 1. 빵(1)이 나오면 빵의 개수 count
* 2. 빵의 개수(count)가 1 이상일 때 야채-고기-빵(2,3,1)이 나오면 햄버거 개수(ans) + 1
*
* 해결방법(테스트케이스 확인하고)
* 1. 우선 ArrayList에 배열 저장
* 2. 1,2,3,1이 나오는 경우 검사 후 나오는경우 ans+1 후 해당 시작 인덱스 4개 삭제
* 3. 삭제 전 인덱스부터 다시 검사
*
*
* */
public class Solution_PR_Lv1_햄버거만들기 {

    public static int solution(int[] ingredient) {
        int answer = 0;

        // ArrayList에 우선 저장
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
        }
        if (list.isEmpty()){
            return answer;
        }

        int count = 0; // 1-2-3-1 연달아 나오는 지 카운트하는 변수
        int idx = 0; // 탐색 인덱스
        int startIdx = 0; // 완성된 햄버거(1-2-3-1)이 시작된 인덱스
        while (true){
            int tmp = list.get(idx); // 현재 탐색중인 인덱스 값

            switch (count){
                case 0 :
                    if(tmp == 1){
                        count++;
                        startIdx = idx;
                    }
                    break;
                case 1 :
                    if(tmp == 2){
                        count++;
                    } else if (tmp == 1) {
                        count = 1;
                        startIdx = idx;
                    } else {
                        count = 0;
                    }
                    break;
                case 2 :
                    if (tmp == 3){
                        count++;
                    } else if (tmp == 1) {
                        count = 1;
                        startIdx = idx;
                    } else {
                        count = 0;
                    }
                    break;
                case 3 :
                    if(tmp == 1){
                        count = 0;
                        answer++;
                        for (int i = 0; i < 4; i++) {
                            list.remove(startIdx);
                        }
                        for (int i = 0; i < 3; i++) {
                            if(startIdx <= 0) break;
                            startIdx--;
                        }
                        idx = startIdx-1;
                    }else {
                        count = 0;
                    }
                    break;
            }
            idx++;
            if(startIdx < 0 || list.isEmpty() || idx == list.size()){
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1};
        System.out.println(solution(a));
    }

    /*public int solution(int[] ingredient) {
        int answer = 0;
        int count = 0; // 빵의 개수
        int tmp = 0; // 야채-고기-빵(2,3,1) 이 연달아 나왔는지 확인하는 임시변수 - 2가 나왔으면 1, 3이 연달아 나왔으면 2, 1까지 나왔으면 3, 중간에 달라졌으면 다시 0으로 초기화

        for (int i = 0; i < ingredient.length; i++) {
            if(count > 0) { // 밑에 빵이 있을 경우
                switch (tmp){
                    case 0 :
                        if(ingredient[i] == 2){ // 야채가 나왔으면
                            tmp++;
                        } else if (ingredient[i] == 1) { // 빵 다음 빵이면 빵 개수 +1
                            count++;
                        }
                        break;
                    case 1 :
                        if(ingredient[i] == 3){ // 야채 뒤에 고기가 나왔으면
                            tmp++;
                        }else{ // 다른게 나왔으면
                            tmp = 0; // 초기화
                        }
                        break;
                    case 2 :
                        if(ingredient[i] == 1) {
                            answer++; // 햄버거 개수 +1
                            tmp = 0; // tmp 초기화
                            count--; // 밑에 깔린 빵 개수 -1
                            continue; // 다음 재료로 이동
                        }else{ // 다른게 나왔으면
                            tmp = 0;
                        }
                        break;
                    default:
                        break;
                }
            }else { // 밑에 깔린 빵이 하나도 없을 경우
                if (ingredient[i] == 1) {
                    count++;
                }
            }
        }
        return answer;
    }*/
}
