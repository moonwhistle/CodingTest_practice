import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][] data;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        data = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = input.next();
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        BFS(0,0);

        System.out.println(data[N-1][M-1]);

    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int k = 0; k < 4; k++) {
                int x = current[0] + dx[k];
                int y = current[1] + dy[k];

                if (x >= 0 && x < data.length && y >= 0 && y < data[0].length) {
                    if (!visited[x][y] && data[x][y] == 1) {
                        data[x][y] = data[current[0]][current[1]] + 1;
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
