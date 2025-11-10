import java.util.Scanner;

public class Solution {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            max = Integer.MIN_VALUE;
            int[][] map = new int[100][100];
            int test = input.nextInt();

            // set map
            for (int y = 0; y < 100; y++) {
                for (int x = 0; x < 100; x++) {
                    map[y][x] = input.nextInt();
                }
            }

            // row, col
            for (int y = 0; y < 100; y++) {
                int rowSum = 0;
                int colSum = 0;

                for (int x = 0; x < 100; x++) {
                    rowSum += map[y][x];
                    colSum += map[x][y];
                }

                max = Math.max(rowSum, max);
                max = Math.max(colSum, max);
            }

            // 대각선
            int up = 0;
            int down = 0;

            int y = 0;
            int x = 0;

            for (int j = 0; j < 100; j++) {
                down += map[y][x];
                up += map[99 - y][x];

                y++;
                x++;
            }

            max = Math.max(up, max);
            max = Math.max(down, max);

            System.out.println("#" + test + " " + max);
        }
    }
}
