import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/*
연습문제. 과제 진행하기
출처 : https://school.programmers.co.kr/learn/courses/30/lessons/176962
프로그래머스 문제
 */
public class Solution_PR_Ex_과제진행하기 {

    class Node{
        String name;
        int time;
        
        public Node(String name, int time){
            this.name = name;
            this.time = time;
        }
    }
    public String[] solution(String[][] plans) {

        String[] answer = new String[plans.length];
        int idx = 0;

        Stack<Node> stack = new Stack<>();
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                String[] tmp1 = o1[1].split(":");
                int a = Integer.parseInt(tmp1[0]) * 60 + Integer.parseInt(tmp1[1]);

                String[] tmp2 = o2[1].split(":");
                int b = Integer.parseInt(tmp2[0]) * 60 + Integer.parseInt(tmp2[1]);
                return  a-b;
            }
        });

        for (int i = 0; i < plans.length; i++) {
            String[] tmp1 = plans[i][1].split(":");
            int a = Integer.parseInt(tmp1[0]) * 60 + Integer.parseInt(tmp1[1]);
            plans[i][1] = ""+a;
        }

        for (int i = 0; i < plans.length - 1; i++) {
            
            int time1 = Integer.parseInt(plans[i][1]) + Integer.parseInt(plans[i][2]);
            int time2 = Integer.parseInt(plans[i+1][1]);
            
            if(time1 > time2){
                stack.add(new Node(plans[i][0], time1-time2));
            } else if (time1 < time2) {
                int remain = time2 - time1;
                answer[idx++] = plans[i][0];
                while (!stack.isEmpty() && remain > 0){
                    Node tmpNode = stack.pop();
                    if (tmpNode.time > remain){
                        tmpNode.time = tmpNode.time - remain;
                        stack.add(tmpNode);
                        break;
                    } else {
                        remain-= tmpNode.time;
                        answer[idx++] = tmpNode.name;
                    }
                }
            } else {
                answer[idx++] = plans[i][0];
            }
        }
        answer[idx++] = plans[plans.length-1][0];
        while (!stack.isEmpty()){
            answer[idx++] = stack.pop().name;
        }
        return answer;
    }
}
