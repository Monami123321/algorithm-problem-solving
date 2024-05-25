import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        int len = s.length();
        while(index < len) {
            if(s.charAt(index++) == '(') {
                stack.push('(');
            } else {
                if(stack.isEmpty() || stack.pop() == ')') {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}