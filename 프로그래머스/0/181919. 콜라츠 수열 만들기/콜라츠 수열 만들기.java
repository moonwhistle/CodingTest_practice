import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int x = n;
        answer.add(x);
        while (x != 1) {
            if (x % 2 == 0) {
                x = x / 2;
            } else {
                x = 3 * x + 1;
            }
            answer.add(x);
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

