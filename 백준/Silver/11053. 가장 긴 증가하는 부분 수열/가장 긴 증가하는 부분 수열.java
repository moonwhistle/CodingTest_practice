import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int[] nums = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = input.nextInt();
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i : dp) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}
