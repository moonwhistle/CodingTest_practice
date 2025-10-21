import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int test = 1; test <= T; test++) {
            int N = input.nextInt();
            int[] nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = input.nextInt();
            }

            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < N; i++) {
                sum += Math.abs(nums[i] - nums[i - 1]);
            }

            for (int i = 1; i < N - 1; i++) {
                int front = Math.abs(nums[i] - nums[i - 1]);
                int back = Math.abs(nums[i + 1] - nums[i]);
                int between = Math.abs(nums[i + 1] - nums[i - 1]);
                sum = sum - (front + back) + between;
                min = Math.min(sum, min);
                sum = sum + (front + back) - between;
            }

            System.out.println(min);
        }
    }
}
