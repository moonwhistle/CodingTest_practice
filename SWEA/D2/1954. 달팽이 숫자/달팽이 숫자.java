import java.util.Scanner;

public class Solution {

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = input.nextInt();
            int[][] map = new int[N][N];
            makeMap(map, N);

            System.out.println("#" + i);
            for (int[] line : map) {
                for (int lineElement : line) {
                    System.out.print(lineElement + " ");
                }
                System.out.println();
            }
        }
    }

    private static void makeMap(int[][] map, int N) {
        int max = N * N;

        int x = 0;
        int y = 0;
        int i = 1;
        int direction = 0;

        while (i <= max) {
            map[y][x] = i;
            i++;

            int nowX = x + dx[direction];
            int nowY = y + dy[direction];

            if (nowY < 0 || nowX < 0 || nowX >= N || nowY >= N || map[nowY][nowX] != 0) {
                direction = (direction + 1) % 4;
                nowX = x + dx[direction];
                nowY = y + dy[direction];
            }

            x = nowX;
            y = nowY;
        }
    }
}
