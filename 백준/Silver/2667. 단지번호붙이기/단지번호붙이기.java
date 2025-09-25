import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static List<Integer> box = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // setting
        int N = input.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = input.next();

            int j = 0;
            for (char lineElement : line.toCharArray()) {
                map[i][j] = lineElement - '0';
                j++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int cnt = dfs(j, i);
                    box.add(cnt);
                }
            }
        }

        Collections.sort(box);

        System.out.println(box.size());
        for(int i : box) {
            System.out.println(i);
        }
    }

    private static int dfs(int startX, int startY) {
        visited[startY][startX] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int x = dx[i] + startX;
            int y = dy[i] + startY;

            if (x >= 0 && y >= 0 && x < map[0].length && y < map.length) {
                if (!visited[y][x] && map[y][x] == 1) {
                    cnt += dfs(x, y);
                }
            }
        }

        return cnt;
    }
}
