import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] answer = my_string.toCharArray();
        for (int[] query : queries) {
            Stack<Character> temp = new Stack<>();
            for (int i = query[0]; i < query[1] + 1; i++) {
                temp.add(answer[i]);
            }
            for (int i = query[0]; i < query[1] + 1; i++) {
                answer[i] = temp.pop();
            }
        }
        return String.valueOf(answer);
    }
}