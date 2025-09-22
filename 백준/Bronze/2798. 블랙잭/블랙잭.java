import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();
        int[] nums = new int[N];

        for(int i = 0; i<nums.length; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i< nums.length-2; i++) {
            int delimiter = nums[i];

            int start = i + 1;
            int end = nums.length - 1;

            while(start < end) {
                int sum = delimiter + nums[start] + nums[end];

                if(sum > M) {
                    end--;
                } else {
                    start++;
                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }
}
