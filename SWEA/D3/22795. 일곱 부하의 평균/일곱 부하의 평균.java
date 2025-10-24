import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        input.nextLine();

        for (int i = 0; i < T; i++) {
            int sum = 0;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < 6; j++) {
                int height = input.nextInt();
                max = Math.max(max, height);
                sum += height;
            }

            while (true) {
                max++;

                double result = (double) (sum + max) / 7;

                if (isInteger(result)) {
                    break;
                }
            }

            System.out.println(max);
        }
    }

    private static boolean isInteger(double num) {
        return num == (int) num;
    }
}
