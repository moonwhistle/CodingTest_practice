import java.util.Scanner;

public class Main {

    static float[] nums;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        nums = new float[N];
        float max = Integer.MIN_VALUE;
        float sum = 0;

        for(int i = 0; i<N; i++) {
            int num = input.nextInt();
            max = Math.max(max, num);
            nums[i] = num;
        }

        for(int i = 0; i<N; i++) {
            nums[i] = nums[i] / max * 100;
            sum += nums[i];
        }

        System.out.println(sum / N);
    }
}
