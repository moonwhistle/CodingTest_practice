import java.util.Scanner;

public class Solution {

    static int start;
    static int[] dx = {1, -1, 0};
    static int[] dy = {0, 0, -1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int testCase = input.nextInt();
            int[][] map = new int[100][100];

            // set map
            for (int y = 0; y < 100; y++) {
                for (int x = 0; x < 100; x++) {
                    map[y][x] = input.nextInt();
                }
            }

            // 도착점
            int startX = 0;
            for (int x = 0; x < 100; x++) {
                if (map[99][x] == 2) {
                    startX = x;
                    break;
                }
            }

            // start dfs
            boolean[][] visited = new boolean[100][100];
            dfs(startX, 99, visited, map);

            System.out.println("#" + testCase + " " + start);
        }
    }

    private static void dfs(int x, int y, boolean[][] visited, int[][] map) {
        if (y == 0) {
            start = x;
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 3; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowX < 100 && nowY >= 0 && nowY < 100 && !visited[nowY][nowX] && map[nowY][nowX] == 1) {
                dfs(nowX, nowY, visited, map);
                return;
            } 
        }
    }
}
