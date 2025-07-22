import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static int[] solution(int[] numbers) {
        Set<Integer> resultSet = new HashSet<>();
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                resultSet.add(numbers[i] + numbers[j]);
            }
        }

        return resultSet.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
