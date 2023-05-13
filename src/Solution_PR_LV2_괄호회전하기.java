import java.util.Stack;
public class Solution_PR_LV2_괄호회전하기 {
    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            boolean isOk = true;
            for (int j = 0; j < s.length(); j++) {
                char tmp = s.charAt(j);

                if (stack.isEmpty()){
                    if(tmp == '(' || tmp == '{' || tmp == '['){
                        stack.push(tmp);
                    }else{
                        isOk = false;
                    }
                }else {
                    if(tmp == '(' || tmp == '{' || tmp == '['){
                        stack.push(tmp);
                    }else {
                        switch (stack.peek()){
                            case '(':
                                if(tmp == ')'){
                                    stack.pop();
                                }else {
                                    isOk = false;
                                }
                                break;
                            case '{':
                                if(tmp == '}'){
                                    stack.pop();
                                }else {
                                    isOk = false;
                                }
                                break;
                            case '[':
                                if(tmp == ']'){
                                    stack.pop();
                                }else {
                                    isOk = false;
                                }
                                break;
                        }
                    }
                }
                if(!isOk) break;


            }
            if(isOk && stack.isEmpty()) answer++;
            stack.clear();
            s = s.substring(1) + s.substring(0,1);

        }

        return answer;
    }
}
