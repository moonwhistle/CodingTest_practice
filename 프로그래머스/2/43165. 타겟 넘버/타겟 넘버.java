class Solution {

    static int result = 0;

    public static void main(String[] args) {
        solution(new int[]{1, 1, 1, 1, 1}, 3);
    }

    public static int solution(int[] numbers, int target) {
        btk(numbers, target, 0, 0);
        return result;
    }

    private static void btk(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                result++;
            }

            return;
        }

        btk(numbers, target, idx + 1, sum + numbers[idx]);
        btk(numbers, target, idx + 1, sum - numbers[idx]);
    }
}
