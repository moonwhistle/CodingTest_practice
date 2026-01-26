import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        int x = input.nextInt();
        int result = 0;
        Arrays.sort(nums);
        int start = 0;
        int end = n -1;

        while(start < end) {
            if(nums[start] + nums[end] == x) {
                result++;
                start++;
            } else if (nums[start] + nums[end] > x) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(result);
    }
}
