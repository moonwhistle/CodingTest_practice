import java.util.HashSet;
import java.util.Set;

class Solution {

    static boolean[] visited;

    public static int solution(String numbers) {
        int answer = 0;
        Set<Integer> nums = new HashSet<>();
        visited = new boolean[numbers.length()];
        combinationNumbers(new StringBuilder(), nums, numbers.toCharArray());

        for(int num : nums) {
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }

    private static void combinationNumbers(StringBuilder combinedNum, Set<Integer> nums, char[] numbers) {
        if (combinedNum.length() == numbers.length) {
            nums.add(Integer.valueOf(combinedNum.toString()));
            return;
        }

        if (combinedNum.length() != 0) {
            nums.add(Integer.valueOf(combinedNum.toString()));
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                combinedNum.append(numbers[i]);
                visited[i] = true;
                combinationNumbers(combinedNum, nums, numbers);
                combinedNum.delete(combinedNum.length() - 1, combinedNum.length());
                visited[i] = false;
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num == 1 || num == 0) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
