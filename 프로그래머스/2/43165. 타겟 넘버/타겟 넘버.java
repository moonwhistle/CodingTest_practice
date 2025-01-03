class Solution {
    static int count = 0;
    
    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }

    public static void dfs(int[] numbers, int target, int depth, int sum) {
        if (numbers.length == depth) {
            if (sum == target) {
                count++;
                return;
            } else {
                return;
            }
        }

        int plus = sum + numbers[depth];
        int minus = sum - numbers[depth];

        dfs(numbers, target, depth + 1, plus);
        dfs(numbers, target, depth + 1, minus);
    }
}