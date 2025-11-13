import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        int idx = 0;
        answer[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (answer[idx] != arr[i]) {
                idx++;
                answer[idx] = arr[i];
            }
        }

        return Arrays.copyOf(answer, idx + 1);
    }
}
