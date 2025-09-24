import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static Queue<int[]> points = new LinkedList<>();

    public static void main(String[] args) {

        int M = input.nextInt();
        int N = input.nextInt();

        map = new int[N][M];
        setMap(N, M);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    points.add(new int[]{i, j});
                }
            }
        }

        bfs();

        System.out.println(findDate());
    }

    private static int findDate() {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 0) {
                    return -1;
                }

                max = Math.max(max, map[i][j]);
            }
        }

        return max - 1;
    }

    private static void bfs() {
         while (!points.isEmpty()) {
            int[] point = points.poll();

            for (int i = 0; i < 4; i++) {
                int x = dx[i] + point[0];
                int y = dy[i] + point[1];

                if (x >= 0 && y >= 0 && x < map.length && y < map[0].length && map[x][y] == 0) {
                    map[x][y] = map[point[0]][point[1]] + 1;
                    points.add(new int[]{x, y});
                }
            }
        }
    }

    private static void setMap(int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = input.nextInt();
            }
        }
    }
}
