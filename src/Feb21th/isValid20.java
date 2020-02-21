package Feb21th;

import java.util.Stack;

public class isValid20 {
    // 用一个栈维护一下即可
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char val = s.charAt(i);
            if(val == '(' || val == '{' || val == '['){
                stack.push(val);
            } else if(val == ')'){
                if(stack.isEmpty() || stack.pop() != '(')
                    return false;
            } else if(val == '}'){
                if(stack.isEmpty() || stack.pop() != '{')
                    return false;
            } else if(val == ']'){
                if(stack.isEmpty() || stack.pop() != '[')
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
