import java.util.Stack;

public class Solution_PR_LV2_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp == '('){
                stack.push(1);
            }
            if(tmp == ')'){
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;

        return answer;
    }
}
