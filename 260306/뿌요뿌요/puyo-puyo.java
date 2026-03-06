import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int maxCount;
    static int count;
    static Set<Integer> set;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        maxCount = 0;
        set = new HashSet<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // Please write your code here.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    count = 0;
                    dfs(i, j, grid[i][j]);
                    maxCount = Math.max(maxCount, count);

                    if(count >= 4) {
                        set.add(grid[i][j]);
                    }
                }
            }
        }

        System.out.println(set.size() + " " + maxCount);
    }

    private static void dfs(int y, int x, int num) {
        if(visited[y][x]) {
            return;
        }

        visited[y][x] = true;
        count++;

        for(int i = 0 ; i < 4 ; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] || grid[ny][nx] != num) {
                continue;
            }

            dfs(ny, nx, num);
        }
    }
}
