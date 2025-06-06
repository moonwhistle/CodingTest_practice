import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    static List<Integer> sumOfNumbers = new ArrayList<>();

    public static int[] solution(int[] numbers) {
        int[] answer;
        
        backTracking(numbers, 0, 0, 0);
        Collections.sort(sumOfNumbers);
        
        answer = new int[sumOfNumbers.size()];

        for (int i = 0; i < sumOfNumbers.size(); i++) {
            answer[i] = sumOfNumbers.get(i);
        }
        
        return answer;
    }

    private static void backTracking(int[] numbers, int sum, int depth, int start) {
        if (depth == 2) {
            if (!sumOfNumbers.contains(sum)) {
                sumOfNumbers.add(sum);
            }
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            backTracking(numbers, sum + numbers[i], depth + 1, i + 1);
        }
    }
}
