import java.util.Scanner;

public class Solution {

    private static int[][] map = new int[16][16];
    private static boolean[][] visited;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static boolean isReach;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int test = input.nextInt();
            visited = new boolean[16][16];
            isReach = false;
            int startX = 0;
            int startY = 0;

            for (int y = 0; y < 16; y++) {
                String line = input.next();
                int x = 0;

                for (char lineElement : line.toCharArray()) {
                    map[y][x] = lineElement - '0';

                    if (map[y][x] == 2) {
                        startY = y;
                        startX = x;
                    }

                    x++;
                }
            }

            dfs(startX, startY);

            if (isReach) {
                System.out.println("#" + test + " " + 1);
            } else {
                System.out.println("#" + test + " " + 0);
            }
        }
    }

    private static void dfs(int startX, int startY) {
        if (map[startY][startX] == 3) {
            isReach = true;
            return;
        }

        visited[startY][startX] = true;

        for (int i = 0; i < 4; i++) {
            int y = startY + dy[i];
            int x = startX + dx[i];

            if (x >= 0 && y >= 0 && x < 16 && y < 16 && !visited[y][x] && map[y][x] != 1) {
                dfs(x, y);
            }
        }
    }
}
