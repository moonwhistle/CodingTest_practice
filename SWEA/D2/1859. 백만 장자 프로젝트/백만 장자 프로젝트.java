import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testCase = input.nextInt();

        for (int t = 1; t <= testCase; t++) {
            //setting
            int N = input.nextInt();
            long[] nums = new long[N];
            for (int i = 0; i < N; i++) {
                nums[i] = input.nextInt();
            }

            // 역순 탐색
            long sum = 0;
            long current = nums[N - 1];

            for (int i = N - 2; i >= 0; i--) {
                if(nums[i] > current) {
                    current = nums[i];
                } else {
                    sum += current - nums[i];
                }
            }

            System.out.println("#" + t + " " + sum);
        }
    }
}
