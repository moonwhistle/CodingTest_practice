import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        int[] nums = new int[N + 1];
        nums[1] = 0;

        for (int i = 2; i < N + 1; i++) {
            nums[i] = nums[i-1] + 1;

            if(i % 3 == 0) {
                nums[i] = Math.min(nums[i], nums[i / 3] + 1);
            }

            if(i % 2 == 0) {
                nums[i] = Math.min(nums[i], nums[i / 2] + 1);
            }
        }

        System.out.println(nums[N]);
    }
}
