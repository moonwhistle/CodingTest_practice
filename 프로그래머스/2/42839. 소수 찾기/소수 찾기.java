import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {

    static boolean[] visited;
    static Set<Integer> nums = new HashSet<>();

    public static int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        btk(numbers, "");

        for (int num : nums) {
            if (num < 2) {
                continue;
            }

            int divideCount = 0;
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    divideCount++;
                }
            }

            if (divideCount == 0) {
                answer++;
            }
        }
        
        return answer;
    }

    private static void btk(String numbers, String num) {
        if (!Objects.equals(num, "")) {
            nums.add(Integer.parseInt(num));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                btk(numbers, num + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
}
