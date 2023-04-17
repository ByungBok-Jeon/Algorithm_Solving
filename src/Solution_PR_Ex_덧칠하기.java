/*
연습문제. 덧칠하기
출처 : https://school.programmers.co.kr/learn/courses/30/lessons/161989
프로그래머스 문제
 */
public class Solution_PR_Ex_덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < section.length; i++) {
            arr[section[i]-1] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                answer++;
                for (int j = i; j < i + m; j++) {
                    if (j >= n) break;
                    arr[j] = 0;
                }
            }
        }
        return answer;
    }
}
