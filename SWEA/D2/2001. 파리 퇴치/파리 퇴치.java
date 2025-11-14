import java.util.Scanner;

class Solution {

    static int[][] map;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = input.nextInt();
            int M = input.nextInt();
            map = new int[N][N];

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    int num = input.nextInt();

                    if (x == 0) {
                        map[y][x] = num;
                    } else {
                        map[y][x] = num + map[y][x - 1];
                    }
                }
            }

            int max = Integer.MIN_VALUE;

            for (int y = 0; y < N - M + 1; y++) {
                for (int x = M - 1; x < N; x++) {
                    int sum = 0;

                    for (int yy = y; yy < y + M; yy++) {
                        if (x == M - 1) {
                            sum += map[yy][x];
                        } else {
                            sum += map[yy][x] - map[yy][x - M];
                        }
                    }

                    max = Math.max(sum, max);
                }
            }

            System.out.println("#" + i + " " + max);
        }
    }
}
