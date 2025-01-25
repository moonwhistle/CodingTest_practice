import java.util.Stack;

class Solution {

    public static boolean solution(String s) {
        boolean answer = true;
        //세팅
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }

        return answer;
    }
}
