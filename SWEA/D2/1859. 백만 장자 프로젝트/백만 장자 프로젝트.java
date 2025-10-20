import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = input.nextInt();
            long[] nums = new long[N];

            for (int j = 0; j < N; j++) {
                nums[j] = input.nextInt();
            }

            int maxIdx = N - 1;
            long sum = 0;

            for (int j = N - 2; j >= 0; j--) {
                if (nums[maxIdx] < nums[j]) {
                    maxIdx = j;
                } else {
                    sum += nums[maxIdx] - nums[j];
                }
            }

            System.out.println("#" + i + " " + sum);
        }
    }
}
