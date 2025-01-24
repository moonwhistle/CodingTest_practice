import java.util.*;

public class Solution {
    public static int[] solution(int[] arr) {
        int[] answer;
        //세팅
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        //조건에 맞추어 넣기
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            if (stack.peek() != num) {
                stack.add(num);
            }
        }
        //배열 크기 선언
        answer = new int[stack.size()];
        //배열 크기에 맞추어 넣어주기
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}