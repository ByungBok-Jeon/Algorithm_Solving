/*
Lv2. 롤케이크 자르기
출처 : https://school.programmers.co.kr/learn/courses/30/lessons/132265
프로그래머스 문제
 */

/*
<첫 번째 접근>
1. HashSet을 이용하여 풀기
2. 총 가지 수를 탐색
3. 첫 번째 인덱스부터 탐색해서 맵에 넣기
4. 앞 맵의 사이즈가 총 가지수 / 2 보다 작지않으면 뒤의 인덱스를 새로운 맵의 가지 수로 넣고 같으면 답 + 1

-> 시간 초과

<두 번째 접근>
1. 0부터 (topping배열-1)/2를 구분으로 앞/뒤로 나눔
2. 첫 번째 접근과 같이 set 방식으로 탐색
3. 가지 수가 같다면 답+1하고 구분 인덱스를 양쪽으로 재탐색, 다르다면 작은 쪽으로 구분 인덱스로 이동
4. 단, 3번에서 이미 탐색한 인덱스를 함수의 인자로 주어서 중복탐색 방지.

-> 시간 초과 및 답 이상...

<세 번째 접근>
1. HashMap으로 개수까지 관리하자...
2. 처음에 배열을 HashMap에 전부 저장 1 몇개, 2 몇개.. 이런식으로
3. 다시 처음부터 배열탐색하며 HashSet에 저장 및 개수 파악..
4. 저장할때마다 HashMap에서 --; 만약 한 개일 경우 삭제..
5. 값 비교..
-- 이러면 아마 O(n)이지 않을까..?




* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_PR_Lv2_롤케이크자르기 {
    /*public int solution(int[] topping) {
        int answer = 0;

        Set<Integer> totalSet = new HashSet<>(); // 총 가지 수를 판별할 Set

        for (int i = 0; i < topping.length; i++) {
            totalSet.add(topping[i]);
        }
        int totalTopping = totalSet.size(); // 총 토핑 수

        Set<Integer> preSet = new HashSet<>();


        for (int i = 0; i < topping.length; i++) {
            preSet.add(topping[i]);
            if(preSet.size() < totalTopping / 2) continue;

            // 앞 Set의 개수가 총 토핑수/2 보다 작지 않다면 뒤의 Set의 가지 수 count
            Set<Integer> postSet = new HashSet<>();
            for (int j = i+1; j < topping.length; j++) {
                postSet.add(topping[j]);
                if(postSet.size() > preSet.size()) break;
            }

            if (preSet.size() == postSet.size()) answer++;
        }

        return answer;
    }*/


   /* public static void main(String[] args) {
        int[] aa = {1, 2, 3, 1, 4};

        System.out.println(solution(aa));
    }
    public static int solution(int[] topping) {
        int answer = 0;

        int startIdx = (topping.length-1)/2; // 첫 시작 인덱스

        // search함수(구분인덱스, 이전탐색 방향(-1은 왼쪽에서, 1은 오른쪽에서), 답, 배열)
        answer = search(startIdx, 0, 0, topping);


        return answer;
    }

    private static int search(int idx, int dir, int ans, int[] arr) {
        if(idx < 0 || idx >= arr.length) return ans;

        Set<Integer> preSet = new HashSet<>();
        Set<Integer> postSet = new HashSet<>();
        for (int i = 0; i <= idx; i++) {
            preSet.add(arr[i]);
        }
        for (int i = idx+1; i < arr.length; i++) {
            postSet.add(arr[i]);
        }
        int diff = postSet.size() - preSet.size(); // 두 set의 차 (양수면 뒤가 크고, 음수면 앞이 큼)

        if (diff == 0){ // 앞 뒤가 같을 경우
            ans++;
            // 이전 방향에서 왔을 경우
            if(dir == -1) {
                ans = search(idx+1, -1, ans, arr);
            } else if (dir == 1) { // 다음 방향에서 왔을 경우
                ans = search(idx-1, 1, ans, arr);
            } else { // 양 방향
                ans = search(idx+1, -1, ans, arr);
                ans = search(idx-1, 1, ans, arr);
            }
        } else if (diff > 0) { // 뒤가 더 크면
            // 이전방향으로 탐색해야 하는데 이전에서 온거면 리턴
            if (dir == -1) return ans;
            if (diff == 1) ans = search(idx-1, 1, ans, arr); // 1차이면 바로 앞 탐색
            else ans = search(idx-(diff/2), diff/2, ans, arr); // 1차이 보다 크면 diff/2 뒤 탐색
        } else if (diff < 0) { // 앞이 더 크면
            // 다음 방향으로 탐색해야 하는데 다음에서 온거면 리턴
            if (dir == 1) return ans;
            if (diff == -1) ans = search(idx+1, -1, ans, arr); // 1차이면 바로 뒤 탐색
            else ans = search(idx-(diff/2), -(diff/2), ans, arr); // 1차이 보다 크면  diff/2 앞 탐색
        }
        return ans;
    }*/
   public int solution(int[] topping) {
       int answer = 0;

       Map<Integer, Integer> map = new HashMap<>();

       for (int i = 0; i < topping.length; i++) {
           int tmp = topping[i];
           if(map.containsKey(tmp)){
               map.put(tmp, map.get(tmp)+1);
           }else{
               map.put(tmp,1);
           }
       }

       Set<Integer> set = new HashSet<>();

       for (int i = 0; i < topping.length; i++) {
           int tmp = topping[i];
           set.add(tmp);
           if(map.get(tmp) == 1){
               map.remove(tmp);
           }else {
               map.put(tmp, map.get(tmp)-1);
           }
           if(set.size() == map.size()) answer++;
           else if (set.size() > map.size()) break;
       }

       return answer;
   }



}
