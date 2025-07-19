class Solution {

    static int count = 0;

    public static int solution(int[] nums) {
        combineAll(nums, 0, 0, 0);
        return count;
    }

    private static void combineAll(int[] nums, int start, int depth, int sum) {
        if (depth == 3) {
            if (isPrime(sum)) {
                count++;
            }
            return;
        }

        for(int i = start ;i<nums.length; i++) {
            combineAll(nums, i + 1, depth + 1, sum + nums[i]);
        }
    }

    private static boolean isPrime(int sum) {
        if(sum < 2) {
            return false;
        }

        for(int i = 2; i<=Math.sqrt(sum); i++) {
            if(sum % i == 0) {
                return false;
            }
        }

        return true;
    }
}
