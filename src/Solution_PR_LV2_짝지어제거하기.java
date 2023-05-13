import java.util.Stack;

public class Solution_PR_LV2_짝지어제거하기 {
    public int solution(String s)
    {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(stack.isEmpty()) stack.push(tmp);
            else{
                if(stack.peek() == tmp) stack.pop();
                else stack.push(tmp);
            }
        }
        if(stack.isEmpty()) return 1;

        return answer;
    }
}
