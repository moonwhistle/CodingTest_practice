import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int test = 1; test <= T; test++) {
            // setting
            int N = input.nextInt();
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = input.next();
                int x = 0;

                for (String lineElement : line.split("")) {
                    map[i][x] = Integer.parseInt(lineElement);
                    x++;
                }
            }

            int sum = 0;
            int cnt = 0;

            for (int i = N / 2; i >= 0; i--) {
                for (int j = cnt; j < N - cnt; j++) {
                    if (cnt != 0) {
                        sum += map[(N / 2) + cnt][j];
                    }

                    sum += map[i][j];
                }

                cnt++;
            }

            System.out.println("#" + test + " " + sum);
        }
    }
}
