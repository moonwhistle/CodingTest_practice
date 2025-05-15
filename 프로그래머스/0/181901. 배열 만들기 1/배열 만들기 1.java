import java.util.ArrayList;
import java.util.List;

class Solution {

    public static int[] solution(int n, int k) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int num = i * k;
            if (num > n) {
                break;
            }
            answer.add(num);
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
            System.out.println(result[i]);
        }
        return result;
    }
}
