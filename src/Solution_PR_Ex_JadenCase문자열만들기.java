/*
연습문제. JadenCase 문자열 만들기
출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12951
프로그래머스 문제
 */

/*
1. 문자열을 띄어쓰기 단어로 만들기
2. 첫 번째 char가 문자면 대문자로
3. 나머지 문자는 소문자로
 */

public class Solution_PR_Ex_JadenCase문자열만들기 {

    public  String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() == 0) continue;
            arr[i] = arr[i].toLowerCase();

            if(arr[i].charAt(0) > 96 && arr[i].charAt(0) < 123){
                if(arr[i].length() == 1){
                    arr[i] = arr[i].substring(0,1).toUpperCase();
                }else{
                    arr[i] = arr[i].substring(0,1).toUpperCase() + arr[i].substring(1);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
            if(i == arr.length-1) break;
            answer += " ";
        }
        if (s.charAt(s.length()-1) == ' ') answer += " ";

        return answer;
    }

}
