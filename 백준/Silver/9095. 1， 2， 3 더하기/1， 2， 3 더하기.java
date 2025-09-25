import java.util.Scanner;

public class Main {

    static int[] nums = new int[]{1, 2, 3};
    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        int[] cnt = new int[11];

        for(int i = 1; i< 11; i++) {
            count = 0;
            btk(0, i);
            cnt[i] = count;
        }

        for(int i = 0 ; i<T; i++) {
            int num = input.nextInt();
            System.out.println(cnt[num]);
        }

    }

    private static void btk(int sum, int target) {
        if(sum == target) {
            count++;
        }

        if(sum > target) {
            return;
        }

        for (int num : nums) {
            sum += num;
            btk(sum, target);
            sum -= num;
        }
    }
}
