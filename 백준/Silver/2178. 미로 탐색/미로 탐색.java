import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] distance;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        int[][] map = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = input.next();
            int j = 0;

            for (char lineElement : line.toCharArray()) {
                map[i][j] = lineElement - '0';
                j++;
            }
        }

        go(0, 0, map);

        System.out.println(distance[map.length - 1][map[0].length - 1]);
    }

    private static void go(int startX, int startY, int[][] map) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        distance[startX][startY] = 1;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            int nowX = point[0];
            int nowY = point[1];

            for (int i = 0; i < 4; i++) {
                int x = nowX + dx[i];
                int y = nowY + dy[i];

                if (x >= 0 && y >= 0 && x < map.length && y < map[0].length && map[x][y] == 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    distance[x][y] = distance[nowX][nowY] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }
}
