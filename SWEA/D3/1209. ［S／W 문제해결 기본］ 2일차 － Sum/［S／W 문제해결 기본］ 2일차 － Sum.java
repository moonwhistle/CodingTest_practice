import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // setting
        int T = 10;

        for (int test = 0; test < T; test++) {
            int[][] nums = new int[100][100];
            int testNumber = input.nextInt();
            int max = Integer.MIN_VALUE;

            // input
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    nums[i][j] = input.nextInt();
                }
            }

            // 행 열 합
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int columnSum = 0;

                for (int j = 0; j < 100; j++) {
                    rowSum += nums[i][j];
                    columnSum += nums[j][i];
                }

                max = Math.max(max, rowSum);
                max = Math.max(max, columnSum);
            }

            // 대각선의 합
            int upCrossSum = 0;
            int downCrossSum = 0;

            for (int i = 0; i < 100; i++) {
                upCrossSum += nums[i][i];
                downCrossSum += nums[99-i][i];
            }

            max = Math.max(max, upCrossSum);
            max = Math.max(max, downCrossSum);

            System.out.println("#" + testNumber + " " + max);
        }
    }
}
