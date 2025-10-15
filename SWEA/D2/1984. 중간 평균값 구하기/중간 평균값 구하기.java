import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            int[] nums = new int[10];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < 10; j++) {
                nums[j] = input.nextInt();
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
            }

            Arrays.sort(nums);

            int sum = 0;
            int cnt = 0;

            for (int j = 0; j < 10; j++) {
                if (!(nums[j] == min || nums[j] == max)) {
                    sum += nums[j];
                    cnt++;
                }
            }

            long answer = Math.round((double) sum / cnt);
            System.out.println("#" + i + " " + answer);
        }
    }
}
