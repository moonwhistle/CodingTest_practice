import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = input.nextInt();
            int M = input.nextInt();

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = input.nextInt();
                }
            }

            int max = Integer.MIN_VALUE;

            for (int col = 0; col <= N - M; col++) {
                for (int row = 0; row <= N - M; row++) {
                    int sum = 0;

                    for (int y = col; y < col + M; y++) {
                        for (int x = row; x < row + M; x++) {
                            sum += map[y][x];
                        }
                    }

                    max = Math.max(max, sum);
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }
}
