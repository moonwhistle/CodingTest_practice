import java.util.Scanner;

public class Solution {

    static int[][] map;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = input.nextInt();
            map = new int[N][N];

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    map[y][x] = input.nextInt();
                }
            }

            String[][] result = new String[N][3];

            // 90
            transpose(N);
            reverseRow(N);

            for (int y = 0; y < N; y++) {
                int[] line = map[y];

                String lineResult = "";
                for (int lineElement : line) {
                    lineResult += lineElement;
                }

                result[y][0] = lineResult;
            }

            // 180
            transpose(N);
            reverseRow(N);

            for (int y = 0; y < N; y++) {
                int[] line = map[y];

                String lineResult = "";
                for (int lineElement : line) {
                    lineResult += lineElement;
                }

                result[y][1] = lineResult;
            }

            // 270
            transpose(N);
            reverseRow(N);

            for (int y = 0; y < N; y++) {
                int[] line = map[y];

                String lineResult = "";
                for (int lineElement : line) {
                    lineResult += lineElement;
                }

                result[y][2] = lineResult;
            }

            System.out.println("#" + i);
            for (int y = 0; y < N; y++) {
                System.out.println(result[y][0] + " " + result[y][1] + " " + result[y][2]);
            }
        }
    }

    private static void transpose(int N) {
        for (int y = 0; y < N; y++) {
            for (int x = y + 1; x < N; x++) {
                int temp = map[y][x];
                map[y][x] = map[x][y];
                map[x][y] = temp;
            }
        }
    }

    private static void reverseRow(int N) {
        for (int y = 0; y < N; y++) {
            int start = 0;
            int end = N - 1;

            while (start < end) {
                int temp = map[y][start];
                map[y][start] = map[y][end];
                map[y][end] = temp;
                start++;
                end--;
            }
        }
    }
}
