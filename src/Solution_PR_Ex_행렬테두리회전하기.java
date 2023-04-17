import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
연습문제. 행렬 테두리 회전하기
출처 : https://school.programmers.co.kr/learn/courses/30/lessons/77485
프로그래머스 문제
 */
public class Solution_PR_Ex_행렬테두리회전하기 {

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int ansIdx = 0;

        int[][] arr = new int[rows+1][columns+1];

        int idx = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = idx++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] rot = queries[i];
            List<Integer> list = new ArrayList<>();
            int pre = arr[rot[0]][rot[1]];
            int tmp = 0;
            for (int r = rot[1]; r < rot[3]; r++) {
                tmp = arr[rot[0]][r+1];
                arr[rot[0]][r+1] = pre;
                list.add(pre);
                pre = tmp;
            }
            for (int c = rot[0]; c < rot[2]; c++) {
                tmp = arr[c+1][rot[3]];
                arr[c+1][rot[3]] = pre;
                list.add(pre);
                pre = tmp;
            }
            for (int r = rot[3]; r > rot[1]; r--) {
                tmp = arr[rot[2]][r-1];
                arr[rot[2]][r-1] = pre;
                list.add(pre);
                pre = tmp;
            }
            for (int c = rot[2]; c > rot[0]; c--) {
                tmp = arr[c-1][rot[1]];
                arr[c-1][rot[1]] = pre;
                list.add(pre);
                pre = tmp;
            }
            Collections.sort(list);
            answer[ansIdx++] = list.get(0);
        }
        return answer;
    }
}
