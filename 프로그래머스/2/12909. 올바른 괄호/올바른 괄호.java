import java.util.Queue;
import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] sArray = s.toCharArray();
        Stack<Character> box = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (sArray[i] == '(') {
                box.add(sArray[i]);
            } else {
                if (box.isEmpty()) {
                    answer = false;
                    break;
                } else if (box.peek() == '(') {
                    box.pop();
                }
            }
        }

        if (!box.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
